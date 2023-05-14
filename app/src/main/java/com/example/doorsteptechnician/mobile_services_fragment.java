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

public class mobile_services_fragment extends Fragment {
    ImageView mobile_dashboard_img;
    CardView mobile_screen_card,mobile_battery_card,mobile_water_card,mobile_camera_card,mobile_speaker_card,mobile_data_card;

    public mobile_services_fragment() {
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
        View mobile_servicesView= inflater.inflate(R.layout.fragment_mobile_services_fragment, container, false);

        mobile_dashboard_img= mobile_servicesView.findViewById(R.id.mobile_dashboard_img);
        mobile_screen_card= mobile_servicesView.findViewById(R.id.mobile_screen_card);
        mobile_battery_card= mobile_servicesView.findViewById(R.id.mobile_battery_card);
        mobile_water_card= mobile_servicesView.findViewById(R.id.mobile_water_card);
        mobile_camera_card= mobile_servicesView.findViewById(R.id.mobile_camera_card);
        mobile_speaker_card= mobile_servicesView.findViewById(R.id.mobile_speaker_card);
        mobile_data_card= mobile_servicesView.findViewById(R.id.mobile_data_card);

        // Mobile Screen Repair Fragment
        mobile_screen_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new mobile_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on Mobile Screen Repair", Toast.LENGTH_SHORT).show();
        });
        // Mobile Battery Replacement Fragment
        mobile_battery_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new mobile_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on Mobile Battery Replacement", Toast.LENGTH_SHORT).show();
        });
        // Mobile Water damage repair Fragment
        mobile_water_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new mobile_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on Mobile Water Damage Repair", Toast.LENGTH_SHORT).show();
        });
        // Mobile Camera repair Fragment
        mobile_camera_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new mobile_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on Mobile Camera repair", Toast.LENGTH_SHORT).show();
        });
        // Mobile Speaker repair Fragment
        mobile_speaker_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new mobile_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on Mobile Speaker repair", Toast.LENGTH_SHORT).show();
        });
        // Mobile Data Recovery Fragment
        mobile_data_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new mobile_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on Mobile Data Recovery", Toast.LENGTH_SHORT).show();
        });

        return mobile_servicesView;
    }
}