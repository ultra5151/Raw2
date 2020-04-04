package com.example.raw2.ui.tools;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.raw2.R;
import com.example.raw2.ui.slideshow.IT;
import com.example.raw2.ui.slideshow.Main11Activity;
import com.example.raw2.ui.slideshow.Main13Activity;
import com.example.raw2.ui.slideshow.Main14Activity;
import com.example.raw2.ui.slideshow.Main15Activity;
import com.example.raw2.ui.slideshow.Main16Activity;


public class Main23Activity extends AppCompatActivity {

    ListView branch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main23);

        getSupportActionBar().setTitle("Branch");

        branch = (ListView)findViewById(R.id.branch);

        String [] Branch = {"CSE","IT","Electrical","Electronic","Mechanical","Civil" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,Branch){

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                View view = super.getView(position, convertView, parent);
                TextView myText = (TextView)findViewById(android.R.id.text1);
                return view;
            }
        };
        branch.setAdapter(adapter);


        branch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position==0){
                    startActivity(new Intent(getApplicationContext(), Main11Activity.class));
                }

                if(position==1){
                    startActivity(new Intent(getApplicationContext(), IT.class));
                }

                if(position==2){
                    startActivity(new Intent(getApplicationContext(), Main13Activity.class));
                }
                if(position==3){
                    startActivity(new Intent(getApplicationContext(), Main14Activity.class));
                }
                if(position==4){
                    startActivity(new Intent(getApplicationContext(), Main15Activity.class));
                }
                if(position==5){
                    startActivity(new Intent(getApplicationContext(), Main16Activity.class));
                }

            }
        });



    }
}
