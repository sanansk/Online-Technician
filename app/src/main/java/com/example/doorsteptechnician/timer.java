package com.example.doorsteptechnician;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.Toast;


public class timer extends Fragment {
    ImageView clock_minute_hand;
    Animation round_anim;
    Button start_task, end_task, cancel_service, complete_task;
    Chronometer chronometer;
    private boolean running;

    public timer() {
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
        View callView = inflater.inflate(R.layout.fragment_timer, container, false);

        clock_minute_hand = callView.findViewById(R.id.clock_minute_hand);
        start_task = callView.findViewById(R.id.start_task);
        end_task = callView.findViewById(R.id.end_task);
        complete_task = callView.findViewById(R.id.complete_task);
        cancel_service = callView.findViewById(R.id.cancel_service);
        chronometer = callView.findViewById(R.id.chronometer);
        //optional animation
        end_task.setAlpha(0);

        round_anim = AnimationUtils.loadAnimation(getActivity(), R.anim.round_anim);

        start_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!running) {
                    clock_minute_hand.startAnimation(round_anim);
                    start_task.animate().alpha(0).setDuration(300).start();
                    end_task.animate().alpha(1).translationY(-65).setDuration(300).start();
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    chronometer.start();
                    running = true;
                }
            }
        });
        end_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (running) {
                    clock_minute_hand.clearAnimation();
                    chronometer.stop();
                    running = false;
                }
            }
        });
        complete_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), payment.class);
                startActivity(intent);
            }
        });
        cancel_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.dashboard_frame_layout, new cancel_service_fragment(), null);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return callView;
    }
}