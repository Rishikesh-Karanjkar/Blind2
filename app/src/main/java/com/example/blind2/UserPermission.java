package com.example.blind2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.CALL_PHONE;
import static android.Manifest.permission.GET_ACCOUNTS;
import static android.Manifest.permission.READ_CONTACTS;
import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.SEND_SMS;
import static android.Manifest.permission.WRITE_CONTACTS;
import static android.Manifest.permission_group.CAMERA;

public class UserPermission extends AppCompatActivity {

    Button allow;
    public static final int RequestPermissionCode = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_permission);

        allow = (Button) findViewById(R.id.allow);

        allow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Adding if condition inside button.

                // If All permission is enabled successfully then this block will execute.
                if (CheckingPermissionIsEnabledOrNot()) {
                    Toast.makeText(UserPermission.this, "All Permissions Granted Successfully", Toast.LENGTH_LONG).show();
                }

                // If, If permission is not enabled then else condition will execute.
                else {

                    //Calling method to enable permission.
                    RequestMultiplePermission();
                }
            }
        });
    }

    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {

            case RequestPermissionCode:

                if (grantResults.length > 0) {

                    boolean CameraPermission = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean RecordAudioPermission = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                    boolean SendSMSPermission = grantResults[2] == PackageManager.PERMISSION_GRANTED;
                    boolean GetAccountsPermission = grantResults[3] == PackageManager.PERMISSION_GRANTED;

                    boolean ReadContactsPermission = grantResults[4] == PackageManager.PERMISSION_GRANTED;
                    boolean WriteContactsPermission = grantResults[5] == PackageManager.PERMISSION_GRANTED;
                    boolean CallPhonePermission = grantResults[6] == PackageManager.PERMISSION_GRANTED;
                    boolean LocationPermission = grantResults[7] == PackageManager.PERMISSION_GRANTED;

                    if (CameraPermission && RecordAudioPermission && SendSMSPermission && GetAccountsPermission && ReadContactsPermission && WriteContactsPermission && CallPhonePermission && LocationPermission) {

                        Toast.makeText(UserPermission.this, "Permission Granted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(UserPermission.this, "Permission Denied", Toast.LENGTH_LONG).show();

                    }
                }

                break;
        }
    }

    private void RequestMultiplePermission() {
        // Creating String Array with Permissions.
        ActivityCompat.requestPermissions(UserPermission.this, new String[]
                {
                        CAMERA,
                        RECORD_AUDIO,
                        SEND_SMS,
                        GET_ACCOUNTS,
                        READ_CONTACTS,
                        WRITE_CONTACTS,
                        CALL_PHONE,
                        ACCESS_FINE_LOCATION
                }, RequestPermissionCode);
    }

    private boolean CheckingPermissionIsEnabledOrNot() {
        int FirstPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), CAMERA);
        int SecondPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), RECORD_AUDIO);
        int ThirdPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), SEND_SMS);
        int ForthPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), GET_ACCOUNTS);

        int FifthPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), READ_CONTACTS);
        int SixthPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_CONTACTS);
        int SeventhPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE);
        int EighthPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), ACCESS_FINE_LOCATION);

        return FirstPermissionResult == PackageManager.PERMISSION_GRANTED &&
                SecondPermissionResult == PackageManager.PERMISSION_GRANTED &&
                ThirdPermissionResult == PackageManager.PERMISSION_GRANTED &&
                ForthPermissionResult == PackageManager.PERMISSION_GRANTED &&
                FifthPermissionResult == PackageManager.PERMISSION_GRANTED &&
                SixthPermissionResult == PackageManager.PERMISSION_GRANTED &&
                SeventhPermissionResult == PackageManager.PERMISSION_GRANTED &&
                EighthPermissionResult == PackageManager.PERMISSION_GRANTED;

    }

}