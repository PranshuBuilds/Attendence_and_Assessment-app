package com.example.s4;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.round;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {

    float attendance[]={91.3f,67.8f,74.3f,89.4f,74.9f,89.2f,87.4f,54.5f};
    String subName[]={"ENGLISH","C.O.A","DATA STR","AUTOMATA","GRAPH THEORY","MINOR PROJECT","NETWORKING","WEB TECH"},n;
    float l,blank;

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_fragment1, container, false);


        List<PieEntry> pieEntryList=new ArrayList<>();
        TextView t =(TextView) v.findViewById(R.id.textView6);
        TextView t2 =(TextView) v.findViewById(R.id.textView4);
        TextView t3 =(TextView) v.findViewById(R.id.textView33);
        TextView t4 =(TextView) v.findViewById(R.id.textView63);
        TextView t5 =(TextView) v.findViewById(R.id.textView1);



        for(int i=0;i<subName.length;i++){
            pieEntryList.add(new PieEntry(attendance[i],subName[i]));
            l+=attendance[i];


            n+=((subName[i]+" "+attendance[i])+"\n");
        }

        t.setText(subName[2]);
        t2.setText(subName[3]);
        t3.setText(subName[4]);
        t4.setText(subName[5]);
        t5.setText(subName[6]);







        return v;



    }

}
