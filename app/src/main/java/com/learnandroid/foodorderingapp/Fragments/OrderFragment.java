package com.learnandroid.foodorderingapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.learnandroid.foodorderingapp.Adapters.OrderAdapter;
import com.learnandroid.foodorderingapp.DBHelper;
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
        binding  = FragmentOrderBinding.inflate(inflater, container, false);

        //ArrayList<OrderModel> orderModelArrayList = new ArrayList<>();

//
//        orderModelArrayList.add(new OrderModel(R.drawable.palakpanner,"palakpanner","15","6846554"));
//        orderModelArrayList.add(new OrderModel(R.drawable.paneer,"palakpanner","15","6846554"));
//        orderModelArrayList.add(new OrderModel(R.drawable.kababpaneer,"palakpanner","15","6846554"));
//        orderModelArrayList.add(new OrderModel(R.drawable.daltadka,"palakpanner","15","6846554"));
//        orderModelArrayList.add(new OrderModel(R.drawable.baingan,"palakpanner","15","6846554"));
//        orderModelArrayList.add(new OrderModel(R.drawable.baingan,"palakpanner","15","6846554"));
        DBHelper dbHelper = new DBHelper(getContext());
        ArrayList<OrderModel> list  = dbHelper.getOrders();


        //System.out.println("list="+orderModelArrayList);
        OrderAdapter orderAdapter = new OrderAdapter(list, new OrderAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(OrderModel orderModel) {
                Bundle bundle = new Bundle();
                bundle.putInt("id", Integer.parseInt(orderModel.getOrdered_number()));
                bundle.putInt("type", 2);

                FoodDetailFragment fragmentB = new FoodDetailFragment();
                fragmentB.setArguments(bundle);

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame, fragmentB)
                        .addToBackStack(null)
                        .commit();
            }
        });
        binding.orderListRv.setAdapter(orderAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.orderListRv.setLayoutManager(layoutManager);

        return binding.getRoot();
    }
}