package com.example.liveinlab;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class KnowMore extends AppCompatActivity {

    TextView mark;

    TextView text3;

    TextView text4;

    Button btn1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.know_more);

        mark = (TextView) findViewById(R.id.res1);

        text3 = (TextView) findViewById(R.id.txt3);

        text4 = (TextView) findViewById(R.id.txt4);

        btn1 = (Button) findViewById(R.id.btn_1);

        mark.setText(result.Max_Subject_Val.substring(0,2)+"%");

        text3.setText(result.Max_Subject);

        final Context context = this;

        btn1.setOnClickListener(v -> {

            Intent intent = new Intent(context, Insights.class);
            startActivity(intent);
        });

    }
}