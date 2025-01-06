package com.example.liveinlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class Personality_Result extends AppCompatActivity {

    TextView Result;

    TextView Info;
    Button Next;

    Animation fade_in_anim;

    Animation bounce_anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personality_result);

        Result=(TextView) (findViewById(R.id.res2));
        Next = (Button) (findViewById(R.id.btn_1));
        Info = (TextView) (findViewById(R.id.res1));
        Result.setText(Personality_test.personality);

        fade_in_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);
        bounce_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);

        Info.startAnimation(fade_in_anim);

        Result.startAnimation(bounce_anim);


        final Context context = this;

        Next.setOnClickListener(v -> {

            Intent intent = new Intent(context, result.class);
            startActivity(intent);
        });

    }
}