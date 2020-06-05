package com.example.lenovo.food;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.food.Interface.ItemClickListener;

import java.util.ArrayList;

public class MyRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView name,id,phone,number, time;

    private ItemClickListener itemClickListener;
    public MyRecyclerViewHolder(View itemView) {
        super(itemView);

        name=(TextView)itemView.findViewById(R.id.name);
        id=(TextView)itemView.findViewById(R.id.order_id_table);
        phone=(TextView)itemView.findViewById(R.id.phone);
        number=(TextView)itemView.findViewById(R.id.number);
        time=(TextView)itemView.findViewById(R.id.time);
        //txtOrderTable=(TextView)itemView.findViewById(R.id.order_table);
        itemView.setOnClickListener(this);
    }
    public void setItemClickListener(ItemClickListener itemClickListener)
    {
        this.itemClickListener=itemClickListener;
    }
    @Override
    public void onClick(View view) {

    }



    }

