package com.yash.utuparentportal;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.auth.User;
import com.google.gson.JsonObject;
import com.razorpay.Checkout;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity2 extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Button mLogoutBtn;
    private TextView name,enrollment_no,department;
    private ImageView image;
    private FirebaseUser mCurrentuser;
    private FirebaseFirestore fStore;
    private String userId;
    private CardView Attendence,timetable,exammarks,syllabus,remarks,event_calender,feespayment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        mAuth = FirebaseAuth.getInstance();
        mLogoutBtn = findViewById(R.id.btn);
        mCurrentuser = mAuth.getCurrentUser();
        name = findViewById(R.id.tv2);
        enrollment_no = findViewById(R.id.tv3);
        department = findViewById(R.id.tv4);
        fStore = FirebaseFirestore.getInstance();
        image = findViewById(R.id.iv1);
        Attendence = findViewById(R.id.cv1);
        timetable = findViewById(R.id.cv2);
        exammarks = findViewById(R.id.cv3);
        syllabus = findViewById(R.id.cv5);
        remarks = findViewById(R.id.cv4);
        event_calender = findViewById(R.id.cv6);
        feespayment = findViewById(R.id.cv7);



        feespayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(MainActivity2.this,FeesPaymentActivity.class);
                startActivity(homeIntent);
                finish();
            }
        });

        event_calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(MainActivity2.this,EventCalenderActivity.class);
                startActivity(homeIntent);
                finish();
            }
        });

        remarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(MainActivity2.this,RemarksActivity.class);
                startActivity(homeIntent);
                finish();
            }
        });

        syllabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(MainActivity2.this, SyllabusActivity.class);
                startActivity(homeIntent);
                finish();
            }
        });

        exammarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(MainActivity2.this,ExammarksActivity.class);
                startActivity(homeIntent);
                finish();
            }
        });

        timetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(MainActivity2.this,TimetableActivity.class);
                startActivity(homeIntent);
                finish();
            }
        });


        Attendence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(MainActivity2.this,AttendanceActivity.class);
                startActivity(homeIntent);
                finish();

            }
        });


        userId = mAuth.getCurrentUser().getUid();
        DocumentReference documentReference = fStore.collection("Users").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                name.setText(documentSnapshot.getString("Name"));
                enrollment_no.setText(documentSnapshot.getString("Enrollment Number"));
                department.setText(documentSnapshot.getString("Department"));




            }
        });



        mLogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAuth.signOut();
                sendUserToLogin();
            }
        });
    }

    public void sendUserToLogin(){
        Intent homeIntent = new Intent(MainActivity2.this,ParentActivity.class);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(homeIntent);
        finish();
    }
    @Override
    public void onBackPressed() {
        Intent homeIntent = new Intent(MainActivity2.this,HomeActivity.class);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(homeIntent);
        finish();
    }
}