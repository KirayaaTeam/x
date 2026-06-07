package com.example.intentdemo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity
{
    TextView txtInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtInfo = findViewById(R.id.txtInfo);

        String name =
                getIntent().getStringExtra("name");

        String mobile =
                getIntent().getStringExtra("mobile");

        txtInfo.setText(
                "Name : " + name +
                "\nMobile : " + mobile);
    }
}