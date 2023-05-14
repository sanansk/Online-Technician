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

public class refrigerator_services_fragment extends Fragment {

    ImageView fridge_dashboard_img;
    CardView fridge_repair_card,fridge_maintain_card,fridge_compressor_card,fridge_wiring_card,fridge_restoration_card,fridge_parts_replace_card;

    public refrigerator_services_fragment() {
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
        View fridge_servicesVIew= inflater.inflate(R.layout.fragment_refrigerator_services_fragment, container, false);

        fridge_dashboard_img= fridge_servicesVIew.findViewById(R.id.fridge_dashboard_img);
        fridge_repair_card= fridge_servicesVIew.findViewById(R.id.fridge_repair_card);
        fridge_maintain_card= fridge_servicesVIew.findViewById(R.id.fridge_maintain_card);
        fridge_compressor_card= fridge_servicesVIew.findViewById(R.id.fridge_compressor_card);
        fridge_wiring_card= fridge_servicesVIew.findViewById(R.id.fridge_wiring_card);
        fridge_restoration_card= fridge_servicesVIew.findViewById(R.id.fridge_restoration_card);
        fridge_parts_replace_card= fridge_servicesVIew.findViewById(R.id.fridge_parts_replace_card);

        // Fridge Repair Fragment
        fridge_repair_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new refrigerator_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on Fridge Repair", Toast.LENGTH_SHORT).show();
        });
        // Fridge Maintenance Fragment
        fridge_maintain_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new refrigerator_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on Fridge Maintenance", Toast.LENGTH_SHORT).show();
        });
        // Fridge Compressor Check Fragment
        fridge_compressor_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new refrigerator_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on Fridge Compressor Check", Toast.LENGTH_SHORT).show();
        });
        // Fridge Wiring Fragment
        fridge_wiring_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new refrigerator_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on Fridge Wiring", Toast.LENGTH_SHORT).show();
        });
        // Fridge Restoration Fragment
        fridge_restoration_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new refrigerator_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on Fridge Restoration", Toast.LENGTH_SHORT).show();
        });
        // Fridge Parts_replace Fragment
        fridge_parts_replace_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new refrigerator_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on Fridge Parts_replace", Toast.LENGTH_SHORT).show();
        });

        return fridge_servicesVIew;
    }
}