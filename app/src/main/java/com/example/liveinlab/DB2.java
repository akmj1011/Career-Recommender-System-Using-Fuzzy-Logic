package com.example.liveinlab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DB2 extends SQLiteOpenHelper {

    public static final String math_marks = "math";
    public static final String cs_marks = "cs";
    public static final String phy_marks = "phy";
    public static final String chem_marks = "chem";
    public static final String TABLE_NAME = "Subjectmarks";
    public DB2(Context context) {
        super(context, "subjectmarks.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Subjectmarks( math TEXT, cs TEXT, phy TEXT, chem TEXT)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop Table if exists Subjectmarks");
    }

    public Boolean insertmarks(String math, String cs, String phy, String chem) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("math", math);
        contentValues.put("cs", cs);
        contentValues.put("phy", phy);
        contentValues.put("chem", chem);
        long result = DB.insert("Subjectmarks", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }

    public ArrayList<ArrayList> getEverything() {
        ArrayList<ArrayList> returnList = new ArrayList<>();
        ArrayList<String> Math_list = new ArrayList<String>();
        ArrayList<String> CS_list = new ArrayList<String>();
        ArrayList<String> Phy_list = new ArrayList<String>();
        ArrayList<String> Chem_list = new ArrayList<String>();

        String QueryString = "SELECT * FROM Subjectmarks";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(QueryString, null);
        cursor.moveToFirst();
        while(cursor.isAfterLast()==false)
        {
            Math_list.add(cursor.getString(cursor.getColumnIndex(math_marks)));
            CS_list.add(cursor.getString(cursor.getColumnIndex(cs_marks)));
            Phy_list.add(cursor.getString(cursor.getColumnIndex(phy_marks)));
            Chem_list.add(cursor.getString(cursor.getColumnIndex(chem_marks)));
            cursor.moveToNext();
        }
        returnList.add(Math_list);
        returnList.add(CS_list);
        returnList.add(Phy_list);
        returnList.add(Chem_list);
        cursor.close();
        db.close();
        return (ArrayList<ArrayList>) returnList;
    }

    public Boolean delete_marks() {

        // on below line we are creating
        // a variable to write our database.
        SQLiteDatabase db = this.getWritableDatabase();
        // on below line we are calling a method to delete our
        // course and we are comparing it with our course name.
        long result = db.delete(TABLE_NAME, null, null);
        if (result == -1)
            return false;
        else
            return true;
    }

}