package com.example.blind2.function_library;

import android.content.Intent;
import android.net.Uri;

import static androidx.core.content.ContextCompat.startActivity;

public class CallOperations {

    public static void callTo(String number)
    {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:"+number));

        startActivity(callIntent);
    }


}
