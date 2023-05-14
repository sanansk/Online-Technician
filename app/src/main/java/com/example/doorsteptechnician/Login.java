package com.example.doorsteptechnician;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
public class Login extends AppCompatActivity {
    ImageView login_image;
    TextView logintxt2, logintxt1, forgetpassw;
    Button loginbtn;
    EditText loginemail, loginpaswrd;
    String emailpattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    boolean passwordvisible;
    public static final String SHARED_PREFS= "sharedPrefs";

    @SuppressLint({"MissingInflatedId", "ClickableViewAccessibility"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_image = findViewById(R.id.login_image);
        loginemail = findViewById(R.id.loginemail);
        loginpaswrd = findViewById(R.id.loginpaswrd);

        logintxt1 = findViewById(R.id.logintxt1);
        logintxt2 = findViewById(R.id.logintxt2);

        loginbtn = findViewById(R.id.loginbtn);
        forgetpassw= findViewById(R.id.forgetpassw);

        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        checkBox();
        // Login Password Toggle
        loginpaswrd.setOnTouchListener((view, motionEvent) -> {
            final int Right=2;
            if (motionEvent.getAction()==MotionEvent.ACTION_UP){
                if (motionEvent.getRawX()>=loginpaswrd.getRight()-loginpaswrd.getCompoundDrawables()[Right].getBounds().width()){
                    int select= loginpaswrd.getSelectionEnd();
                    if (passwordvisible){
                        //set drawable image
                        loginpaswrd.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.signup_key,0,R.drawable.password_off,0);
                        //For hide password
                        loginpaswrd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        passwordvisible=false;
                    }else {
                        //set drawable image
                        loginpaswrd.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.signup_key,0,R.drawable.password_on,0);
                        //For show password
                        loginpaswrd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                        passwordvisible=true;
                    }
                    loginpaswrd.setSelection(select);
                    return true;
                }
            }
            return false;
        });
        //Login Validation
        loginbtn.setOnClickListener(view -> {
            performlogin();
        });
        logintxt2.setOnClickListener(view -> {
            Intent intent = new Intent(Login.this, Signup.class);
            startActivity(intent);

            Toast.makeText(Login.this, "Clicked on Sign up", Toast.LENGTH_SHORT).show();
        });
        forgetpassw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, forget_password.class);
                startActivity(intent);

                Toast.makeText(Login.this, "Forgot Password Dashboard", Toast.LENGTH_SHORT).show();
            }
        });
    }
    //SharePreference Work
    private void checkBox() {
        SharedPreferences sharedPreferences= getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        String check= sharedPreferences.getString("loginemail","");
        if (check.equals("true")){
            progressDialog.dismiss();
            sendUserToNextActivity();
            finish();
        }
    }
    //SharePreference Work
    private void performlogin() {
        String emaill = loginemail.getText().toString();
        String pswrd = loginpaswrd.getText().toString();

        if (!emaill.matches(emailpattern)) {
            loginemail.setError("Email required");
        } else if (pswrd.isEmpty() || loginpaswrd.length() < 6) {
            loginpaswrd.setError("Password must be greater then 5 digits");
        }  else {
            progressDialog.setMessage("Please wait...");
            progressDialog.setTitle("Logging...");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.signInWithEmailAndPassword(emaill,pswrd).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    if (mAuth.getCurrentUser().isEmailVerified()){
 //SharePreference Work
                        SharedPreferences sharedPreferences= getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                        SharedPreferences.Editor editor= sharedPreferences.edit();
                        editor.putString("loginemail","true");
                        editor.apply();
//SharePreference Work
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(Login.this, "Log in Successfully", Toast.LENGTH_SHORT).show();
                    }else {
                        progressDialog.dismiss();
                        openAlertBox();
                    }
                    } else {
                    progressDialog.dismiss();
                    Toast.makeText(Login.this, "Error : " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    private void openAlertBox() {
        AlertDialog.Builder builder= new AlertDialog.Builder(Login.this);
        builder.setTitle("Email Verification Alert");
        builder.setMessage("Kindly check and verify your email address to authorize login");
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        AlertDialog alertDialog= builder.create();
        alertDialog.show();
    }
    private void sendUserToNextActivity() {
        Intent intent = new Intent(Login.this, SplashScreen.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}

