package com.yash.utuparentportal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class two extends AppCompatActivity implements View.OnClickListener {

            private CardView car1, car2, car3, car4;
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_two);
                car1 = (CardView) findViewById(R.id.d1);
                car2 = (CardView) findViewById(R.id.d2);
                car3 = (CardView) findViewById(R.id.d3);
                car4 = (CardView) findViewById(R.id.d4);
                car1.setOnClickListener(this);
                car2.setOnClickListener(this);
                car3.setOnClickListener(this);
                car4.setOnClickListener(this);
                // Toolbar toolbar = findViewById(R.id.toolbar);
                //setSupportActionBar(toolbar);
                //getSupportActionBar().setTitle("Uka Tarsadia University");


                BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);
                bottomNavigationView.setSelectedItemId(R.id.college);

                bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                        switch (menuItem.getItemId()) {
                            case R.id.college:
                                return true;

                            case R.id.parent:
                                startActivity(new Intent(getApplicationContext(), ParentActivity.class));
                                overridePendingTransition(0, 0);
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
            public void onClick (View v){
                Intent i;
                switch (v.getId()) {
                    case R.id.d1:
                        i = new Intent(this, cata1.class);
                        startActivity(i);
                        break;
                    case R.id.d2:
                        i = new Intent(this, cata2.class);
                        startActivity(i);
                        break;
                    case R.id.d3:
                        i = new Intent(this, cata3.class);
                        startActivity(i);
                        break;
                    case R.id.d4:
                        i = new Intent(this, cata4.class);
                        startActivity(i);
                        break;
                }
            }
        }




