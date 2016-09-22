package com.dat.mylabs.Lab1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.dat.mylabs.Constants;
import com.dat.mylabs.R;

public class Lab1FirstActivity extends AppCompatActivity {

    @Bind(R.id.editText1)
    protected EditText editText1;
    @Bind(R.id.editText2)
    protected EditText editText2;

    public static void startActivity(Context context) {
        if (context instanceof Lab1FirstActivity) {
            return;
        }
        Intent intent = new Intent(context, Lab1FirstActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.next)
    protected void goToNext() {
        String txt = editText1.getText().toString() + " " + editText2.getText().toString();
        Intent intent = new Intent(Lab1FirstActivity.this, Lab1SecondActivity.class);
        intent.putExtra(Constants.KEY_TXT_1, txt);
        startActivity(intent);
    }
}
