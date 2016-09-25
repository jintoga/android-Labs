package com.dat.mylabs.Lab3;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by DAT on 9/26/2016.
 */
public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("MyIntentService", "doing something");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }
}
