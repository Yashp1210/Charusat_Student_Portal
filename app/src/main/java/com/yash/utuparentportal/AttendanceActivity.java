package com.yash.utuparentportal;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

public class AttendanceActivity extends AppCompatActivity {

    private TextView sub1,sub2,sub3,sub4;
    private FirebaseAuth mAuth;
    private FirebaseUser mCurrentuser;
    private FirebaseFirestore fStore;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        sub1 = findViewById(R.id.pp1);
        sub2 = findViewById(R.id.pp2);
        sub3 = findViewById(R.id.pp3);
        sub4 = findViewById(R.id.pp4);

        mAuth = FirebaseAuth.getInstance();
        mCurrentuser = mAuth.getCurrentUser();
        fStore = FirebaseFirestore.getInstance();

        userId = mAuth.getCurrentUser().getUid();
        DocumentReference documentReference = fStore.collection("Users").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                sub1.setText(documentSnapshot.getString("Advanced web Development"));
                sub2.setText(documentSnapshot.getString("Information Security"));
                sub3.setText(documentSnapshot.getString("Programming with Python"));
                sub4.setText(documentSnapshot.getString("Cloud Infrastructure"));
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent homeIntent = new Intent(AttendanceActivity.this,MainActivity2.class);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(homeIntent);
        finish();
    }
}