package com.example.doorsteptechnician;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doorsteptechnician.model.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {
    TextView signuptxt2, signuptxt1;
    ImageView signup_image;
    EditText firstname, lastname, email, password, confpswrd;
    Button signupbtn;
    String emailpattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    FirebaseDatabase database;
    UserModel userModel;
    boolean isAllFieldsChecked = false;
    boolean passwordvisible;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confpswrd = findViewById(R.id.confpswrd);

        signup_image = findViewById(R.id.signup_image);
        signuptxt1 = findViewById(R.id.signuptxt1);
        signupbtn = findViewById(R.id.signupbtn);
        signuptxt2 = findViewById(R.id.signuptxt2);

        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        database = FirebaseDatabase.getInstance();

        //Password Toggle
        password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int Right = 2;
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    if (motionEvent.getRawX() >= password.getRight() - password.getCompoundDrawables()[Right].getBounds().width()) {
                        int select = password.getSelectionEnd();
                        if (passwordvisible) {
                            //set drawable image
                            password.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.signup_key, 0, R.drawable.password_off, 0);
                            //For hide password
                            password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordvisible = false;
                        } else {
                            //set drawable image
                            password.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.signup_key, 0, R.drawable.password_on, 0);
                            //For show password
                            password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordvisible = true;
                        }
                        password.setSelection(select);
                        return true;
                    }
                }
                return false;
            }
        });
        //Confirm Password Toggle
        confpswrd.setOnTouchListener((view, motionEvent) -> {
            final int Right = 2;
            if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                if (motionEvent.getRawX() >= confpswrd.getRight() - confpswrd.getCompoundDrawables()[Right].getBounds().width()) {
                    int select = confpswrd.getSelectionEnd();
                    if (passwordvisible) {
                        //set drawable image
                        confpswrd.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.signup_key, 0, R.drawable.password_off, 0);
                        //For hide password
                        confpswrd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        passwordvisible = false;
                    } else {
                        //set drawable image
                        confpswrd.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.signup_key, 0, R.drawable.password_on, 0);
                        //For show password
                        confpswrd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                        passwordvisible = true;
                    }
                    confpswrd.setSelection(select);
                    return true;
                }
            }
            return false;
        });
        // Sign up Validation
        signupbtn.setOnClickListener(view -> {

            isAllFieldsChecked = CheckAllFields();
            performAnthn();

        });
        signuptxt2.setOnClickListener(view -> {
            Intent intent = new Intent(Signup.this, Login.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

            Toast.makeText(Signup.this, "Clicked on Log in", Toast.LENGTH_SHORT).show();
        });
    }
    private boolean CheckAllFields() {
        if (firstname.length() == 0) {
            firstname.setError("This Field is required");
            return false;
        }
        if (lastname.length() == 0) {
            lastname.setError("This Field is required");
            return false;
        }
        return true;
    }
    private void performAnthn() {

        String fname = firstname.getText().toString();
        String lname = lastname.getText().toString();
        String emaill = email.getText().toString();
        String pswrd = password.getText().toString();
        String confpaswrd = confpswrd.getText().toString();

        if (!emaill.matches(emailpattern)) {
            email.setError("Email required");
        } else if (pswrd.isEmpty() || password.length() < 5) {
            password.setError("Password must be greater then 5 digits");
        } else if (!pswrd.equals(confpaswrd)) {
            confpswrd.setError("Password doesn't match");
        } else {
            progressDialog.setMessage("Please wait...");
            progressDialog.setTitle("Creating an account...");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(emaill, pswrd).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    //userModel work//
                    UserModel userModel=new UserModel(fname,lname,emaill,pswrd);
                    String id= task.getResult().getUser().getUid();
                    database.getReference().child("Users").child(id).setValue(userModel);
                    //userModel work//
                    mAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                progressDialog.dismiss();
                                sendUserToNextActivity();
                                Toast.makeText(Signup.this, "User registered successfully, Please verify your email address", Toast.LENGTH_SHORT).show();
                                email.setText("");
                                password.setText("");
                            }
                            else {
                                Toast.makeText(Signup.this, "Error :" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    progressDialog.dismiss();
                    Toast.makeText(Signup.this, "Error :" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    private void sendUserToNextActivity() {
        Intent intent = new Intent(Signup.this, Login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
