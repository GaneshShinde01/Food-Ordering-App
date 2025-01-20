package com.learnandroid.foodorderingapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.learnandroid.foodorderingapp.MainActivity;
import com.learnandroid.foodorderingapp.Models.MainModel;
import com.learnandroid.foodorderingapp.R;
import com.learnandroid.foodorderingapp.databinding.SampleMainfoodBinding;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainAdapter  extends RecyclerView.Adapter<MainAdapter.viewHolder>{

    SampleMainfoodBinding binding;
    ArrayList<MainModel> list;
    Context context;

    public MainAdapter(ArrayList<MainModel> list, Context context) {

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

        final MainModel model = list.get(position);
        holder.food_image.setImageResource(model.getImage());
        holder.food_name.setText(model.getName());
        holder.food_current_price.setText(model.getPrice());
        holder.food_description.setText(model.getDescription());
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
