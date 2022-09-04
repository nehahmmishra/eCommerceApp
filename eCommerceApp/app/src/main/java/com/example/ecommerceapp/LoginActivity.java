package com.example.ecommerceapp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity
{
    private EditText InputPhoneNumber, InputPassword;
    private Button LoginButton;
    private ProgressDialog loadingBar;

    private String parentDbNme="user";
    private Object ValueEventListener;

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginButton = (Button) findViewById(R.id.login_btn);
        InputPassword= (EditText) findViewById(R.id.login_password_input);
        InputPhoneNumber= (EditText) findViewById(R.id.login_phone_no_input);
        loadingBar = new ProgressDialog(this);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginUser();
            }
        });
    }

    private void LoginUser() {

        String phone= InputPhoneNumber.getText().toString();
        String password= InputPassword.getText().toString();

         if(TextUtils.isEmpty(phone)){
            Toast.makeText(this, "Please write your Phone no.......", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please write your password......", Toast.LENGTH_SHORT).show();
        }
        else
         {
             loadingBar.setTitle("Login Account");
             loadingBar.setMessage("Please wait, while we are checking the credentials");
             loadingBar.setCanceledOnTouchOutside(false);
             loadingBar.show();
             
             
             AllowAccessToAccount(phone,password);
         }

    }

    private void AllowAccessToAccount(String phone, String password) {
        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(dataSnapshot.child(parentDbNme))
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        }ValueEventListener)

    }

}
