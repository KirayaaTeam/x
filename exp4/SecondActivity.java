package com.example.intentsapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView txtInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtInfo = findViewById(R.id.txtInfo);

        String name = getIntent().getStringExtra("username");

        txtInfo.setText("Welcome " + name);
    }
}
