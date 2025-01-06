package com.example.liveinlab;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class WelcomePage extends AppCompatActivity {

    TextView name;
    TextView welcome_msg;
    TextView Info1;
    Button btn1;
    Animation fade_in_anim;

    Animation bounce_anim;

    final Context context = this;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.score_check:
                Intent intent = new Intent(context, Check_Score.class);
                startActivity(intent);
                return true;
        }
            return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        name = (TextView)findViewById(R.id.user_name);

        welcome_msg= (TextView)findViewById(R.id.wel_msg);

        Info1 = (TextView)findViewById(R.id.info_1);

        btn1 = (Button)findViewById(R.id.Start_Btn);

        name.setText((CharSequence) loginmain.user);
        //YoYo.with(Techniques.r).duration(1000).playOn(name);

        fade_in_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);

        bounce_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);

        welcome_msg.startAnimation(fade_in_anim);

        Info1.startAnimation(fade_in_anim);

        btn1.startAnimation(bounce_anim);

        btn1.setOnClickListener(v -> {

            Intent intent = new Intent(context, mainpage.class);
            startActivity(intent);
        });
    }
}