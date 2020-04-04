package com.example.raw2.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.raw2.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomListview extends ArrayAdapter<String> {

    private String[] fruitname;
    private  Integer[] imgid;
    private Activity context;

    public CustomListview(Activity context, String[] fruitname, Integer[] imgid) {
        super(context, R.layout.listview_layout,fruitname);

        this.context = context;
        this.fruitname = fruitname;
        this.imgid = imgid;



    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View r = convertView;

        ViewHolder viewHolder = null;
        if (r==null){

            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.listview_layout,null,true);
            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else {

            viewHolder = (ViewHolder) r.getTag();
        }

        viewHolder.ivw.setImageResource((imgid[position]));
        viewHolder.tvw1.setText(fruitname[position]);




        return r;


    }

    class ViewHolder {
        TextView tvw1;
        ImageView ivw;

        ViewHolder(View v) {
            tvw1 = (TextView) v.findViewById(R.id.tvfruitname);
            ivw = (ImageView) v.findViewById(R.id.imageView);

        }
    }
}
