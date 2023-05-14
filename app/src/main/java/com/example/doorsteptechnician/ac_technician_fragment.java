package com.example.doorsteptechnician;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
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


public class ac_technician_fragment extends Fragment {
    private static final int REQUEST_CALL_PHONE = 1;
    private static int SPLASH_SCREEN = 3000;
    Button ac_call_btn1, ac_call_btn2, ac_whatsapp_chat_btn1, ac_whatsapp_chat_btn2;
    Button ac_start_service_btn1, ac_start_service_btn2;
    TextView ac_toolbar;
    Animation side_animation;

    public ac_technician_fragment() {
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
        View callView = inflater.inflate(R.layout.fragment_ac_technician, container, false);


        ac_call_btn1= callView.findViewById(R.id.ac_call_btn1);
        ac_call_btn2= callView.findViewById(R.id.ac_call_btn2);

        ac_whatsapp_chat_btn1= callView.findViewById(R.id.ac_whatsapp_chat_btn1);
        ac_whatsapp_chat_btn2= callView.findViewById(R.id.ac_whatsapp_chat_btn2);

        ac_start_service_btn1=callView.findViewById(R.id.ac_start_service_btn1);
        ac_start_service_btn2=callView.findViewById(R.id.ac_start_service_btn2);

        ac_toolbar= callView.findViewById(R.id.ac_toolbar);
        side_animation= AnimationUtils.loadAnimation(getActivity(),R.anim.side_animation);
        ac_toolbar.setAnimation(side_animation);

        ac_call_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall1();
            }
        });
        ac_call_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall2();
            }
        });
        ac_whatsapp_chat_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onWhatsappChat1();
            }
        });
        ac_whatsapp_chat_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onWhatsappChat2();
            }
        });
        ac_start_service_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.dashboard_frame_layout, new timer(), null);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        ac_start_service_btn2.setOnClickListener(new View.OnClickListener() {
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
        String phoneNumber = "+923093112522";
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[] {Manifest.permission.CALL_PHONE},
                    REQUEST_CALL_PHONE);
        } else {
            String dial = "tel:" + phoneNumber;
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
        }
    }
    private void makePhoneCall2(){
        String phoneNumber = "+923046809155";
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
            String toNumber = "+923078781017";
            Intent sendIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + "" + toNumber + "?body=" + ""));
            sendIntent.setPackage("com.whatsapp");
            startActivity(sendIntent);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getActivity(), "For whatsapp-chat install simple-whatsapp", Toast.LENGTH_LONG).show();

        }
    }
    private void onWhatsappChat2() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        try {
            String toNumber = "+923046809155";
            Intent sendIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + "" + toNumber + "?body=" + ""));
            sendIntent.setPackage("com.whatsapp");
            startActivity(sendIntent);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getActivity(), "For whatsapp-chat install simple-whatsapp", Toast.LENGTH_LONG).show();

        }
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL_PHONE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall1();
            } else {
                Toast.makeText(getActivity(), "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}