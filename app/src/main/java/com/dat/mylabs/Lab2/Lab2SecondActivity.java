package com.dat.mylabs.Lab2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.dat.mylabs.Constants;
import com.dat.mylabs.R;

public class Lab2SecondActivity extends AppCompatActivity {

    @Bind(R.id.editText1)
    protected EditText editText1;
    @Bind(R.id.editText2)
    protected EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2_second);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.finish)
    protected void finishWithRes() {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEY_TXT_1, editText1.getText().toString());
        intent.putExtra(Constants.KEY_TXT_2, editText2.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        finishWithRes();
    }
}
