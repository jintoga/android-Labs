package com.dat.mylabs.Lab1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.dat.mylabs.Constants;
import com.dat.mylabs.R;

public class Lab1SecondActivity extends AppCompatActivity {
    @Bind(R.id.result)
    protected TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        String txt = getIntent().getStringExtra(Constants.KEY_TXT_1);
        result.setText(txt);
    }
}
