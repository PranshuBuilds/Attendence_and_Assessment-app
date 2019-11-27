package com.example.s4;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.round;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {
    float attendance[]={91.3f,67.8f,74.3f,89.4f,74.9f,89.2f,87.4f,54.5f};
    String subName[]={"ENGLISH","C.O.A","DATA STR","AUTOMATA","GRAPH THEORY","MINOR PROJECT","NETWORKING","WEB TECH"},a,s;
    float l,blank;


    public Fragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment2, container, false);
        TextView t =(TextView) v.findViewById(R.id.textView33);
        TextView t2 =(TextView) v.findViewById(R.id.textView44);

        List<PieEntry> pieEntryList=new ArrayList<>();
        for(int i=0;i<subName.length;i++){
            pieEntryList.add(new PieEntry(attendance[i],subName[i]));
            l+=attendance[i];

            s+=(subName[i]+"\n\n");
            a+=(attendance[i]+"\n\n");



        }
        blank=((91.3f+67.8f+74.3f+89.4f+74.9f+89.2f+87.4f+54.5f)/800)*100;

        t.setText(a);
        t2.setText(s);

        PieDataSet dataSet=new PieDataSet(pieEntryList," ");
        PieData data=new PieData(dataSet);
        Float.toString(blank);
        PieChart chart =(PieChart) v.findViewById(R.id.piechart);
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        dataSet.setLabel("Attendence");
        chart.setCenterText((round(blank))+"%");
        chart.setCenterTextSize(20f);
        chart.setCenterTextColor(R.color.white);
        chart.setHoleColor(Color.TRANSPARENT);
        chart.setDrawHoleEnabled(true);
        chart.animateY(500);

        chart.setData(data);
        chart.invalidate();
        // Inflate the layout for this fragment
        return v;
    }

}
