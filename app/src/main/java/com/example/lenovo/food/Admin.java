package com.example.lenovo.food;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import com.rengwuxian.materialedittext.MaterialEditText;

public class Admin extends AppCompatActivity {
    EditText adminPhone, adminPassword;
    Button adminSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        adminPassword = (MaterialEditText) findViewById(R.id.adminPassword);
        adminPhone = (MaterialEditText) findViewById(R.id.adminPhone);
        adminSignIn = (Button)findViewById(R.id.adminSignIn);


//Init Firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("Admin");
        adminSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog mDialog = new ProgressDialog(Admin.this);
                mDialog.setMessage("Зачекайте...");
                mDialog.show();
                table_user.addValueEventListener(new ValueEventListener(){

                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot)  {
                        if(dataSnapshot.child(adminPhone.getText().toString()).exists()) {
                            //Get User information
                            mDialog.dismiss();
                            User user = dataSnapshot.child(adminPhone.getText().toString()).getValue(User.class);
                            user.setPhone(adminPhone.getText().toString()); //setPhone
                            if (user.getPassword().equals(adminPassword.getText().toString())) {
                                Intent homeIntent = new Intent(Admin.this, OrderDetailsTable.class);
                                Common.currentUser = user;
                                startActivity(homeIntent);
                                finish();
                            } else {
                                Toast.makeText(Admin.this, "Невірний пароль!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            mDialog.dismiss();
                            Toast.makeText(Admin.this, "Ви не зареєструвалися!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError){

                    }


                });


            }
        });


    }


    }

