package com.example.doorsteptechnician;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

public class Technician_register extends AppCompatActivity {

    TextView tech_name,tech_shop_name,tech_shop_address,tech_phone_number,tech_wp_number;
    ImageView tech_upload_image,tech_Image;
    Button tech_submit;
    Uri ImageUri;
    private FirebaseDatabase tech_database;
    private FirebaseStorage tech_firebaseStorage;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technician_register);

        tech_name= findViewById(R.id.tech_name);
        tech_shop_name= findViewById(R.id.tech_shop_name);
        tech_shop_address= findViewById(R.id.tech_shop_address);
        tech_phone_number= findViewById(R.id.tech_phone_number);
        tech_wp_number= findViewById(R.id.tech_wp_number);

        tech_upload_image= findViewById(R.id.tech_upload_image);
        tech_Image= findViewById(R.id.tech_Image);

        tech_submit= findViewById(R.id.tech_submit);
//
        tech_database= FirebaseDatabase.getInstance();
        tech_firebaseStorage= FirebaseStorage.getInstance();

        progressDialog= new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("Please wait...");
        progressDialog.setTitle("Technician Details Uploading...");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
//
        tech_upload_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImage();
            }
        });
        tech_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
                if (tech_name.length() == 0) {
                    tech_name.setError("Full Name Required");
                } else if (tech_name.length()<5) {
                    tech_name.setError("kindly write Full Name");
                }
                else if (tech_shop_name.length()==0) {
                    tech_shop_name.setError("Shop Name Required");
                }
                else if (tech_shop_address.length()==0) {
                    tech_shop_address.setError("Shop Address Required");
                } else if (tech_shop_address.length()<7) {
                    tech_shop_address.setError("Please enter correct Shop Address");
                }
                else if (tech_phone_number.length()==0) {
                    tech_phone_number.setError("Phone Number Required");
                } else if (tech_phone_number.length()<11) {
                    tech_phone_number.setError("Please enter valid Phone Number");
                }
                else if (tech_wp_number.length()==0) {
                    tech_wp_number.setError("Whatsapp Number Required");
                } else if (tech_wp_number.length()<11) {
                    tech_wp_number.setError("Please enter valid Whatsapp Number");
                }
                else {

                    progressDialog.show();

                    final StorageReference reference = tech_firebaseStorage.getReference().child("Technician")
                            .child(System.currentTimeMillis() + "");
                    reference.putFile(ImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    TechnicianModel tech_Model = new TechnicianModel();
                                    tech_Model.setTech_Image(uri.toString());

                                    tech_Model.setTech_name(tech_name.getText().toString());
                                    tech_Model.setTech_shop_name(tech_shop_name.getText().toString());
                                    tech_Model.setTech_shop_address(tech_shop_address.getText().toString());
                                    tech_Model.setTech_phone_number(tech_phone_number.getText().toString());
                                    tech_Model.setTech_wp_number(tech_wp_number.getText().toString());

                                    tech_database.getReference().child("Technician").push().setValue(tech_Model)
                                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void unused) {

                                                    progressDialog.dismiss();

                                                    Toast.makeText(Technician_register.this, "Technician Data Upload Successfully", Toast.LENGTH_SHORT).show();
                                                }
                                            }).addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull Exception e) {
                                                    progressDialog.dismiss();
                                                    Toast.makeText(Technician_register.this, "Error Occurred", Toast.LENGTH_SHORT).show();
                                                }
                                            });
                                }
                            });
                        }
                    });
//
                }
            }
        });
    }
    //    image Up load
    private void uploadImage(){
        Dexter.withContext(this)
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        Intent intent= new Intent();
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_GET_CONTENT);
                        startActivityForResult(intent, 101);
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                        Toast.makeText(Technician_register.this, "Permission Denied", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                }).check();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==101 && resultCode== RESULT_OK){
            ImageUri = data.getData();
            tech_Image.setImageURI(ImageUri);
        }
    }
    //    image upload
}