package com.example.blind2;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.example.blind2.function_library.CallOperations;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

public class CallTesting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_testing);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        EditText str1 = (EditText) findViewById(R.id.editText1);
        Button btn = (Button) findViewById(R.id.button1);

        if (ContextCompat.checkSelfPermission(CallTesting.this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(CallTesting.this,
                    new String[]{Manifest.permission.READ_CONTACTS,Manifest.permission.CALL_PHONE},
                    1);
        }


        String number;
        number="7798830543";
        CallOperations.callTo(number,this);




        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
