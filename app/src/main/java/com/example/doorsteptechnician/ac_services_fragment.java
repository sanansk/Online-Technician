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

public class ac_services_fragment extends Fragment {

    ImageView ac_dashboard_img;
    CardView ac_install_card, ac_repair_card, ac_maintenance_card, ac_tune_card, ac_duct_card, ac_replace_card;

    public ac_services_fragment() {
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
        View ac_servicesView= inflater.inflate(R.layout.fragment_ac_services_fragment, container, false);

        ac_dashboard_img = ac_servicesView.findViewById(R.id.ac_dashboard_img);
        ac_install_card = ac_servicesView.findViewById(R.id.ac_install_card);
        ac_repair_card = ac_servicesView.findViewById(R.id.ac_repair_card);
        ac_maintenance_card = ac_servicesView.findViewById(R.id.ac_maintenance_card);
        ac_tune_card = ac_servicesView.findViewById(R.id.ac_tune_card);
        ac_duct_card = ac_servicesView.findViewById(R.id.ac_duct_card);
        ac_replace_card = ac_servicesView.findViewById(R.id.ac_replace_card);

        //Ac Installation Fragment
        ac_install_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new ac_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on AC Installation", Toast.LENGTH_SHORT).show();
        });
        //Ac Repair Fragment
        ac_repair_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new ac_technician_fragment(), null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on AC Repair", Toast.LENGTH_SHORT).show();
        });
        //Ac Maintenance Fragment
        ac_maintenance_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new ac_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on AC Maintenance", Toast.LENGTH_SHORT).show();
        });
        //Ac Tune-up Fragment
        ac_tune_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new ac_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on AC Tune-up", Toast.LENGTH_SHORT).show();
        });
        //Ac Duct Cleaning Fragment
        ac_duct_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new ac_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on AC Duct Cleaning", Toast.LENGTH_SHORT).show();
        });
        //Ac Replace Fragment
        ac_replace_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new ac_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on AC Replacement", Toast.LENGTH_SHORT).show();
        });

        return ac_servicesView;
    }
}