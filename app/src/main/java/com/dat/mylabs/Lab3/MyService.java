package com.dat.mylabs.Lab3;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private boolean shouldRun;

    public MyService() {
    }

    @Override
    public void onCreate() {
        shouldRun = true;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (shouldRun) {
                    long futureTime = System.currentTimeMillis() + 1000;
                    while (System.currentTimeMillis() < futureTime) {
                        synchronized (this) {
                            try {
                                wait(futureTime - System.currentTimeMillis());
                                Log.d("TAG", "STICKY SERVICE doing something every 1s");
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        Log.d("TAG", "DESTROYING STICKY SERVICE");
        shouldRun = false;
        super.onDestroy();
    }
}
