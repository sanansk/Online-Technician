package com.example.doorsteptechnician;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class multimedia_services_fragment extends Fragment {
    ImageView multimedia_dashboard_img;
    CardView multi_screen_card,multi_driverboard_card,multi_colorwheel_card,multi_pixels_card,multi_dlp_chip_card,multi_power_card;

    public multimedia_services_fragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View multi_servicesView= inflater.inflate(R.layout.fragment_multimedia_services_fragment, container, false);

        multimedia_dashboard_img= multi_servicesView.findViewById(R.id.multimedia_dashboard_img);
        multi_screen_card= multi_servicesView.findViewById(R.id.multi_screen_card);
        multi_driverboard_card= multi_servicesView.findViewById(R.id.multi_driverboard_card);
        multi_colorwheel_card= multi_servicesView.findViewById(R.id.multi_colorwheel_card);
        multi_pixels_card= multi_servicesView.findViewById(R.id.multi_pixels_card);
        multi_dlp_chip_card= multi_servicesView.findViewById(R.id.multi_dlp_chip_card);
        multi_power_card= multi_servicesView.findViewById(R.id.multi_power_card);

        // Multimedia Screen Repair Fragment
        multi_screen_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new multimedia_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on Multimedia Screen Repair", Toast.LENGTH_SHORT).show();
        });
        // Multimedia Driverboard Repair Fragment
        multi_driverboard_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new multimedia_technician_fragment(), null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on Multimedia Driverboard Repair", Toast.LENGTH_SHORT).show();
        });
        // Multimedia Color Wheel Repair Fragment
        multi_colorwheel_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new multimedia_technician_fragment(), null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on Multimedia Color Wheel Repair", Toast.LENGTH_SHORT).show();
        });
        // Multimedia Dead Pixel Repair Fragment
        multi_pixels_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new multimedia_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on Multimedia Dead Pixel Repair", Toast.LENGTH_SHORT).show();
        });
        // Multimedia Dlp_chip Repair Fragment
        multi_dlp_chip_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new multimedia_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on Multimedia Dlp_chip Repair", Toast.LENGTH_SHORT).show();
        });
        // Multimedia Power Supply Repair Repair Fragment
        multi_power_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new multimedia_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on Multimedia Power Supply Repair", Toast.LENGTH_SHORT).show();
        });

        return multi_servicesView;
    }
}