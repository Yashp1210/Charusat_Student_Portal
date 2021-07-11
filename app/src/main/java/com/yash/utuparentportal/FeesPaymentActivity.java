package com.yash.utuparentportal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

public class FeesPaymentActivity extends AppCompatActivity implements PaymentResultListener {

    Button feespayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fees_payment);

        feespayment = findViewById(R.id.btn);

        String sAmount = "1000";
        int amount = Math.round(Float.parseFloat(sAmount) * 100);


        feespayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Checkout checkout = new Checkout();
                checkout.setKeyID("rzp_test_v89SqmjaSbxTxc");
                checkout.setImage(R.drawable.logo);
                JSONObject object = new JSONObject();
                try {
                    object.put("name","UTU Payment Gateway");
                    object.put("description","Pay Your Semester fees");
                    object.put("currency","INR");
                    object.put("amount","100000");
                    object.put("currency","INR");
                    object.put("prefill.contact","9856547586");
                    object.put("prefill.email","utu.ac.in@gmail.com");
                    checkout.open(FeesPaymentActivity.this,object);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    @Override
    public void onPaymentSuccess(String s) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Payment Id");
        builder.setMessage(s);
        builder.show();

    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onBackPressed() {
        Intent homeIntent = new Intent(FeesPaymentActivity.this,MainActivity2.class);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(homeIntent);
        finish();
    }
}