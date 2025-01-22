package com.learnandroid.foodorderingapp;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.learnandroid.foodorderingapp.Adapters.MainAdapter;
import com.learnandroid.foodorderingapp.Fragments.OrderFragment;
import com.learnandroid.foodorderingapp.Models.MainModel;
import com.learnandroid.foodorderingapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFramgent(new OrderFragment());
            }
        });

        ArrayList<MainModel> list = new ArrayList<>();

        list.add(new MainModel(R.drawable.paneer,"Panner Masala","10","Paneer Masala, one of our most ordered fish"));
        list.add(new MainModel(R.drawable.baingan,"Baingan","8","Paneer Masala, one of our most ordered fish"));
        list.add(new MainModel(R.drawable.bhindimasala,"Bhindi Masala","9","Paneer Masala, one of our most ordered fish"));
        list.add(new MainModel(R.drawable.daltadka,"Daltadka ","6","Paneer Masala, one of our most ordered fish"));
        list.add(new MainModel(R.drawable.kababpaneer,"Kababpaneer","11.5","Paneer Masala, one of our most ordered fish"));
        list.add(new MainModel(R.drawable.mashroom,"Mashroom ","15","Paneer Masala, one of our most ordered fish"));
        list.add(new MainModel(R.drawable.palakpanner,"Palakpanner ","10","Paneer Masala, one of our most ordered fish"));

        MainAdapter adapter = new MainAdapter(list,this);
        binding.foodListRv.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.foodListRv.setLayoutManager(layoutManager);
    }

    private void loadFramgent(Fragment frament) {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame,frament);
        ft.commit();
    }
}