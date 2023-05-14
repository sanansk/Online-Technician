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

public class laptop_services_fragment extends Fragment {

    ImageView laptop_dashboard_img;
    CardView laptop_screen_card, laptop_motherboard_card, laptop_hard_ram_card, laptop_power_jack_card, laptop_fan_card, laptop_cyber_card;

    public laptop_services_fragment() {
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
        View laptop_servicesView = inflater.inflate(R.layout.fragment_laptop_services_fragment, container, false);

        laptop_dashboard_img = laptop_servicesView.findViewById(R.id.laptop_dashboard_img);
        laptop_screen_card = laptop_servicesView.findViewById(R.id.laptop_screen_card);
        laptop_motherboard_card = laptop_servicesView.findViewById(R.id.laptop_motherboard_card);
        laptop_hard_ram_card = laptop_servicesView.findViewById(R.id.laptop_hard_ram_card);
        laptop_power_jack_card = laptop_servicesView.findViewById(R.id.laptop_power_jack_card);
        laptop_fan_card = laptop_servicesView.findViewById(R.id.laptop_fan_card);
        laptop_cyber_card = laptop_servicesView.findViewById(R.id.laptop_cyber_card);

        // Laptop Screen Repair Fragment
        laptop_screen_card.setOnClickListener(view -> {

            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout, new laptop_technician_fragment(), null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked  on Laptop Screen Repair", Toast.LENGTH_SHORT).show();
        });
        // Laptop Motherboard Repair Fragment
        laptop_motherboard_card.setOnClickListener(view -> {

            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout, new laptop_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked  on Laptop Motherboard Repair", Toast.LENGTH_SHORT).show();
        });
        // Laptop Hard-ram Repair Fragment
        laptop_hard_ram_card.setOnClickListener(view -> {

            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout, new laptop_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked  on Laptop Hard-ram Repair", Toast.LENGTH_SHORT).show();
        });
        // Laptop Power-jack Repair Fragment
        laptop_power_jack_card.setOnClickListener(view -> {

            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout, new laptop_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked  on Laptop Power_jack Repair", Toast.LENGTH_SHORT).show();
        });
        // Laptop Fan Repair Fragment
        laptop_fan_card.setOnClickListener(view -> {

            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout, new laptop_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked  on Laptop Fan Repair", Toast.LENGTH_SHORT).show();
        });
        // Laptop Cyber Security Fragment
        laptop_cyber_card.setOnClickListener(view -> {

            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout, new laptop_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked  on Laptop Cyber Security", Toast.LENGTH_SHORT).show();
        });

        return laptop_servicesView;
    }
}