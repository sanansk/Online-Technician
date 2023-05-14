package com.example.doorsteptechnician;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;


public class dashboard_fragment extends Fragment {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView dash_navigation_view;
    CardView ac_card, laptop_card, mobile_card, multimedia_card, plumbing_card, fridge_card, computer_card, wm_card;
    public dashboard_fragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }
    @SuppressLint({"MissingInflatedId", "NonConstantResourceId"})
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View dashboardview = inflater.inflate(R.layout.fragment_dashboard_fragment, container, false);


        drawerLayout = dashboardview.findViewById(R.id.drawer_layout);
        ac_card = dashboardview.findViewById(R.id.ac_card);
        laptop_card = dashboardview.findViewById(R.id.laptop_card);
        mobile_card = dashboardview.findViewById(R.id.mobile_card);
        multimedia_card = dashboardview.findViewById(R.id.multimedia_card);
        plumbing_card = dashboardview.findViewById(R.id.plumbing_card);
        fridge_card = dashboardview.findViewById(R.id.fridge_card);
        computer_card = dashboardview.findViewById(R.id.computer_card);
        wm_card = dashboardview.findViewById(R.id.wm_card);



        dash_navigation_view = dashboardview.findViewById(R.id.dash_navigation_view);


        //AC service Fragment
        ac_card.setOnClickListener(view -> {

            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout, new ac_services_fragment(), null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on AC Services", Toast.LENGTH_SHORT).show();
        });
        //Refrigerator service Fragment
        fridge_card.setOnClickListener(view -> {

            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout, new refrigerator_services_fragment(), null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on Refrigerator Services", Toast.LENGTH_SHORT).show();
        });
        //Laptop service Fragment
        laptop_card.setOnClickListener(view -> {

            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout, new laptop_services_fragment(), null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on Laptop Services", Toast.LENGTH_SHORT).show();

        });
        //Computer service Fragment
        computer_card.setOnClickListener(view -> {

            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout, new computer_services_fragment(), null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on Computer Services", Toast.LENGTH_SHORT).show();
        });
        //Mobile service Fragment
        mobile_card.setOnClickListener(view -> {

            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout, new mobile_services_fragment(), null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on Mobile Services", Toast.LENGTH_SHORT).show();
        });
        //Multimedia service Fragment
        multimedia_card.setOnClickListener(view -> {

            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout, new multimedia_services_fragment(), null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on Multimedia Services", Toast.LENGTH_SHORT).show();
        });
        //Plumbing service Fragment
        plumbing_card.setOnClickListener(view -> {

            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout, new plumbing_services_fragment(), null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on Plumbing Services", Toast.LENGTH_SHORT).show();
        });
        //WM service Fragment
        wm_card.setOnClickListener(view -> {

            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout, new wm_services_fragment(), null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on WM Services", Toast.LENGTH_SHORT).show();
        });
        return dashboardview;
    }


//New work
    private void fragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.dashboard_frame_layout, fragment);
        fragmentTransaction.commit();
        //New work
    }
}
