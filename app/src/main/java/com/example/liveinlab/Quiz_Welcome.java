package com.example.liveinlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class Quiz_Welcome extends AppCompatActivity {

    Button Test;
    Animation move;

    Animation fade_in_anim;

    Animation bounce_anim;
    TextView Welcome;

    TextView Info;

    TextView Info_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_welcome);
        Test = (Button) findViewById(R.id.Start_Btn);
        Welcome = (TextView) findViewById(R.id.wel_msg);
        Info = (TextView) findViewById(R.id.info_1);
        Info_1 = (TextView) findViewById(R.id.info_2);
        move = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_ltr);
        fade_in_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);
        bounce_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        Welcome.startAnimation(move);
        Info.startAnimation(fade_in_anim);
        Info_1.startAnimation(fade_in_anim);
        Test.startAnimation(bounce_anim);

        final Context context = this;
        Test.setOnClickListener(v -> {

            Intent intent = new Intent(context, Personality_test.class);
            startActivity(intent);
        });

    }
}