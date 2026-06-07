package com.example.alarmdemo;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    Button btnAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAlarm = findViewById(R.id.btnAlarm);

        btnAlarm.setOnClickListener(v ->
        {
            Intent intent =
                    new Intent(AlarmClock.ACTION_SET_ALARM);

            intent.putExtra(
                    AlarmClock.EXTRA_MESSAGE,
                    "Android Practical");

            intent.putExtra(
                    AlarmClock.EXTRA_HOUR,
                    10);

            intent.putExtra(
                    AlarmClock.EXTRA_MINUTES,
                    30);

            startActivity(intent);
        });
    }
}