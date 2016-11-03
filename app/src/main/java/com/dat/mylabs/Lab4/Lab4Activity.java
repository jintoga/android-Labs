package com.dat.mylabs.Lab4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.dat.mylabs.R;
import java.util.Arrays;

public class Lab4Activity extends AppCompatActivity {

    @Bind(R.id.listView)
    protected ListView listView;
    private CustomAdapter adapter;

    public static void startActivity(Context context) {
        if (context instanceof Lab4Activity) {
            return;
        }
        Intent intent = new Intent(context, Lab4Activity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab4);
        ButterKnife.bind(this);
        init();
    }

    private void init() {

        adapter = new CustomAdapter(this, Arrays.asList(dummyData()));
        listView.setAdapter(adapter);
    }

    private String[] dummyData() {
        return new String[] {
            "http://androidexample.com/media/webservice/LazyListView_images/image0.png",
            "http://androidexample.com/media/webservice/LazyListView_images/image1.png",
            "http://androidexample.com/media/webservice/LazyListView_images/image2.png",
            "http://androidexample.com/media/webservice/LazyListView_images/image3.png",
            "http://androidexample.com/media/webservice/LazyListView_images/image4.png",
            "http://androidexample.com/media/webservice/LazyListView_images/image5.png",
            "http://androidexample.com/media/webservice/LazyListView_images/image6.png",
            "http://androidexample.com/media/webservice/LazyListView_images/image7.png",
            "http://androidexample.com/media/webservice/LazyListView_images/image8.png",
            "http://androidexample.com/media/webservice/LazyListView_images/image9.png",
            "http://androidexample.com/media/webservice/LazyListView_images/image10.png",
        };
    }
}
