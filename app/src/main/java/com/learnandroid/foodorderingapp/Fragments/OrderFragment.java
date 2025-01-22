package com.learnandroid.foodorderingapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.learnandroid.foodorderingapp.Adapters.OrderAdapter;
import com.learnandroid.foodorderingapp.Models.OrderModel;
import com.learnandroid.foodorderingapp.R;
import com.learnandroid.foodorderingapp.databinding.FragmentOrderBinding;

import java.util.ArrayList;

public class OrderFragment extends Fragment {
    FragmentOrderBinding binding;


    public OrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding  = FragmentOrderBinding.inflate(inflater, container, false);

        ArrayList<OrderModel> orderModelArrayList = new ArrayList<>();


        orderModelArrayList.add(new OrderModel(R.drawable.mashroom,"Mashroom","15","6846554"));
        orderModelArrayList.add(new OrderModel(R.drawable.mashroom,"Mashroom","15","6846554"));
        orderModelArrayList.add(new OrderModel(R.drawable.mashroom,"Mashroom","15","6846554"));
        orderModelArrayList.add(new OrderModel(R.drawable.mashroom,"Mashroom","15","6846554"));
        orderModelArrayList.add(new OrderModel(R.drawable.mashroom,"Mashroom","15","6846554"));

        //System.out.println("list="+orderModelArrayList);
        OrderAdapter orderAdapter = new OrderAdapter(orderModelArrayList,getContext());
        binding.orderListRv.setAdapter(orderAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.orderListRv.setLayoutManager(layoutManager);

        return binding.getRoot();
    }
}