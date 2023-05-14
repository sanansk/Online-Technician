package com.example.doorsteptechnician;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class home_drawer extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_drawer);

        drawerLayout= findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.navigation_view);
        toolbar= findViewById(R.id.toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_open, R.string.navigation_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(item -> {

            switch (item.getItemId()){

                case R.id.ac_technician_menu:
                    fragment(new ac_technician_fragment());
                    drawerLayout.closeDrawer(GravityCompat.START);
                    Toast.makeText(home_drawer.this, "Air Conditioning Technicians", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.fridge_technician_menu:
                    fragment(new refrigerator_technician_fragment());
                    drawerLayout.closeDrawer(GravityCompat.START);
                    Toast.makeText(home_drawer.this, "Refrigerator Technicians", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.laptop_technician_menu:
                    fragment(new laptop_technician_fragment());
                    drawerLayout.closeDrawer(GravityCompat.START);
                    Toast.makeText(home_drawer.this, "Laptop Technicians", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.comp_technician_menu:
                    fragment(new computer_technician_fragment());
                    drawerLayout.closeDrawer(GravityCompat.START);
                    Toast.makeText(home_drawer.this, "Computer Technicians", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.mobile_technician_menu:
                    fragment(new mobile_technician_fragment());
                    drawerLayout.closeDrawer(GravityCompat.START);
                    Toast.makeText(home_drawer.this, "Mobile Technicians", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.multi_technician_menu:
                    fragment(new multimedia_technician_fragment());
                    drawerLayout.closeDrawer(GravityCompat.START);
                    Toast.makeText(home_drawer.this, "Multimedia Technicians", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.plumb_technician_menu:
                    fragment(new plumbing_technician_fragment());
                    drawerLayout.closeDrawer(GravityCompat.START);
                    Toast.makeText(home_drawer.this, "Plumbing Technicians", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.wm_technician_menu:
                    fragment(new wm_technician_fragment());
                    drawerLayout.closeDrawer(GravityCompat.START);
                    Toast.makeText(home_drawer.this, "WM Technicians", Toast.LENGTH_SHORT).show();
                    break;
            }

            return true;
        });
    }
    private void fragment(Fragment fragment){
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
}