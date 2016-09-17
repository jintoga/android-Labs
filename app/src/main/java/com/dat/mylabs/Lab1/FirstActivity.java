package com.dat.mylabs.Lab1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.dat.mylabs.R;

public class FirstActivity extends AppCompatActivity {

    public static final String KEY_TXT = "TEXT";
    @Bind(R.id.editText1)
    protected EditText editText1;
    @Bind(R.id.editText2)
    protected EditText editText2;

    public static void startActivity(Context context) {
        if (context instanceof FirstActivity) {
            return;
        }
        Intent intent = new Intent(context, FirstActivity.class);
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
        Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
        intent.putExtra(KEY_TXT, txt);
        startActivity(intent);
    }
}
