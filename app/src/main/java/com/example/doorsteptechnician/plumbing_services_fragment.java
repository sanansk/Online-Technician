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

public class plumbing_services_fragment extends Fragment {
    ImageView plumber_dashboard_img;
    CardView plumb_installation_card,plumb_repair_card,plumb_sewerline_card,plumb_waterheater_card,plumb_fixtures_card,plumb_gasline_card;

    public plumbing_services_fragment() {
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
        View laptop_servicesView= inflater.inflate(R.layout.fragment_plumbing_services_fragment, container, false);

        plumber_dashboard_img= laptop_servicesView.findViewById(R.id.plumber_dashboard_img);
        plumb_installation_card= laptop_servicesView.findViewById(R.id.plumb_installation_card);
        plumb_repair_card= laptop_servicesView.findViewById(R.id.plumb_repair_card);
        plumb_sewerline_card= laptop_servicesView.findViewById(R.id.plumb_sewerline_card);
        plumb_waterheater_card= laptop_servicesView.findViewById(R.id.plumb_waterheater_card);
        plumb_fixtures_card= laptop_servicesView.findViewById(R.id.plumb_fixtures_card);
        plumb_gasline_card= laptop_servicesView.findViewById(R.id.plumb_gasline_card);

        // Plumbing New System Installation Fragment
        plumb_installation_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new plumbing_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on Plumbing New System Installation", Toast.LENGTH_SHORT).show();
        });
        // Plumbing Old System Repair Fragment
        plumb_repair_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new plumbing_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on Plumbing Old System Repair", Toast.LENGTH_SHORT).show();
        });
        // Plumbing Sewer Line repair Fragment
        plumb_sewerline_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new plumbing_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on Plumbing Sewer-Line Install/Repair", Toast.LENGTH_SHORT).show();
        });
        // Plumbing Water Heater install Fragment
        plumb_waterheater_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new plumbing_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on Plumbing Water-heater Install/Repair", Toast.LENGTH_SHORT).show();
        });
        // Plumbing Fixtures Installation Fragment
        plumb_fixtures_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new plumbing_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on Plumbing Fixtures Install/Repair", Toast.LENGTH_SHORT).show();
        });
        // Plumbing Gas-line Installation Fragment
        plumb_gasline_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new plumbing_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on Gas-Line Install/Repair", Toast.LENGTH_SHORT).show();
        });

        return laptop_servicesView;
    }
}