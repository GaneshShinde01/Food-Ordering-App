package com.learnandroid.foodorderingapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.learnandroid.foodorderingapp.R;
import com.learnandroid.foodorderingapp.databinding.FragmentFoodDetailBinding;

public class FoodDetailFragment extends Fragment {
    FragmentFoodDetailBinding binding;


    public FoodDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFoodDetailBinding.inflate(inflater,container,false);

        Bundle bundle = getArguments();

        if (bundle != null){

            int image = bundle.getInt("image",0);
            int price = Integer.parseInt(bundle.getString("price"));
            String name = bundle.getString("name");
            String desc = bundle.getString("desc");

           binding.orderDetailsImage.setImageResource(image);
           binding.detailFoodName.setText(name);
           binding.finalPrice.setText(Integer.parseInt(String.format("%d",price)));
           binding.detailDescription.setText(desc);

        }

        return binding.getRoot();
    }
}