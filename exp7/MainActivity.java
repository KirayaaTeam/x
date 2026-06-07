package com.example.notificationdemo;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity
{
    Button btnNotify;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNotify = findViewById(R.id.btnNotify);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel channel =
                    new NotificationChannel(
                            "MyChannel",
                            "My Notification",
                            NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager manager =
                    getSystemService(NotificationManager.class);

            manager.createNotificationChannel(channel);
        }

        btnNotify.setOnClickListener(v ->
        {
            Intent intent =
                    new Intent(MainActivity.this,
                            MainActivity.class);

            PendingIntent pendingIntent =
                    PendingIntent.getActivity(
                            MainActivity.this,
                            0,
                            intent,
                            PendingIntent.FLAG_IMMUTABLE);

            NotificationCompat.Builder builder =
                    new NotificationCompat.Builder(
                            MainActivity.this,
                            "MyChannel")

                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setContentTitle("Android Notification")
                            .setContentText("Button Clicked")
                            .setContentIntent(pendingIntent)
                            .setAutoCancel(true);

            NotificationManagerCompat managerCompat =
                    NotificationManagerCompat.from(
                            MainActivity.this);

            managerCompat.notify(1, builder.build());
        });
    }
}