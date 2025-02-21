package com.learnandroid.foodorderingapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.learnandroid.foodorderingapp.R;
import com.learnandroid.foodorderingapp.databinding.FragmentFoodDetailBinding;

public class FoodDetailFragment extends Fragment {
    FragmentFoodDetailBinding binding;
    ImageView order_details_image;
    TextView detail_food_name, final_price, detail_description;

    public FoodDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFoodDetailBinding.inflate(inflater,container,false);

        Bundle bundle = getArguments();

        if (bundle != null) {
/*
            int image = bundle.getInt("image", 0);
            int price = Integer.parseInt(bundle.getString("price")); // Ensure "price" is a string if using this
            String name = bundle.getString("name");
            String desc = bundle.getString("desc");

            binding.orderDetailsImage.setImageResource(image);
            binding.detailFoodName.setText(name);
            binding.finalPrice.setText(String.valueOf(price)); // Corrected this line
            binding.detailDescription.setText(desc);*/


            binding.orderDetailsImage.setImageResource(bundle.getInt("ordered_food_image"));
            binding.detailFoodName.setText(bundle.getString("ordered_food_name"));
            binding.finalPrice.setText(bundle.getString("ordered_food_price"));
            binding.detailDescription.setText(bundle.getString("ordered_description"));
        }


        return binding.getRoot();
    }
}