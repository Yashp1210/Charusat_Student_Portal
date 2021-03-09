package com.yash.utuparentportal;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class ExammarksActivity extends AppCompatActivity {

    private TextView awdm1,awdm2,ism1,ism2,cim1,cim2,pym1,pym2;
    private FirebaseAuth mAuth;
    private FirebaseUser mCurrentuser;
    private FirebaseFirestore fStore;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exammarks);

        awdm1 = findViewById(R.id.awdm1);
        awdm2 = findViewById(R.id.awdm2);
        ism1 = findViewById(R.id.ism1);
        ism2 = findViewById(R.id.ism2);
        cim1 = findViewById(R.id.cim1);
        cim2 = findViewById(R.id.cim2);
        pym1 = findViewById(R.id.pym1);
        pym2 = findViewById(R.id.pym2);


        mAuth = FirebaseAuth.getInstance();
        mCurrentuser = mAuth.getCurrentUser();
        fStore = FirebaseFirestore.getInstance();

        userId = mAuth.getCurrentUser().getUid();
        DocumentReference documentReference = fStore.collection("Users").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                awdm1.setText(documentSnapshot.getString("midsem1 score awd"));
                ism1.setText(documentSnapshot.getString("midsem1 score is"));
                pym1.setText(documentSnapshot.getString("midsem1 score py"));
                cim1.setText(documentSnapshot.getString("midsem1 score ci"));


                awdm2.setText(documentSnapshot.getString("midsem2 score awd"));
                ism2.setText(documentSnapshot.getString("midsem2 score is"));
                pym2.setText(documentSnapshot.getString("midsem2 score py"));
                cim2.setText(documentSnapshot.getString("midsem2 score ci"));
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent homeIntent = new Intent(ExammarksActivity.this,MainActivity2.class);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(homeIntent);
        finish();
    }
}