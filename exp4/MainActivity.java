package com.example.intentsapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etMobile;
    Button btnNext, btnSMS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etMobile = findViewById(R.id.etMobile);

        btnNext = findViewById(R.id.btnNext);
        btnSMS = findViewById(R.id.btnSMS);

        // Explicit Intent

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etName.getText().toString();

                Intent intent = new Intent(MainActivity.this,
                        SecondActivity.class);

                intent.putExtra("username", name);

                startActivity(intent);
            }
        });

        // Implicit Intent for SMS

        btnSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mobile = etMobile.getText().toString();

                Intent smsIntent = new Intent(Intent.ACTION_VIEW);

                smsIntent.setData(Uri.parse("sms:" + mobile));

                smsIntent.putExtra("sms_body",
                        "Hello from Android App");

                startActivity(smsIntent);
            }
        });
    }
}
