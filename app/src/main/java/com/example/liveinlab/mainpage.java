package com.example.liveinlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class mainpage extends AppCompatActivity {

    TextView s;
    EditText m1;
    EditText m2;
    EditText m3;
    EditText m4;
    Button btn;
    ImageButton Info_btn;
    DB2 DB;
    String msg_1;
    public static String Math, Comp_Science, Physics, Chemistry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

        s=(TextView)findViewById(R.id.marks);
        m1=(EditText)findViewById(R.id.maths);
        m2=(EditText)findViewById(R.id.cs);
        m3=(EditText)findViewById(R.id.physics);
        m4=(EditText)findViewById(R.id.chem);
        btn=(Button)findViewById(R.id.btnsignup);
        Info_btn=(ImageButton)findViewById(R.id.info_btn);
        DB = new DB2(this);
        msg_1 = "Enter Marks scored in your 12th Grade Board Exams";

        final Context context = this;

        Info_btn.setOnClickListener(v -> Toast.makeText(context, msg_1, Toast.LENGTH_LONG).show());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Math=m1.getText().toString();
                Comp_Science=m2.getText().toString();
                Physics=m3.getText().toString();
                Chemistry=m4.getText().toString();

                if(Math.equals("")||Comp_Science.equals("")||Physics.equals("")||Chemistry.equals("")) {
                    Toast.makeText(context, "One or more fields are empty", Toast.LENGTH_SHORT).show();
                }
                if(Integer.parseInt(Math)>100||Integer.parseInt(Comp_Science)>100||Integer.parseInt(Physics)>100||Integer.parseInt(Chemistry)>100) {
                    Toast.makeText(context, "Marks cannot exceed 100", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean conf = DB.insertmarks(Math, Comp_Science, Physics, Chemistry);
                    if(conf==true)
                    {
                        Toast.makeText(mainpage.this, "Marks Stored Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(context, Quiz_Welcome.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(mainpage.this, "Database Error", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}