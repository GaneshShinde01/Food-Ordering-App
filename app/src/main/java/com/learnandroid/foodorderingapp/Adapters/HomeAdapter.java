package com.learnandroid.foodorderingapp.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.learnandroid.foodorderingapp.Fragments.FoodDetailFragment;
import com.learnandroid.foodorderingapp.Models.HomeModel;
import com.learnandroid.foodorderingapp.R;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.viewHolder> {

    ArrayList<HomeModel> list;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(HomeModel homeModel);
    }


    public HomeAdapter(ArrayList<HomeModel> list, OnItemClickListener listener) {
        this.list = list;
        this.listener = listener;

    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_mainfood, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final HomeModel model = list.get(position);

        holder.food_image.setImageResource(model.getImage());
        holder.food_name.setText(model.getName());
        holder.food_current_price.setText(model.getPrice());
        holder.food_description.setText(model.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listener.onItemClick(model);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView food_image;
        TextView food_name, food_current_price, food_description;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            food_image = itemView.findViewById(R.id.food_image);
            food_name = itemView.findViewById(R.id.food_name);
            food_current_price = itemView.findViewById(R.id.food_current_price);
            food_description = itemView.findViewById(R.id.food_description);
        }
    }
}
