package com.dat.mylabs.Lab3;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyNotStickyService extends Service {
    public MyNotStickyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_NOT_STICKY;
    }
}
