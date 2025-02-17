package com.learnandroid.foodorderingapp;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.learnandroid.foodorderingapp.Fragments.HomeFragment;
import com.learnandroid.foodorderingapp.Fragments.OrderFragment;
import com.learnandroid.foodorderingapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadFramgent(new HomeFragment());

        binding.bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if (id == R.id.navHome) {
                    loadFramgent(new HomeFragment());
                } else if (id == R.id.navOrders) {
                    loadFramgent(new OrderFragment());
                } else if (id == R.id.navProfile) {
                    loadFramgent(new OrderFragment());
                }else {
                    loadFramgent(new HomeFragment());
                }

                return true;
            }
        });


    }


    private void loadFramgent (Fragment frament){

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame, frament);
        ft.commit();
    }
}