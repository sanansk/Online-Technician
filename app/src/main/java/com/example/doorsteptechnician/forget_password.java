package com.example.doorsteptechnician;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forget_password extends AppCompatActivity {

    ImageView forgot_login_image;
    TextView forgot_txt, forgot_signup_txt;
    EditText forgotemail;
    String email;
    ProgressDialog progressDialog;
    Button getpassword;
    FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        forgot_login_image= findViewById(R.id.forgot_login_image);
        forgot_txt= findViewById(R.id.forgot_txt);
        forgotemail= findViewById(R.id.forgotemail);
        getpassword = findViewById(R.id.getpassword);
        forgot_signup_txt= findViewById(R.id.forgot_signup_txt);
        progressDialog = new ProgressDialog(this);

        mAuth= FirebaseAuth.getInstance();
        forgot_signup_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(forget_password.this, Signup.class));
                finish();
            }
        });
        getpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validateData();
            }
        });
    }

    private void validateData() {
        email= forgotemail.getText().toString();
        if (email.isEmpty()){
            forgotemail.setError("Email Required");
        }else {
            forgotPassword();
        }
    }
    private  void  forgotPassword(){
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(forget_password.this, "Check Your Email", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(forget_password.this, Login.class));
                    finish();
                } else {
                    Toast.makeText(forget_password.this, "Error"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}