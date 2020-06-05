package com.example.lenovo.food;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.food.Model.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class activity_persinal_details extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    EditText editname, editphone, textdatetime, table;
    Button bookdetailbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persinal_details);
        Bundle data = getIntent().getExtras();
        Toast.makeText(this, String.valueOf(data.getInt("position")), Toast.LENGTH_SHORT).show();
        TextView textdatetimes = (TextView) findViewById(R.id.textdatetime);
        TextView texttable = (TextView) findViewById(R.id.texttable);
        textdatetimes.setText(data.getCharSequence("date") + " " + data.getCharSequence("time"));
        texttable.setText(data.getCharSequence("NumberOfPeople"));
        data.getCharSequence("");
        editname = (EditText) findViewById(R.id.editname);
        editphone = (EditText) findViewById(R.id.editphone);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("Tables");
        bookdetailbutton = (Button) findViewById(R.id.bookdetailbutton);
        bookdetailbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postComment();
            }
        });
    }

    private void postComment() {
        TextView textdatetimes = (TextView) findViewById(R.id.textdatetime);
        TextView texttable = (TextView) findViewById(R.id.texttable);
        Bundle data = getIntent().getExtras();
        textdatetimes.setText(data.getCharSequence("date") + " " + data.getCharSequence("time"));
        texttable.setText(data.getCharSequence("NumberOfPeople"));

        String name = editname.getText().toString();
        String phone = editphone.getText().toString();
        String time = textdatetimes.getText().toString();
        String number = texttable.getText().toString();

       Post post = new Post(name, phone, time, number);
       databaseReference.push().setValue(post);
    }
}
