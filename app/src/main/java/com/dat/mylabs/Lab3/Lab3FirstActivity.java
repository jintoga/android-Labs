package com.dat.mylabs.Lab3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.dat.mylabs.R;

public class Lab3FirstActivity extends AppCompatActivity {

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
}
