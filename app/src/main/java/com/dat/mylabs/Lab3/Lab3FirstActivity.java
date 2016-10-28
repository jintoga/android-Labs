package com.dat.mylabs.Lab3;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.dat.mylabs.R;

public class Lab3FirstActivity extends AppCompatActivity {
    private MyBoundService stopWatchService;

    @Bind(R.id.time)
    protected TextView time;

    public static void startActivity(Context context) {
        if (context instanceof Lab3FirstActivity) {
            return;
        }
        Intent intent = new Intent(context, Lab3FirstActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.next)
    protected void goToNext() {
        Intent intent = new Intent(Lab3FirstActivity.this, Lab3SecondActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.startIntentService)
    protected void startIntentService() {
        Intent intent = new Intent(Lab3FirstActivity.this, MyIntentService.class);
        startService(intent);
    }

    @OnClick(R.id.startService)
    protected void startService() {
        Intent intent = new Intent(Lab3FirstActivity.this, MyService.class);
        startService(intent);
    }

    @OnClick(R.id.stopService)
    protected void stopService() {
        Intent intent = new Intent(Lab3FirstActivity.this, MyService.class);
        stopService(intent);
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            stopWatchService = ((MyBoundService.LocalBinder) service).getService();
            stopWatchService.startStopWatch();
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    time.setText(getElapsedTime());
                    handler.postDelayed(this, 1000);
                }
            };
            handler.post(runnable);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            stopWatchService = null;
        }
    };

    private Handler handler = new Handler();

    @OnClick(R.id.startBoundService)
    protected void startBoundService() {
        Intent intent = new Intent(this, MyBoundService.class);
        startService(intent);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    protected String getElapsedTime() {
        if (stopWatchService != null) {
            return stopWatchService.getFormattedElapsedTime();
        }
        return "";
    }

    protected void unbindStopwatchService() {
        if (stopWatchService != null) {
            unbindService(serviceConnection);
        }
    }

    @Override
    protected void onDestroy() {
        unbindStopwatchService();
        super.onDestroy();
    }
}
