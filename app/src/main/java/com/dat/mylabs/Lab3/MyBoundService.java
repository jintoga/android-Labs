package com.dat.mylabs.Lab3;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyBoundService extends Service {
    private LocalBinder binder = new LocalBinder();
    private StopWatch stopWatch;

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("TAG", "service created");
        stopWatch = new StopWatch();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    public void startStopWatch() {
        Log.d("TAG", "start");
        stopWatch.start();
    }

    public void stopStopWatch() {
        Log.d("TAG", "pause");
        stopWatch.stop();
    }

    public long getElapsedTime() {
        return stopWatch.getElapsedTime();
    }

    public String getFormattedElapsedTime() {
        return formatElapsedTime(getElapsedTime());
    }

    private String formatElapsedTime(long now) {
        long hours = 0, minutes = 0, seconds = 0/*, tenths = 0*/;
        StringBuilder sb = new StringBuilder();

        if (now < 1000) {
            //tenths = now / 10;
        } else if (now < 60000) {
            seconds = now / 1000;
            //now -= seconds * 1000;
            //tenths = (now / 10);
        } else if (now < 3600000) {
            hours = now / 3600000;
            now -= hours * 3600000;
            minutes = now / 60000;
            now -= minutes * 60000;
            seconds = now / 1000;
            //now -= seconds * 1000;
            //tenths = (now / 10);
        }
        sb.append(formatDigits(hours))
            .append(":")
            .append(formatDigits(minutes))
            .append(":")
            .append(formatDigits(seconds));

        return sb.toString();
    }

    private String formatDigits(long num) {
        return (num < 10) ? "0" + num : new Long(num).toString();
    }

    public class LocalBinder extends Binder {
        MyBoundService getService() {
            return MyBoundService.this;
        }
    }
}
