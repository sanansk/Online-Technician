package com.example.doorsteptechnician;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class plumbing_technician_fragment extends Fragment {
    private static final int REQUEST_CALL_PHONE = 1;
    Button plumb_call_btn1, plumb_whatsapp_chat_btn1;
    Button plumb_start_service_btn1;
    TextView plumb_toolbar;
    Animation side_animation;
    public plumbing_technician_fragment() {
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
        View callView= inflater.inflate(R.layout.fragment_plumbing_technician_fragment, container, false);

        plumb_call_btn1 = callView.findViewById(R.id.plumb_call_btn1);
        plumb_whatsapp_chat_btn1= callView.findViewById(R.id.plumb_whatsapp_chat_btn1);
        plumb_start_service_btn1= callView.findViewById(R.id.plumb_start_service_btn1);

        plumb_toolbar= callView.findViewById(R.id.plumb_toolbar);
        side_animation= AnimationUtils.loadAnimation(getActivity(),R.anim.side_animation);
        plumb_toolbar.setAnimation(side_animation);

        plumb_call_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall1();
            }
        });

        plumb_whatsapp_chat_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onWhatsappChat1();
            }
        });
        plumb_start_service_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.dashboard_frame_layout, new timer(), null);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return callView;
    }
    private void makePhoneCall1() {
        String phoneNumber = "+923080935691";
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[] {Manifest.permission.CALL_PHONE},
                    REQUEST_CALL_PHONE);
        } else {
            String dial = "tel:" + phoneNumber;
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
        }
    }
    private void onWhatsappChat1() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        try {
            String toNumber = "+923080935691";
            Intent sendIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + "" + toNumber + "?body=" + ""));
            sendIntent.setPackage("com.whatsapp");
            startActivity(sendIntent);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getActivity(), "For whatsapp-chat install simple-whatsapp", Toast.LENGTH_LONG).show();

        }
    }
}