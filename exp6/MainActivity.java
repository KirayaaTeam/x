package com.example.demo;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    Spinner spinner;
    Button btnAlert, btnPopup;
    TextView txtTouch;

    String items[] = {"Java", "Android", "Python"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        btnAlert = findViewById(R.id.btnAlert);
        btnPopup = findViewById(R.id.btnPopup);
        txtTouch = findViewById(R.id.txtTouch);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                items);

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(
                new android.widget.AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(
                    android.widget.AdapterView<?> parent,
                    View view,
                    int position,
                    long id)
            {
                Toast.makeText(MainActivity.this,
                        items[position],
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(
                    android.widget.AdapterView<?> parent)
            {

            }
        });

        btnAlert.setOnClickListener(v ->
        {
            AlertDialog.Builder builder =
                    new AlertDialog.Builder(MainActivity.this);

            builder.setTitle("Alert");
            builder.setMessage("This is Alert Dialog");

            builder.setPositiveButton("OK",
                    (dialog, which) -> {});

            builder.show();
        });

        btnPopup.setOnClickListener(v ->
        {
            PopupMenu popup =
                    new PopupMenu(MainActivity.this,
                            btnPopup);

            popup.getMenu().add("Save");
            popup.getMenu().add("Delete");

            popup.setOnMenuItemClickListener(item ->
            {
                Toast.makeText(MainActivity.this,
                        item.getTitle(),
                        Toast.LENGTH_SHORT).show();

                return true;
            });

            popup.show();
        });

        txtTouch.setOnTouchListener((v, event) ->
        {
            if(event.getAction() ==
                    MotionEvent.ACTION_DOWN)
            {
                Toast.makeText(MainActivity.this,
                        "Screen Touched",
                        Toast.LENGTH_SHORT).show();
            }
            return true;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        menu.add("Home");
        menu.add("About");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(
            MenuItem item)
    {
        Toast.makeText(this,
                item.getTitle(),
                Toast.LENGTH_SHORT).show();

        return true;
    }
}