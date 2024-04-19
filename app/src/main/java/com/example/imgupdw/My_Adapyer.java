package com.example.imgupdw;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collections;

public class My_Adapyer extends RecyclerView.Adapter<My_Adapyer.MyViewHolder> {

    ArrayList<String> als = new ArrayList<>();
    Context context;

    public My_Adapyer(ArrayList<String> als, Context context) {
        this.als = als;
//        Collections.reverse(this.als);
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.adap_card_v, parent, false);
        return(new MyViewHolder(v));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(als.get(position)).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return als.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView2);
        }
    }
}
