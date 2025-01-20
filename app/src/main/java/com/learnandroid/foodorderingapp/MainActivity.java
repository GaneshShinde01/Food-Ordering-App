package com.learnandroid.foodorderingapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.learnandroid.foodorderingapp.Adapters.MainAdapter;
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
}