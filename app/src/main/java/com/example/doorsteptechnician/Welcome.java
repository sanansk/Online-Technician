package com.example.doorsteptechnician;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Welcome extends AppCompatActivity {
    TextView wlcmlogintxt,wlcmtxt1,wlcmtxt3;
 ImageView wlcmimage;

    public static final String SHARED_PREFS= "sharedPrefs";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_page);

        wlcmtxt1= findViewById(R.id.wlcmtxt1);
        wlcmimage= findViewById(R.id.wlcmimage);
        wlcmtxt3= findViewById(R.id.wlcmtxt3);

        Button getstartbtn = findViewById(R.id.getstartbtn);
        wlcmlogintxt= findViewById(R.id.wlcmlogintxt);
        checkBoxlogin();


        getstartbtn.setOnClickListener(view -> openSignup());

        wlcmlogintxt.setOnClickListener(view -> {
            Intent intent= new Intent(Welcome.this,Login.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            Toast.makeText(Welcome.this, "Clicked on Log in", Toast.LENGTH_LONG).show();
        });
    }
//SharePreference Work
    private void checkBoxlogin() {
        SharedPreferences sharedPreferences= getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        String check= sharedPreferences.getString("loginemail","");
        if (check.equals("true")){
            Intent intent= new Intent(Welcome.this,Login.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }
    }
    //SharePreference Work
    public void openSignup(){
        Intent intent = new Intent(this, Signup.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        Toast.makeText(Welcome.this, "Clicked on Get Started", Toast.LENGTH_LONG).show();
    }
    }