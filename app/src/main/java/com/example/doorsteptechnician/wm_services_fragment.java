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

public class wm_services_fragment extends Fragment {

    ImageView wm_dashboard_img;
    CardView wm_control_card,wm_drum_card,wm_pump_card,wm_belt_card,wm_drain_card,wm_inlet_valve_card;

    public wm_services_fragment() {
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
        View wm_servicesView= inflater.inflate(R.layout.fragment_wm_services_fragment, container, false);

        wm_dashboard_img= wm_servicesView.findViewById(R.id.wm_dashboard_img);
        wm_control_card= wm_servicesView.findViewById(R.id.wm_control_card);
        wm_drum_card= wm_servicesView.findViewById(R.id.wm_drum_card);
        wm_pump_card= wm_servicesView.findViewById(R.id.wm_pump_card);
        wm_belt_card= wm_servicesView.findViewById(R.id.wm_belt_card);
        wm_drain_card= wm_servicesView.findViewById(R.id.wm_drain_card);
        wm_inlet_valve_card= wm_servicesView.findViewById(R.id.wm_inlet_valve_card);

        //WM Control Board Repair Fragment
        wm_control_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new wm_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on WM Control Board Repair", Toast.LENGTH_SHORT).show();
        });
        //WM Drum Repair Fragment
        wm_drum_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new wm_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on WM Drum Repair", Toast.LENGTH_SHORT).show();
        });
        //WM Pump Repair Fragment
        wm_pump_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new wm_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on WM Pump Repair", Toast.LENGTH_SHORT).show();
        });
        //WM Belt Repair Fragment
        wm_belt_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new wm_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on WM Belt Repair", Toast.LENGTH_SHORT).show();
        });
        //WM Drain Hose Repair Fragment
        wm_drain_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new wm_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on WM Drain Hose Repair", Toast.LENGTH_SHORT).show();
        });
        //WM Inlet Valve Repair Fragment
        wm_inlet_valve_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new wm_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on WM Inlet Valve Repair", Toast.LENGTH_SHORT).show();
        });

        return wm_servicesView;
    }
}