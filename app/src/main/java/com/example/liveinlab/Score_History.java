package com.example.liveinlab;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.model.TableColumnPxWidthModel;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;
import de.codecrafters.tableview.toolkit.TableDataRowBackgroundProviders;

public class Score_History extends AppCompatActivity {

    ArrayList<ArrayList<String>> God_List = new ArrayList<ArrayList<String>>();
    //ArrayList<String> The_List;
    ArrayList<ArrayList<String>> aObject = new ArrayList<ArrayList<String>>();
    ArrayList<String> math_list = new ArrayList<>();
    ArrayList<String> cs_list = new ArrayList<>();
    ArrayList<String> phy_list = new ArrayList<>();
    ArrayList<String> chem_list = new ArrayList<>();
    //String[][] stringArray;

    //ArrayList<String> smaller_list;
    TextView test_text;
    TextView empty_message;
    ImageButton info;
    Button clear_btn;
    String Msg = "Scores are sorted from earliest to latest";

    ArrayList<ArrayList> check_list = new ArrayList<ArrayList>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_history);

        DB2 dataBaseHelper = new DB2(Score_History.this);

        check_list=dataBaseHelper.getEverything();

        test_text = findViewById(R.id.head);

        info = findViewById(R.id.info_btn);

        empty_message = findViewById(R.id.empty_msg);

        clear_btn = findViewById(R.id.clear_btn);

        clear_btn.setBackgroundColor(Color.parseColor("#FF2C03"));

        info.setOnClickListener(v -> Toast.makeText(this, Msg, Toast.LENGTH_LONG).show());


        TableView table1 = findViewById(R.id.table_1);


        TableColumnPxWidthModel columnModel = new TableColumnPxWidthModel(4, 200);
        columnModel.setColumnWidth(0, 250);
        columnModel.setColumnWidth(1, 200);
        columnModel.setColumnWidth(2, 300);
        columnModel.setColumnWidth(3, 300);

        int rowColor = getResources().getColor(R.color.white);

        table1.setDataRowBackgroundProvider(TableDataRowBackgroundProviders.similarRowColor(rowColor));

        table1.setColumnModel(columnModel);

        String[] head={"MATHS", "CS", "PHYSICS", "CHEMISTRY"};

        table1.setHeaderAdapter(new SimpleTableHeaderAdapter(this, head));

        //DB2 dataBaseHelper = new DB2(Score_History.this);

        clear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calling a method to delete our course.
                Boolean conf = dataBaseHelper.delete_marks();
                if(conf==true) {
                    Toast.makeText(Score_History.this, "History Cleared Successfully", Toast.LENGTH_SHORT).show();
                    empty_message.setVisibility(View.VISIBLE);
                    table1.setVisibility(View.INVISIBLE);
                }
                else
                {
                    Toast.makeText(Score_History.this, "Error in deletion", Toast.LENGTH_SHORT).show();
                }
            }
        });


        God_List = Set_Table(dataBaseHelper);

        String[][] stringArray = new String[God_List.size()][];

        for (int i = 0; i < God_List.size(); i++) {
            stringArray[i] = God_List.get(i).toArray(new String[0]);
        }
        //test_text.setText((CharSequence) God_List);

        //table1.setEmptyDataIndicatorView(findViewById(R.id.empty_msg));

        table1.setDataAdapter(new SimpleTableDataAdapter(this, stringArray));

    }

    private ArrayList<ArrayList<String>> Set_Table(DB2 dataBaseHelper)
    {
        math_list=dataBaseHelper.getEverything().get(0);
        cs_list=dataBaseHelper.getEverything().get(1);
        phy_list=dataBaseHelper.getEverything().get(2);
        chem_list=dataBaseHelper.getEverything().get(3);
        aObject.add(new ArrayList<String>());

        for(int i=0; i<math_list.size();i++)
        {
            aObject.add(new ArrayList<String>());
            aObject.get(i).add(math_list.get(i));
            aObject.get(i).add(cs_list.get(i));
            aObject.get(i).add(phy_list.get(i));
            aObject.get(i).add(chem_list.get(i));
            /*smaller_list.add(math_list.get(i));
            smaller_list.add(cs_list.get(i));
            smaller_list.add(phy_list.get(i));
            smaller_list.add(chem_list.get(i));
            aObject.add(smaller_list);
            smaller_list.clear();*/
        }
        return aObject;
    }
}