package com.example.intentdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    EditText etName, etMobile;
    Button btnNext, btnSMS;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etMobile = findViewById(R.id.etMobile);

        btnNext = findViewById(R.id.btnNext);
        btnSMS = findViewById(R.id.btnSMS);

        btnNext.setOnClickListener(v ->
        {
            Intent intent = new Intent(MainActivity.this,
                    SecondActivity.class);

            intent.putExtra("name",
                    etName.getText().toString());

            intent.putExtra("mobile",
                    etMobile.getText().toString());

            startActivity(intent);
        });

        btnSMS.setOnClickListener(v ->
        {
            Intent smsIntent = new Intent(
                    Intent.ACTION_VIEW);

            smsIntent.setData(
                    Uri.parse("sms:" +
                    etMobile.getText().toString()));

            smsIntent.putExtra("sms_body",
                    "Hello from Android App");

            startActivity(smsIntent);
        });
    }
}