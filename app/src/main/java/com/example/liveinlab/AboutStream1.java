package com.example.liveinlab;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.Objects;

public class AboutStream1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_stream1);

        TextView Title;
        TextView abt;
        TextView cnt;

        Button Btn1;

        Animation fade_anim;

        Animation bounce;

        Animation moveltr;


        fade_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);
        bounce = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        moveltr = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_ltr);

        Title = (TextView) findViewById(R.id.tit);
        abt = (TextView) findViewById(R.id.txt1);
        cnt = (TextView) findViewById(R.id.txt2);

        Btn1 = (Button) findViewById(R.id.btn_1);

        Title.startAnimation(fade_anim);

        abt.startAnimation(bounce);

        abt.setText(result.Max_Subject.toUpperCase());

        abt.setPaintFlags(abt.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        if(Objects.equals(result.Max_Subject, "Civil Engineering"))
        {
            cnt.setText(getResources().getString(R.string.Civil));
        }

        else if(Objects.equals(result.Max_Subject, "Computer Science and Engineering"))
        {
            cnt.setText(getResources().getString(R.string.CSE));
        }

        else if(Objects.equals(result.Max_Subject, "Electrical Engineering"))
        {
            cnt.setText(getResources().getString(R.string.EEE));
        }

        else if(Objects.equals(result.Max_Subject, "Chemical Engineering"))
        {
            cnt.setText(getResources().getString(R.string.Chem));
        }

        else if(Objects.equals(result.Max_Subject, "Mechanical Engineering"))
        {
            cnt.setText(getResources().getString(R.string.Mech));
        }

        cnt.startAnimation(moveltr);

        final Context context = this;

        Btn1.setOnClickListener(v -> {

            Intent intent = new Intent(context, AboutStream2.class);
            startActivity(intent);
        });

        }
    }
