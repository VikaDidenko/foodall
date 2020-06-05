package com.example.lenovo.food;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.food.Common.Common;
import com.example.lenovo.food.Model.Request;
import com.example.lenovo.food.Model.User;
import com.example.lenovo.food.ViewHolder.OrderViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ViewAct extends AppCompatActivity {

    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;
    FirebaseRecyclerAdapter<Post, MyRecyclerViewHolder> adapter;
    FirebaseDatabase database;
    DatabaseReference requests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

         database = FirebaseDatabase.getInstance();
        requests = database.getReference("Tables");
        recyclerView = (RecyclerView) findViewById(R.id.listOrderTable);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new FirebaseRecyclerAdapter<Post, MyRecyclerViewHolder>(
                Post.class,
                R.layout.table_layout,
                MyRecyclerViewHolder.class,
                requests.orderByChild("phone")

        ) {
            @Override
            protected void populateViewHolder(MyRecyclerViewHolder viewHolder, Post model, int position) {
                viewHolder.id.setText(adapter.getRef(position).getKey());
                viewHolder.name.setText(model.getName());
                viewHolder.phone.setText(model.getPhone());
                viewHolder.time.setText(model.getTime());
                viewHolder.number.setText(model.getNumber());

            }
        };
        recyclerView.setAdapter(adapter);
    }
}





