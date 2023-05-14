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


public class computer_services_fragment extends Fragment {

    ImageView comp_dashboard_img;
    CardView comp_os_card,comp_motherboard_card,comp_hard_ram_card,comp_tune_up_card,comp_fan_card,comp_firewall_card;

    public computer_services_fragment() {
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
        View computer_servicesView= inflater.inflate(R.layout.fragment_computer_services_fragment, container, false);

        comp_dashboard_img= computer_servicesView.findViewById(R.id.comp_dashboard_img);
        comp_os_card= computer_servicesView.findViewById(R.id.comp_os_card);
        comp_motherboard_card= computer_servicesView.findViewById(R.id.comp_motherboard_card);
        comp_hard_ram_card= computer_servicesView.findViewById(R.id.comp_hard_ram_card);
        comp_tune_up_card= computer_servicesView.findViewById(R.id.comp_tune_up_card);
        comp_fan_card= computer_servicesView.findViewById(R.id.comp_fan_card);
        comp_firewall_card= computer_servicesView.findViewById(R.id.comp_firewall_card);

        //Computer OS installation Fragment
        comp_os_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new computer_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on Computer OS Installation", Toast.LENGTH_SHORT).show();
        });
        //Computer Motherboard Repair Fragment
        comp_motherboard_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new computer_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on Computer Motherboard Repair", Toast.LENGTH_SHORT).show();
        });
        //Computer Hard-ram Fragment
        comp_hard_ram_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new computer_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on Computer Hard-ram Upgrade", Toast.LENGTH_SHORT).show();
        });
        //Computer Tune-up Fragment
        comp_tune_up_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new computer_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on Computer Tune-up", Toast.LENGTH_SHORT).show();
        });
        //Computer Fan Replacement Fragment
        comp_fan_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new computer_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on Computer Fan Replacement", Toast.LENGTH_SHORT).show();
        });
        //Computer Firewall setup Fragment
        comp_firewall_card.setOnClickListener(view -> {

            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.dashboard_frame_layout,new computer_technician_fragment(),null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Toast.makeText(getActivity(), "Clicked on Computer firewall Setup", Toast.LENGTH_SHORT).show();
        });

        return computer_servicesView;
    }
}