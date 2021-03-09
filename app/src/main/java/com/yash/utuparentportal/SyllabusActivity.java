package com.yash.utuparentportal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SyllabusActivity extends AppCompatActivity {

    private CardView cardView1,cardView2,cardView3,cardView4;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);

        cardView1 = findViewById(R.id.cv);
        cardView2 = findViewById(R.id.cv1);
        cardView3 = findViewById(R.id.cv2);
        cardView4 = findViewById(R.id.cv3);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(SyllabusActivity.this, AwdSyllabusActivity.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(homeIntent);
                finish();
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(SyllabusActivity.this, IsSyllabusActivity.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(homeIntent);
                finish();
            }
        });

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(SyllabusActivity.this, CiSyllabusActivity.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(homeIntent);
                finish();
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(SyllabusActivity.this, PySyllabusActivity.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(homeIntent);
                finish();
            }
        });

    }
    @Override
    public void onBackPressed() {
        Intent homeIntent = new Intent(SyllabusActivity.this,MainActivity2.class);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(homeIntent);
        finish();
    }
}