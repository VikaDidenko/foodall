package com.example.lenovo.food;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OrderDetailsTable extends AppCompatActivity {
Button order_tables, order_foods;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details_table);

        order_tables=(Button)findViewById(R.id.order_tables);
        order_foods=(Button)findViewById(R.id.order_foods);

        order_tables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUp = new Intent(OrderDetailsTable.this,ViewAct.class);
                startActivity(signUp);


            }
        });
        order_foods.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent signIn = new Intent(OrderDetailsTable.this,OrderStatys.class);
                startActivity(signIn);
            }
        });


    }
}
