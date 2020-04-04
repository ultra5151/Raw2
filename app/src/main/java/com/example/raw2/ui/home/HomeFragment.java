package com.example.raw2.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.raw2.R;
import com.example.raw2.ui.tools.CustomListview;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    ListView lst;


    String [] fruitname = { "Syllabus","Books","Question Paper"};
    Integer[] imgid = {R.drawable.sysy,R.drawable.book57,R.drawable.brain57};


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_home, container, false);


        lst = (ListView)root.findViewById(R.id.listview);
        CustomListview customListview = new CustomListview(getActivity(),fruitname,imgid);
        lst.setAdapter(customListview);


        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position==0){

                    startActivity(new Intent(getContext(),Main2Activity.class));
                }

               else if (position==1){

                    startActivity(new Intent(getContext(),Main4Activity.class));
                }
                else if (position==2){

                    startActivity(new Intent(getContext(),Main5Activity.class));
                }



            }
        });




        return root;

    }
}