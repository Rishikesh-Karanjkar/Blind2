package com.example.blind2.function_library;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import static androidx.core.content.ContextCompat.startActivity;

public class CallOperations {

    public static void callTo(String number, Context context)
    {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:"+number));

        context.startActivity(callIntent);
    }

    public static void messageTo(String number, String msg, Context context)
    {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:"+number));

        context.startActivity(callIntent);
    }


}
