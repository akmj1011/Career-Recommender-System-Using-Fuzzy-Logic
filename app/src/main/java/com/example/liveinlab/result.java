package com.example.liveinlab;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

import java.util.ArrayList;
import java.util.List;

public class result extends AppCompatActivity {
    TextView result1;
    TextView result2;

    Button know_more;
    Animation bounce_anim;

    Animation fade_anim;

    static String Max_Subject;

    static String Max_Subject_Val;

    String Subs_String;

    String Mark_list_String;
    static ArrayList<String> Subs = new ArrayList<String>();

    static ArrayList<String> Mark_list = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        bounce_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);

        fade_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);


        result1 = (TextView)findViewById(R.id.res1);
        result2 = (TextView) findViewById(R.id.res2);
        know_more = (Button) findViewById(R.id.btn_1);

        know_more.startAnimation(bounce_anim);

        result1.startAnimation(fade_anim);

        if(!Python.isStarted())
            Python.start(new AndroidPlatform(this));

        final Python py=Python.getInstance();


        PyObject pyo = py.getModule("mark_processing");
        PyObject obj = pyo.callAttr("main", mainpage.Math, mainpage.Physics, mainpage.Comp_Science, mainpage
                .Chemistry);
        List<PyObject> array= obj.asList();

        Max_Subject = array.get(0).toString();
        Max_Subject_Val = array.get(1).toString();

        Mark_list.clear();
        Subs.clear();

        for (PyObject elem : array.get(2).asList()) {
            Subs.add(elem.toString());
        }

        for (PyObject elem : array.get(3).asList()) {
            Mark_list.add(elem.toString());
        }

        //Mark_list_String = Mark_list.toString();

        //Subs_String = Subs.toString();

        result2.setText(Max_Subject);

        //result2.setText(Max_Subject);

        final Context context = this;

        know_more.setOnClickListener(v -> {

            Intent intent = new Intent(context, KnowMore.class);
            startActivity(intent);
        });


    }

}