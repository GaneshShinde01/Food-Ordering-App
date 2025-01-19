package com.learnandroid.foodorderingapp.Adapters;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.learnandroid.foodorderingapp.databinding.SampleMainfoodBinding;

public class MainAdapter {

    SampleMainfoodBinding binding;

    public class viewHolder extends RecyclerView.ViewHolder{

        public viewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
