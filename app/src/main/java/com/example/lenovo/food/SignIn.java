package com.example.lenovo.food;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.DatabaseErrorHandler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lenovo.food.Common.Common;
import com.example.lenovo.food.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignIn extends AppCompatActivity {

    EditText edtPhone, edtPassword;
    Button btnSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        edtPassword = (MaterialEditText) findViewById(R.id.edtPassword);
        edtPhone = (MaterialEditText) findViewById(R.id.edtPhone);
        btnSignIn = (Button)findViewById(R.id.btnSignIn);

        //Init Firebase
final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 final ProgressDialog mDialog = new ProgressDialog(SignIn.this);
                mDialog.setMessage("Зачекайте..");
                mDialog.show();
                table_user.addValueEventListener(new ValueEventListener(){
                    
                @Override
                public void onDataChange(DataSnapshot dataSnapshot)  {
                    if(dataSnapshot.child(edtPhone.getText().toString()).exists()) {
                        //Get User information
                        mDialog.dismiss();
                        User user = dataSnapshot.child(edtPhone.getText().toString()).getValue(User.class);
                        user.setPhone(edtPhone.getText().toString()); //setPhone
                        if (user.getPassword().equals(edtPassword.getText().toString())) {
                            Intent homeIntent = new Intent(SignIn.this, Home.class);
                            Common.currentUser = user;
                            startActivity(homeIntent);
                            finish();
                        } else {
                            Toast.makeText(SignIn.this, "Невірний пароль!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        mDialog.dismiss();
                        Toast.makeText(SignIn.this, "Ви не зареєструвалися!", Toast.LENGTH_SHORT).show();
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