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

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.viewHolder>{

    ArrayList<OrderModel> list;
    Context context;

    public OrderAdapter(ArrayList<OrderModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view  = LayoutInflater.from(context).inflate(R.layout.fragment_order,parent,false);

        return new viewHolder(view);
    }

    @NonNull
    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

       // final OrderModel model =  list.get(position);
        //System.out.println(list.get(position));
       // System.out.println(model.getOrdered_food_image());
        //holder.ordered_food_image.setImageResource(Integer.parseInt(list.get(position).getOrdered_food_image()));
        holder.ordered_food_image.setImageResource(list.get(position).getOrdered_food_image());
        holder.ordered_food_name.setText(list.get(position).getOrdered_food_name());
        holder.order_number.setText(list.get(position).getOrdered_number());
        holder.ordered_food_price.setText(list.get(position).getOrdered_food_price());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        ImageView ordered_food_image;
        TextView ordered_food_name, order_number, ordered_food_price;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            ordered_food_image = itemView.findViewById(R.id.ordered_food_image);
            ordered_food_name = itemView.findViewById(R.id.ordered_food_name);
            order_number = itemView.findViewById(R.id.order_number);
            ordered_food_price = itemView.findViewById(R.id.ordered_food_price);
        }
    }
}
