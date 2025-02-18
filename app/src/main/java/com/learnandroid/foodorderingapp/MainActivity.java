package com.learnandroid.foodorderingapp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
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
    private boolean doubleBackToExitPressedOnce = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        // Load the default fragment (Home1Fragment) initially
        if (savedInstanceState == null) {
            loadFramgent(new HomeFragment());
        }


        loadFramgent(new HomeFragment());

        binding.bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();
                Fragment selectedFragment = null;

                if (itemId == R.id.navHome) {
                    selectedFragment = getSupportFragmentManager().findFragmentByTag(HomeFragment.class.getSimpleName());
                    if (selectedFragment == null) {
                        selectedFragment = new HomeFragment();
                    }

                } else if (itemId == R.id.navOrders) {

                    selectedFragment = getSupportFragmentManager().findFragmentByTag(OrderFragment.class.getSimpleName());
                    if (selectedFragment == null) {
                        selectedFragment = new OrderFragment();
                    }

                } else if (itemId == R.id.navProfile) {

                    selectedFragment = getSupportFragmentManager().findFragmentByTag(OrderFragment.class.getSimpleName());
                    if (selectedFragment == null) {
                        selectedFragment = new OrderFragment();
                    }
                }  else {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    return false;
                }

                loadFramgent(selectedFragment);
                return true;

            }
        });


        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {


                Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.frame);
                // If the current fragment is not Home1Fragment, go to Home1Fragment
                if (!(currentFragment instanceof HomeFragment)) {
                    loadFramgent(new HomeFragment());
                    binding.bottomNav.setSelectedItemId(R.id.navHome);  // Set the home item selected

                } else {
                    // If already in Home1Fragment, handle double back press to exit
                    if (doubleBackToExitPressedOnce) {
                        finish();
                    } else {
                        doubleBackToExitPressedOnce = true;
                        Toast.makeText(MainActivity.this, "Press back again to exit", Toast.LENGTH_SHORT).show();

                        // Reset the flag after 2 seconds
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                doubleBackToExitPressedOnce = false;
                            }
                        }, 2000);
                    }
                }
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