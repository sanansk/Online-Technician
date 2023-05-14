package com.example.doorsteptechnician;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

public class cancel_service_fragment extends Fragment {

    CheckBox cancel_service_r1, cancel_service_r2, cancel_service_r3, cancel_service_r4, cancel_service_r5, cancel_service_r6, cancel_service_r7;
    Button cancel_service_btn;

    public cancel_service_fragment() {
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
        View callView=inflater.inflate(R.layout.fragment_cancel_service_fragment, container, false);

        cancel_service_r1 = callView.findViewById(R.id.cancel_service_r1);
        cancel_service_r2 = callView.findViewById(R.id.cancel_service_r2);
        cancel_service_r3 = callView.findViewById(R.id.cancel_service_r3);
        cancel_service_r4 = callView.findViewById(R.id.cancel_service_r4);
        cancel_service_r5 = callView.findViewById(R.id.cancel_service_r5);
        cancel_service_r6 = callView.findViewById(R.id.cancel_service_r6);
        cancel_service_r7 = callView.findViewById(R.id.cancel_service_r7);

        cancel_service_btn = callView.findViewById(R.id.cancel_service_btn);
        cancel_service_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (error()) {
                    openAlertBox();
                }
            }
                private boolean error() {
                    if (!cancel_service_r1.isChecked() && !cancel_service_r2.isChecked() && !cancel_service_r3.isChecked() && !cancel_service_r4.isChecked() &&
                            !cancel_service_r5.isChecked() && !cancel_service_r6.isChecked() && !cancel_service_r7.isChecked()) {
                        openalert();
                        return false;
                    }
                    return true;
                }
            private void openalert() {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("CheckBox Alert");
                builder.setMessage("Please select at least 1 CheckBox Reason");
                builder.setCancelable(false);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        return callView;
    }
    private void openAlertBox() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Request Confirmation");
        builder.setMessage("Do you really wants to cancel service");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getActivity(), dashboard.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}