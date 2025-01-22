package com.learnandroid.foodorderingapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.learnandroid.foodorderingapp.Models.OrderModel;
import com.learnandroid.foodorderingapp.R;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    ArrayList<OrderModel> orderList;
    Context context;

    public OrderAdapter(ArrayList<OrderModel> orderList, Context context) {
        this.orderList = orderList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.sample_order,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.ordered_food_Image.setImageResource(orderList.get(position).getOrdered_food_image());
        holder.ordered_food_name.setText(orderList.get(position).getOrdered_food_name());
        holder.ordered_food_price.setText(orderList.get(position).getOrdered_food_price());
        holder.ordered_number.setText(orderList.get(position).getOrdered_number());
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ordered_food_Image;
        TextView ordered_food_name, ordered_food_price, ordered_number;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ordered_food_Image = itemView.findViewById(R.id.ordered_food_image);
            ordered_food_name = itemView.findViewById(R.id.ordered_food_name);
            ordered_food_price = itemView.findViewById(R.id.ordered_food_price);
            ordered_number = itemView.findViewById(R.id.order_number);
        }
    }
}
