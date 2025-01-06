package com.example.liveinlab;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class after_signup extends AppCompatActivity {

    TextView name;
    TextView welcome_msg;
    TextView Info1;

    TextView Info2;
    Button btn1, btn2;
    Animation fade_in_anim;

    Animation move_left;
    Animation bounce_anim;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_signup);

        name = (TextView)findViewById(R.id.user_name);

        welcome_msg= (TextView)findViewById(R.id.wel_msg);

        Info1 = (TextView)findViewById(R.id.info_1);

        Info2 = (TextView)findViewById(R.id.info_2);

        btn1 = (Button)findViewById(R.id.Start_Btn);

        btn2 = (Button)findViewById(R.id.About_Btn);

        name.setText((CharSequence) MainActivity.user);
        //YoYo.with(Techniques.r).duration(1000).playOn(name);

        fade_in_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);

        bounce_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);

        move_left = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_ltr);

        welcome_msg.startAnimation(fade_in_anim);

        Info1.startAnimation(fade_in_anim);

        Info2.startAnimation(fade_in_anim);

        btn1.startAnimation(bounce_anim);

        btn2.startAnimation(bounce_anim);

        name.startAnimation(move_left);

        final Context context = this;

        btn1.setOnClickListener(v -> {

            Intent intent = new Intent(context, mainpage.class);
            startActivity(intent);
        });

        /*btn2.setOnClickListener(v -> {

            Intent intent = new Intent(context, mainpage.class);
            startActivity(intent);
        });*/
    }
}