package com.example.sdcarddemo;

import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity
{
    EditText etData;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etData = findViewById(R.id.etData);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v ->
        {
            try
            {
                File path =
                        Environment.getExternalStorageDirectory();

                File file =
                        new File(path, "MyFile.txt");

                FileOutputStream fos =
                        new FileOutputStream(file);

                fos.write(
                        etData.getText()
                        .toString()
                        .getBytes());

                fos.close();

                Toast.makeText(
                        MainActivity.this,
                        "Data Saved",
                        Toast.LENGTH_LONG).show();
            }
            catch (Exception e)
            {
                Toast.makeText(
                        MainActivity.this,
                        e.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}