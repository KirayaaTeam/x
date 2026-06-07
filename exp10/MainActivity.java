package com.example.sqlitedemo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    EditText etName;
    Button btnSave;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        btnSave = findViewById(R.id.btnSave);

        dbHelper = new DBHelper(this);

        btnSave.setOnClickListener(v ->
        {
            dbHelper.insertData(
                    etName.getText().toString());

            Toast.makeText(
                    MainActivity.this,
                    "Data Saved",
                    Toast.LENGTH_SHORT).show();

            etName.setText("");
        });
    }
}