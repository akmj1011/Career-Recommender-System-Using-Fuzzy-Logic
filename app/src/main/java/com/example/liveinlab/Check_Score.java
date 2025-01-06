package com.example.liveinlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Check_Score extends AppCompatActivity {

    String Msg = "These are your latest scores";

    String warn_msg = "NIL";
    TextView math_score;
    TextView cs_score;
    TextView phy_score;
    TextView chem_score;

    TextView math_text;
    TextView cs_text;
    TextView phy_text;
    TextView chem_text;

    Button History;
    ImageButton info_yellow;
    Animation move;
    Animation move1;
    ArrayList<ArrayList> math_list = new ArrayList<>();
    ArrayList<ArrayList> cs_list = new ArrayList<>();
    ArrayList<ArrayList> phy_list = new ArrayList<>();
    ArrayList<ArrayList> chem_list = new ArrayList<>();

    //ArrayAdapter Marks_Adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_score);

        math_score=findViewById(R.id.math_mark);
        cs_score=findViewById(R.id.cs_mark);
        phy_score=findViewById(R.id.phy_mark);
        chem_score=findViewById(R.id.chem_mark);

        math_text=findViewById(R.id.math_text);
        cs_text=findViewById(R.id.cs_text);
        phy_text=findViewById(R.id.phy_text);
        chem_text=findViewById(R.id.chem_text);

        final Context context = this;

        info_yellow = findViewById(R.id.info_btn);

        History = findViewById(R.id.history_btn);

        History.setBackgroundColor(Color.parseColor("#FFCB2F"));

        info_yellow.setOnClickListener(v -> Toast.makeText(this, Msg, Toast.LENGTH_LONG).show());

        math_text.setPaintFlags(math_text.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);
        cs_text.setPaintFlags(math_text.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);
        phy_text.setPaintFlags(math_text.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);
        chem_text.setPaintFlags(math_text.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);

        move = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_ltr);

        move1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_rtl);

        math_text.startAnimation(move);

        cs_text.startAnimation(move1);

        phy_text.startAnimation(move);

        chem_text.startAnimation(move1);

        DB2 dataBaseHelper = new DB2(Check_Score.this);

        Show_String(dataBaseHelper);

        History.setOnClickListener(v -> {
            Intent intent = new Intent(context, Score_History.class);
            startActivity(intent);
            //Score_History.empty_message.setVisibility(View.VISIBLE);
        });
    }
    /*private void Show_Marks(DB2 dataBaseHelper) {
        Marks_Adapter = new ArrayAdapter<>(MainActivity2.this, android.R.layout.simple_list_item_1, dataBaseHelper.getEveryone().get(0));
        Marks.setAdapter(Marks_Adapter);
    }*/

    private void Show_String(DB2 dataBaseHelper)
    {
        math_list=dataBaseHelper.getEverything().get(0);
        cs_list=dataBaseHelper.getEverything().get(1);
        phy_list=dataBaseHelper.getEverything().get(2);
        chem_list=dataBaseHelper.getEverything().get(3);

        if(math_list.isEmpty() || cs_list.isEmpty() || phy_list.isEmpty() || chem_list.isEmpty())
        {
            math_score.setText(warn_msg);
            cs_score.setText(warn_msg);
            phy_score.setText(warn_msg);
            chem_score.setText(warn_msg);
        }
        else
        {
            math_score.setText((CharSequence) math_list.get(math_list.size() - 1));
            cs_score.setText((CharSequence) cs_list.get(cs_list.size() - 1));
            phy_score.setText((CharSequence) phy_list.get(phy_list.size() - 1));
            chem_score.setText((CharSequence) chem_list.get(chem_list.size() - 1));
        }
    }
}