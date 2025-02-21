package com.learnandroid.foodorderingapp.Fragments;

import android.database.Cursor;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.learnandroid.foodorderingapp.DBHelper;
import com.learnandroid.foodorderingapp.databinding.FragmentFoodDetailBinding;
import java.util.Objects;

public class FoodDetailFragment extends Fragment {
    FragmentFoodDetailBinding binding;

    String originalName,originalFoodName, originalPhone, originalDescription;
    int originalNumberOfItems;
    double originalPrice;
    int originalImage;

    public FoodDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFoodDetailBinding.inflate(inflater, container, false);

        Bundle bundle = getArguments();
        if (bundle == null) {
            Toast.makeText(getContext(), "Error: No data found!", Toast.LENGTH_SHORT).show();
            return binding.getRoot();  // Early return if the bundle is null
        }

        final DBHelper dbHelper = new DBHelper(getContext());

        // Validate bundle data
        int image = bundle.getInt("ordered_food_image", 0);  // Use default value if missing
        double price;
        try {
            price = Double.parseDouble(Objects.requireNonNull(bundle.getString("ordered_food_price", "0.0")));
        } catch (NumberFormatException e) {
            Toast.makeText(getContext(), "Invalid price format!", Toast.LENGTH_SHORT).show();
            return binding.getRoot();  // Early return if price parsing fails
        }
        String name = bundle.getString("ordered_food_name", "Unknown Food");
        String description = bundle.getString("ordered_description", "No Description");

        if (bundle.getInt("type", 0) == 1) {
            // Insert operation
            binding.orderDetailsImage.setImageResource(image);
            binding.detailFoodName.setText(name);
            binding.finalPrice.setText(String.valueOf(price));
            binding.detailDescription.setText(description);

            binding.orderNowbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isInserted = dbHelper.insertOrder(
                            binding.nameBox.getText().toString(),
                            binding.phoneBox.getText().toString(),
                            price,
                            Integer.parseInt(binding.numberOfItems.getText().toString()),
                            image,
                            description,
                            name
                    );

                    if (isInserted)
                        Toast.makeText(getContext(), "Order placed successfully!", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(getContext(), "Order placement failed!", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            // Handle update case
            int id = bundle.getInt("id", 0);
            Cursor cursor = dbHelper.getOrderById(id);
            if (cursor != null && cursor.moveToFirst()) {
                // Store original values from the cursor
                originalImage = cursor.getInt(5);
                originalFoodName = cursor.getString(7);  // Assuming column 7 is the food name
                originalName = cursor.getString(1);
                originalPrice = cursor.getDouble(3);
                originalDescription = cursor.getString(6);
                originalNumberOfItems = cursor.getInt(4);
                originalPhone = cursor.getString(2);

                // Populate the fields with cursor data
                binding.orderDetailsImage.setImageResource(originalImage);
                binding.detailFoodName.setText(originalFoodName);
                binding.finalPrice.setText(String.valueOf(originalPrice));
                binding.detailDescription.setText(originalDescription);
                binding.nameBox.setText(originalName);
                binding.phoneBox.setText(originalPhone);
                binding.numberOfItems.setText(String.valueOf(originalNumberOfItems));

                // Set button for updating
                binding.orderNowbtn.setText("Update Now");
                binding.orderNowbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Check if each field has been modified, if not, use original value
                        String updatedName = !binding.nameBox.getText().toString().isEmpty() ?
                                binding.nameBox.getText().toString() : originalName;


                        String updatedPhone = !binding.phoneBox.getText().toString().isEmpty() ?
                                binding.phoneBox.getText().toString() : originalPhone;

                        int updatedNumberOfItems = !binding.numberOfItems.getText().toString().isEmpty() ?
                                Integer.parseInt(binding.numberOfItems.getText().toString()) : originalNumberOfItems;



                        boolean isUpdated = dbHelper.updateOrder(id, updatedName, updatedPhone,
                                originalPrice, updatedNumberOfItems, originalImage, originalDescription, originalFoodName);

                        if (isUpdated) {
                            Toast.makeText(getContext(), "Order updated successfully!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getContext(), "Order update failed!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }

        return binding.getRoot();
    }
}
