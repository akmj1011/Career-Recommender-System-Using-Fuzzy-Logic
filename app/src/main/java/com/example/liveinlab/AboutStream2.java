package com.example.liveinlab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Objects;

public class AboutStream2 extends AppCompatActivity {

    String [] adv = {"Computer Science", "Electrical", "Civil", "Chemical", "Mechanical"};
    String [] cha = {"Computer Science", "Electrical", "Civil", "Chemical", "Mechanical"};
    ListView Adv;
    ListView Cha;

    Animation move;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_stream2);

        if(Objects.equals(result.Max_Subject, "Civil Engineering"))
        {
            adv= new String[]{"Diverse Specializations", "Government Opportunities", "Global Opportunities", "Entrepreneurial Opportunities"};
            cha = new String[]{"Competitive Job Market", "Salary Disparities", "Challenges in Infrastructure", "Lack of Practical Exposure", "Work-Life Balance"};
        }

        else if(Objects.equals(result.Max_Subject, "Computer Science and Engineering"))
        {
            adv= new String[]{"High Demand for IT Professionals", "Global Opportunities", "Entrepreneurial Opportunities", "Continuous Innovation", "Competitive Salaries"};
            cha = new String[]{"High Competition", "Rapid Technological Changes", "Work Pressure and Deadlines", "Quality of Education", "Outsourcing Challenges"};
        }

        else if(Objects.equals(result.Max_Subject, "Electrical Engineering"))
        {
            adv= new String[]{"Wide Range of Opportunities", "Core Industry Presence", "Global Recognition", "Research and Development Opportunities", "Entrepreneurial Opportunities"};
            cha = new String[]{"Competitive Job Market", "Challenging Curriculum", "Technological Complexity", "Limited Industry Exposure in Some Institutions", "Dependency on Power Sector"};
        }

        else if(Objects.equals(result.Max_Subject, "Chemical Engineering"))
        {
            adv= new String[]{"Diverse Career Opportunities", "Global Demand", "Innovation and Research", "Contribution to Sustainable Practices", "Process Optimization in Industries"};
            cha = new String[]{"Challenging Curriculum", "Job Market Fluctuations", "Limited Industry Exposure in Some Institutions", "Safety Concerns", "Dependency on Specific Industries"};
        }

        else if(Objects.equals(result.Max_Subject, "Mechanical Engineering"))
        {
            adv= new String[]{"Interdisciplinary Opportunities", "High Industry Demand", "Foundation for Further Specialization", "Hands-On Experience"};
            cha = new String[]{"Limited Focus in Some Institutions", "Environmental Impact", "Lack of Soft Skills Emphasis", "Rural-Urban Disparities"};
        }

        move = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_rtl);

        Adv = findViewById(R.id.adv_list);
        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<>(this, R.layout.custom_list, adv);
        Adv.setAdapter(arr);

        Adv.startAnimation(move);

        Cha = findViewById(R.id.cha_list);
        ArrayAdapter<String> arr1;
        arr1 = new ArrayAdapter<>(this, R.layout.custom_list, cha);
        Cha.setAdapter(arr1);

        Cha.startAnimation(move);
    }
}