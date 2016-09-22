package com.dat.mylabs.Lab2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.dat.mylabs.Constants;
import com.dat.mylabs.R;

public class Lab2FirstActivity extends AppCompatActivity {

    @Bind(R.id.result)
    protected TextView result;

    public static void startActivity(Context context) {
        if (context instanceof Lab2FirstActivity) {
            return;
        }
        Intent intent = new Intent(context, Lab2FirstActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2_first);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.next)
    protected void goToNext() {
        Intent intent = new Intent(Lab2FirstActivity.this, Lab2SecondActivity.class);
        startActivityForResult(intent, Constants.REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constants.REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            String str1 = data.getStringExtra(Constants.KEY_TXT_1);
            String str2 = data.getStringExtra(Constants.KEY_TXT_2);
            result.setText(str1 + "  " + str2);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
