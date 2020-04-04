package com.example.raw2.ui.slideshow;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.raw2.R;
import com.example.raw2.ui.home.Main2Activity;
import com.example.raw2.ui.home.Main4Activity;
import com.example.raw2.ui.home.Main5Activity;
import com.example.raw2.ui.tools.CustomListview;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    ListView lst;


    String [] fruitname = { "Syllabus","Books","Question Paper"};
    Integer[] imgid = {R.drawable.sysy,R.drawable.book57,R.drawable.brain57};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        lst = (ListView)root.findViewById(R.id.listview);
        CustomListview customListview = new CustomListview(getActivity(),fruitname,imgid);
        lst.setAdapter(customListview);


        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position==0){

                    startActivity(new Intent(getContext(), Main8Activity.class));
                }

                else if (position==1){

                    startActivity(new Intent(getContext(), Main9Activity.class));
                }
                else if (position==2){

                    startActivity(new Intent(getContext(), Main10Activity.class));
                }



            }
        });




        return root;
    }
}