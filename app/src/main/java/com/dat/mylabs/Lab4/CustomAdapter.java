package com.dat.mylabs.Lab4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.dat.mylabs.R;
import java.util.List;

/**
 * Created by DAT on 11/3/2016.
 */

public class CustomAdapter extends ArrayAdapter<String> {

    private List<String> data;

    public CustomAdapter(Context context, List<String> data) {
        super(context, 0, data);
        this.data = data;
    }

    @Override
    public int getCount() {
        if (data == null) {
            return 0;
        }
        return data.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        ViewHolder holder;

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.item_lab4, null);

            holder = new ViewHolder();
            holder.photo = (ImageView) view.findViewById(R.id.photo);
            holder.progress = (ProgressBar) view.findViewById(R.id.progress);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        String url = getItem(position);
        if (url != null) {
            new ImageLoader(holder.photo, holder.progress, url).execute();
        }
        return view;
    }

    public class ViewHolder {
        private ImageView photo;
        private ProgressBar progress;
    }
}
