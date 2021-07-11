package com.yash.utuparentportal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.common.hash.HashingOutputStream;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.jar.Attributes;

public class HomeActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseUser mCurrentuser;
    private TextView name,enrollment_no,department;
    private ImageView image;
    private FirebaseFirestore fStore;
    private String userId;
    private CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mAuth = FirebaseAuth.getInstance();
        mCurrentuser = mAuth.getCurrentUser();
        name = findViewById(R.id.tv2);
        enrollment_no = findViewById(R.id.tv3);
        department = findViewById(R.id.tv4);
        fStore = FirebaseFirestore.getInstance();
        image = findViewById(R.id.iv1);
        cardView = findViewById(R.id.cv);

        
            userId = mAuth.getCurrentUser().getUid();
            DocumentReference documentReference = fStore.collection("Users").document(userId);
            documentReference.addSnapshotListener(this,new EventListener<DocumentSnapshot>() {
                @Override
                public void onEvent(@Nullable DocumentSnapshot documentSnapshot,@NonNull FirebaseFirestoreException e) {
                    if(documentSnapshot.exists()){
                        name.setText(documentSnapshot.getString("Name"));
                        enrollment_no.setText(documentSnapshot.getString("Enrollment Number"));
                        department.setText(documentSnapshot.getString("Department"));
                    }else{
                        Intent homeIntent = new Intent(HomeActivity.this, MainActivity3.class);
                        startActivity(homeIntent);
                        finish();
                    }


                }
            });

    cardView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent homeIntent = new Intent(HomeActivity.this, MainActivity2.class);
            startActivity(homeIntent);
            finish();

        }
    });


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.parent);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.college:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.parent:
                        return true;

                    case R.id.message:
                        startActivity(new Intent(getApplicationContext(), MessageActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        if(mCurrentuser == null){
            sendUserToLogin();
        }
    }

    public void sendUserToLogin(){
        Intent homeIntent = new Intent(HomeActivity.this,ParentActivity.class);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(homeIntent);
        finish();
    }

}