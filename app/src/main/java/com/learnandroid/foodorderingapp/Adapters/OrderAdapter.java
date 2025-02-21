package com.learnandroid.foodorderingapp.Adapters;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.learnandroid.foodorderingapp.DBHelper;
import com.learnandroid.foodorderingapp.Models.OrderModel;
import com.learnandroid.foodorderingapp.R;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    ArrayList<OrderModel> orderList;
    private OnItemClickListener listener;


    public interface OnItemClickListener {
        void onItemClick(OrderModel orderModel);
    }


    public OrderAdapter(ArrayList<OrderModel> orderList, OnItemClickListener listener) {
        this.orderList = orderList;
        this.listener = listener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_order,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        OrderModel model = orderList.get(position);
        holder.ordered_food_Image.setImageResource(model.getOrdered_food_image());
        holder.ordered_food_name.setText(model.getOrdered_food_name());
        holder.ordered_food_price.setText(model.getOrdered_food_price());
        holder.ordered_number.setText(model.getOrdered_number());

       /* holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("image",model.getOrdered_food_image());
                bundle.putString("name",model.getOrdered_food_name());
                bundle.putString("price",model.getOrdered_food_price());
                bundle.putString("number",model.getOrdered_number());
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });*/

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listener.onItemClick(model);

            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                new AlertDialog.Builder(v.getContext())
                        .setTitle("Delete Item")
                        .setMessage("Are you sure to delete this item?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                DBHelper helper = new DBHelper(v.getContext());
                                if(helper.deleteOrder(model.getOrdered_number()) >0){
                                    Toast.makeText(v.getContext(), "Deleted", Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(v.getContext(), "Error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .show();

                return false;
            }
        });
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
