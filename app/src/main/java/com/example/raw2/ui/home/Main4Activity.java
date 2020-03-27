package com.example.raw2.ui.home;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.raw2.R;


public class Main4Activity extends AppCompatActivity {

    ListView firstBooks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

               getSupportActionBar().setTitle("Books");


        firstBooks = (ListView)findViewById(R.id.firstBooks);


    String [] firstBook = {"Math1","Chemistry","Electrical","Electronics","Mechanics","C","Physics","EEE","Graphics","Communication","M2","Civil" };
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,firstBook){

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            View view = super.getView(position, convertView, parent);
            TextView myText = (TextView)findViewById(android.R.id.text1);
            return view;
        }
    };
        firstBooks.setAdapter(adapter);

                }
                }