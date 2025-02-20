package com.learnandroid.foodorderingapp.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.learnandroid.foodorderingapp.Fragments.FoodDetailFragment;
import com.learnandroid.foodorderingapp.Models.HomeModel;
import com.learnandroid.foodorderingapp.R;
import com.learnandroid.foodorderingapp.databinding.SampleMainfoodBinding;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.viewHolder>{

    SampleMainfoodBinding binding;
    ArrayList<HomeModel> list;
    Context context;

    public HomeAdapter(ArrayList<HomeModel> list, Context context) {

        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.sample_mainfood,parent,false);
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

                Bundle bundle = new Bundle();
                bundle.putInt("image",model.getImage());
                bundle.putString("name",model.getName());
                bundle.putString("price",model.getPrice());
                bundle.putString("desc",model.getDescription());

                FoodDetailFragment fragment = new FoodDetailFragment();
                fragment.setArguments(bundle);

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

    /*private void loadFramgent (Fragment frament){

        FragmentManager fm =
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame, frament,frament.getClass().getSimpleName());
        ft.commit();
    }*/
}
