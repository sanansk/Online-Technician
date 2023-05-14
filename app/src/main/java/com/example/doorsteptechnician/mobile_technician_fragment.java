package com.example.doorsteptechnician;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class mobile_technician_fragment extends Fragment {

    private static final int REQUEST_CALL_PHONE = 1;
    Button mobile_call_btn1, mobile_call_btn2, mobile_call_btn3;
    Button mobile_whatsapp_chat_btn1, mobile_whatsapp_chat_btn2, mobile_whatsapp_chat_btn3;
    Button mobile_start_service_btn1, mobile_start_service_btn2,mobile_start_service_btn3;
    TextView mobile_toolbar;
    Animation side_animation;
    public mobile_technician_fragment() {
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
        View callView= inflater.inflate(R.layout.fragment_mobile_technician_fragment, container, false);

        mobile_call_btn1 = callView.findViewById(R.id.mobile_call_btn1);
        mobile_call_btn2 = callView.findViewById(R.id.mobile_call_btn2);
        mobile_call_btn3 = callView.findViewById(R.id.mobile_call_btn3);

        mobile_whatsapp_chat_btn1= callView.findViewById(R.id.mobile_whatsapp_chat_btn1);
        mobile_whatsapp_chat_btn2= callView.findViewById(R.id.mobile_whatsapp_chat_btn2);
        mobile_whatsapp_chat_btn3= callView.findViewById(R.id.mobile_whatsapp_chat_btn3);

        mobile_start_service_btn1=callView.findViewById(R.id.mobile_start_service_btn1);
        mobile_start_service_btn2=callView.findViewById(R.id.mobile_start_service_btn2);
        mobile_start_service_btn3=callView.findViewById(R.id.mobile_start_service_btn3);

        mobile_toolbar= callView.findViewById(R.id.mobile_toolbar);
        side_animation= AnimationUtils.loadAnimation(getActivity(),R.anim.side_animation);
        mobile_toolbar.setAnimation(side_animation);

        // Mobile Phone Call ClickListener
        mobile_call_btn1.setOnClickListener(v -> makePhoneCall1());
        mobile_call_btn2.setOnClickListener(v -> makePhoneCall2());
        mobile_call_btn3.setOnClickListener(v -> makePhoneCall3());
        // Whatsapp Chat ClickListener
        mobile_whatsapp_chat_btn1.setOnClickListener(v -> onWhatsappChat1());
        mobile_whatsapp_chat_btn2.setOnClickListener(v -> onWhatsappChat2());
        mobile_whatsapp_chat_btn3.setOnClickListener(v -> onWhatsappChat3());

        mobile_start_service_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.dashboard_frame_layout, new timer(), null);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        mobile_start_service_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.dashboard_frame_layout, new timer(), null);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        mobile_start_service_btn3.setOnClickListener(new View.OnClickListener() {
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

    // Mobile Call Methods
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
        private void makePhoneCall2(){
            String phoneNumber = "+923017555595";
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(), new String[] {Manifest.permission.CALL_PHONE},
                        REQUEST_CALL_PHONE);
            } else {
                String dial = "tel:" + phoneNumber;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    private void makePhoneCall3(){
        String phoneNumber = "+923016254224";
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[] {Manifest.permission.CALL_PHONE},
                    REQUEST_CALL_PHONE);
        } else {
            String dial = "tel:" + phoneNumber;
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
        }
    }
    // Whatsapp Chat Methods
    private void onWhatsappChat1() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        try {
            String toNumber = "+923037830728";
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
            String toNumber = "+923017555595";
            Intent sendIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + "" + toNumber + "?body=" + ""));
            sendIntent.setPackage("com.whatsapp");
            startActivity(sendIntent);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getActivity(), "For whatsapp-chat install simple-whatsapp", Toast.LENGTH_LONG).show();

        }
    }
    private void onWhatsappChat3() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        try {
            String toNumber = "+923016254224";
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
                    makePhoneCall2();
                    makePhoneCall3();
                } else {
                    Toast.makeText(getActivity(), "Permission Denied", Toast.LENGTH_SHORT).show();
                }
            }
    }
}