package com.example.doorsteptechnician;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;


public class dashboard extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView1;
    FirebaseAuth mAuth;
    public static final String SHARED_PREFS= "sharedPrefs";

    @SuppressLint({"MissingInflatedId", "NonConstantResourceId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        mAuth = FirebaseAuth.getInstance();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView1 = findViewById(R.id.dash_navigation_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_open, R.string.navigation_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.dashboard_frame_layout, new dashboard_fragment());
        fragmentTransaction.commit();


        navigationView1.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.ac_technician_menu:
                        fragment(new ac_technician_fragment());
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Toast.makeText(dashboard.this, "Air Conditioning Technicians", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.fridge_technician_menu:
                        fragment(new refrigerator_technician_fragment());
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Toast.makeText(dashboard.this, "Refrigerator Technicians", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.laptop_technician_menu:
                        fragment(new laptop_technician_fragment());
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Toast.makeText(dashboard.this, "Laptop Technicians", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.comp_technician_menu:
                        fragment(new computer_technician_fragment());
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Toast.makeText(dashboard.this, "Computer Technicians", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.mobile_technician_menu:
                        fragment(new mobile_technician_fragment());
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Toast.makeText(dashboard.this, "Mobile Technicians", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.multi_technician_menu:
                        fragment(new multimedia_technician_fragment());
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Toast.makeText(dashboard.this, "Multimedia Technicians", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.plumb_technician_menu:
                        fragment(new plumbing_technician_fragment());
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Toast.makeText(dashboard.this, "Plumbing Technicians", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.wm_technician_menu:
                        fragment(new wm_technician_fragment());
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Toast.makeText(dashboard.this, "WM Technicians", Toast.LENGTH_SHORT).show();
                        break;
                    ////
                    case R.id.register_tech_menu:
                        Intent intent= new Intent(dashboard.this, Technician_register.class);
                        startActivity(intent);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Toast.makeText(dashboard.this, "Technician Registration", Toast.LENGTH_SHORT).show();
                        break;
                    ////
                    case R.id.start_time_menu:
                        fragment(new timer());
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Toast.makeText(dashboard.this, "Timer Dashboard", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.logOut_menu:
                        if (item.getItemId()==R.id.logOut_menu){
                            AlertDialog.Builder builder=new AlertDialog.Builder(dashboard.this);
                            builder.setTitle("Are you sure, You want to logOut?");
                            builder.setPositiveButton("LogOut", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //
                                    SharedPreferences sharedPreferences= getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                                    SharedPreferences.Editor editor= sharedPreferences.edit();
                                    editor.clear();
                                    editor.commit();
                                    finish();
                                    //
                                    Toast.makeText(dashboard.this, "LogOut Successfully", Toast.LENGTH_SHORT).show();
                                    Intent go_to_login=new Intent(getApplicationContext(), Login.class);
                                    startActivity(go_to_login);
                                }
                            });
                            builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                            AlertDialog alertDialog=builder.create();
                            alertDialog.show();
                        }
                }
                return true;
            }
        });
    }

    private void fragment(Fragment fragment){
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.dashboard_frame_layout,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
