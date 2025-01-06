package com.example.liveinlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class Insights extends AppCompatActivity {
    BarChart barChart;
    BarData barData;
    BarDataSet barDataSet;
    ArrayList barentries;
    ListView Courses;

    TextView Txt1;
    ImageView k1, k2, k3, k4, k5;

    Button btn1;

    Animation fade_in_anim;
    String [] Val = {"Computer Science", "Electrical", "Civil", "Chemical", "Mechanical"};
    //LegendEntry Leg_str = new LegendEntry(new int[] {Color.RED, Color.GREEN, Color.GRAY, Color.YELLOW, Color.BLUE}, Val);

    //LegendEntry Legends = new (Leg_str);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insights);

        barChart = findViewById(R.id.chart1);
        getData();
        barDataSet = new BarDataSet(barentries, "Data Set");
        barDataSet.setColors(new int[] {Color.parseColor("#ff9ff3"), Color.parseColor("#0abde3"), Color.parseColor("#feca57"), Color.parseColor("#10ac84"), Color.parseColor("#341f97")});
        barData = new BarData(barDataSet);

        barChart.setData(barData);
        barChart.animateXY(2000, 2000);
        barChart.getAxisLeft().setDrawGridLines(false);
        barChart.getAxisRight().setDrawGridLines(false);
        barChart.getXAxis().setDrawGridLines(false);
        //barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.parseColor("#FFFFFF"));
        barChart.getDescription().setEnabled(false);
        barDataSet.setValueTextSize(8f);

        Legend l = barChart.getLegend();
        //l.setEntries((List<LegendEntry>) Leg_str);
        l.setEnabled(false);
        l.setFormSize(10f); // set the size of the legend forms/shapes
        l.setForm(Legend.LegendForm.CIRCLE); // set what type of form/shape should be used
        l.setTextSize(12f);
        l.setPosition(Legend.LegendPosition.ABOVE_CHART_CENTER);
        l.setTextColor(Color.WHITE);
        //l.setCustom(new int[] {Color.RED, Color.GREEN, Color.GRAY, Color.YELLOW, Color.BLUE}, Val);
        //l.setXEntrySpace(5f); // set the space between the legend entries on the x-axis
        //l.setYEntrySpace(5f); // set the space between the legend entries on the y-axis

        Courses = findViewById(R.id.List1);
        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, Val);
        Courses.setAdapter(arr);

        k1 = (ImageView) findViewById(R.id.b1);
        k2 = (ImageView) findViewById(R.id.b2);
        k3 = (ImageView) findViewById(R.id.b3);
        k4 = (ImageView) findViewById(R.id.b4);
        k5 = (ImageView) findViewById(R.id.b5);

        Txt1 = (TextView) findViewById(R.id.txt1);

        btn1 = (Button) findViewById(R.id.btn_1);

        fade_in_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);

        k1.startAnimation(fade_in_anim);

        k2.startAnimation(fade_in_anim);

        k3.startAnimation(fade_in_anim);

        k4.startAnimation(fade_in_anim);

        k5.startAnimation(fade_in_anim);

        final Context context = this;

        btn1.setOnClickListener(v -> {

            Intent intent = new Intent(context, AboutStream1.class);
            startActivity(intent);
        });

    }

    private void getData()
    {
        barentries = new ArrayList<>();
        barentries.add(new BarEntry(1f, Float.parseFloat(result.Mark_list.get(0))));
        barentries.add(new BarEntry(2f, Float.parseFloat(result.Mark_list.get(1))));
        barentries.add(new BarEntry(3f, Float.parseFloat(result.Mark_list.get(2))));
        barentries.add(new BarEntry(4f, Float.parseFloat(result.Mark_list.get(3))));
        barentries.add(new BarEntry(5f, Float.parseFloat(result.Mark_list.get(4))));


    }
}
