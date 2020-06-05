package com.example.lenovo.food;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.lenovo.food.Database.Database;
import com.example.lenovo.food.Model.Food;
import com.example.lenovo.food.Model.Order;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Table extends AppCompatActivity {
    Button bookdetailbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        Bundle data=getIntent().getExtras();
        bookdetailbutton=(Button)findViewById(R.id.bookdetailbutton);
        Toast.makeText(this,String.valueOf(data.getInt("position")),Toast.LENGTH_SHORT).show();
        TextView textdatetime=(TextView)findViewById(R.id.textdatetime);
        textdatetime.setText(data.getCharSequence("date")+" "+data.getCharSequence("time"));
        TextView numberpeople=(TextView)findViewById(R.id.textnumberpeople);
        numberpeople.setText(data.getCharSequence("NumberOfPeople"));
        data.getCharSequence("");

        bookdetailbutton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                Toast.makeText(Table.this, "Дякую", Toast.LENGTH_SHORT).show();
               // Intent signIn = new Intent(Table.this,SignIn.class);
               // startActivity(signIn);
            }
        });


    }



}
