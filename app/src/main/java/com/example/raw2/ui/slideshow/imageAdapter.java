package com.example.raw2.ui.slideshow;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.raw2.R;

public class imageAdapter extends BaseAdapter {

    private Context mContext;

    public int [] imageArray  = {

       R.drawable.sy,
            R.drawable.bull,

            R.drawable.paper


    };

    public imageAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return imageArray.length;
    }

    @Override
    public Object getItem(int position) {
         return imageArray[position];
    }

    @Override
    public long getItemId(int position) {
        return imageArray[position];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(imageArray[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(700,320));

        return imageView;
    }
}
