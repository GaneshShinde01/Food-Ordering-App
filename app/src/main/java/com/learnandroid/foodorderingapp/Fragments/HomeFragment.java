package com.learnandroid.foodorderingapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.learnandroid.foodorderingapp.Adapters.HomeAdapter;
import com.learnandroid.foodorderingapp.Models.HomeModel;
import com.learnandroid.foodorderingapp.R;
import com.learnandroid.foodorderingapp.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater,container,false);


        ArrayList<HomeModel> list = new ArrayList<>();

        list.add(new HomeModel(R.drawable.paneer,"Panner Masala","10","Paneer Masala, one of our most ordered fish"));
        list.add(new HomeModel(R.drawable.baingan,"Baingan","8","Paneer Masala, one of our most ordered fish"));
        list.add(new HomeModel(R.drawable.bhindimasala,"Bhindi Masala","9","Paneer Masala, one of our most ordered fish"));
        list.add(new HomeModel(R.drawable.daltadka,"Daltadka ","6","Paneer Masala, one of our most ordered fish"));
        list.add(new HomeModel(R.drawable.kababpaneer,"Kababpaneer","11.5","Paneer Masala, one of our most ordered fish"));
        list.add(new HomeModel(R.drawable.mashroom,"Mashroom ","15","Paneer Masala, one of our most ordered fish"));
        list.add(new HomeModel(R.drawable.palakpanner,"Palakpanner ","10","Paneer Masala, one of our most ordered fish"));

        HomeAdapter adapter = new HomeAdapter(list, new HomeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(HomeModel homeModel) {
                // Passing data to FragmentB
                Bundle bundle = new Bundle();
                bundle.putInt("ordered_food_image", homeModel.getImage());
                bundle.putString("ordered_food_name", homeModel.getName());
                bundle.putString("ordered_food_price", homeModel.getPrice());
                bundle.putString("ordered_description", homeModel.getDescription());
                bundle.putInt("type",1);
                FoodDetailFragment fragmentB = new FoodDetailFragment();
                fragmentB.setArguments(bundle);

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame, fragmentB)
                        .addToBackStack(null)
                        .commit();
            }
        });
        binding.foodListRv.setAdapter(adapter);

//        FoodDetailFragment fragment = new FoodDetailFragment();
//        getChildFragmentManager().beginTransaction().replace(R.id.foodDetailsContainer,new FoodDetailFragment()).commit();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.foodListRv.setLayoutManager(layoutManager);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}