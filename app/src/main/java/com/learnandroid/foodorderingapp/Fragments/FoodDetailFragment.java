package com.learnandroid.foodorderingapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

        return binding.getRoot();
    }
}