package com.example.blind2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.blind2.function_library.ContactOperations;

public class ContactTesting extends AppCompatActivity {

    EditText txt;
    Button search;
    Button delt;
    Boolean b;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_testing);

        txt = (EditText) findViewById(R.id.text1);
        search = (Button) findViewById(R.id.search);
        tv = (TextView) findViewById(R.id.textView);
        delt = (Button) findViewById(R.id.delete);

        if (ContextCompat.checkSelfPermission(ContactTesting.this, Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(ContactTesting.this,
                    new String[]{Manifest.permission.READ_CONTACTS,Manifest.permission.WRITE_CONTACTS},
                    1);// Permission is not granted
        }

        search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String phonenum = (String)txt.getText().toString();
                ContactOperations.Insert2Contacts(ContactTesting.this,"Sample Contact","9876543210");


                b = ContactOperations.isTheNumberExistsinContacts(ContactTesting.this,phonenum);

                if(b) {
                    tv.setText("Number is present");
                    Toast.makeText(getApplicationContext(), "Number present", Toast.LENGTH_SHORT).show();
                }
                else {
                    tv.setText("Number is absent");
                    Toast.makeText(getApplicationContext(), "Number absent", Toast.LENGTH_SHORT).show();
                }
            }
        });

        delt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContactOperations.deleteContact(ContactTesting.this,"9876543210");
            }
        });

    }
}
