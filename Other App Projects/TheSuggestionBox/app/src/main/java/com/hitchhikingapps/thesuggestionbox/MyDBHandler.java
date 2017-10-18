package com.hitchhikingapps.thesuggestionbox;

/**
 * Created by Duncan on 3/29/2016.
 */


import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class MyDBHandler extends SQLiteOpenHelper{

    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "table.db";
    private static final String TABLE_USER = "User";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_COMPLAINT = "complaint";
    public static final String COLUMN_SUGGESTION ="suggestion";


    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_USER + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_COMPLAINT
                + " TEXT," + COLUMN_SUGGESTION + " TEXT " + ")";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }

    public void addComplaint(Complaint complaint){
        ContentValues values = new ContentValues();
        values.put(COLUMN_COMPLAINT,complaint.get_complaint());
        SQLiteDatabase db= getWritableDatabase();
        db.insert(TABLE_USER, null, values);
        db.close();
    }
    public void addSuggestion(Suggestion suggestion){
        ContentValues values = new ContentValues();
        values.put(COLUMN_SUGGESTION,suggestion.get_suggestion());
        SQLiteDatabase db= getWritableDatabase();
        db.insert(TABLE_USER, null, values);
        db.close();
    }
    public String[] databaseToString(){

        String cbString = "";
        String sbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_USER + " WHERE 1";

        Cursor c = db.rawQuery(query,null);
        c.moveToFirst();

        while (!c.isAfterLast()){
            if (c.getString(c.getColumnIndex("complaint")) != null){
                cbString += c.getString(c.getColumnIndex("complaint"));
                cbString += "\n";
            }

            if (c.getString(c.getColumnIndex("suggestion")) != null){
                sbString += c.getString(c.getColumnIndex("suggestion"));
                sbString += "\n";
            }

            c.moveToNext();
        }

        db.close();
        String[] arr = new String[2];
        arr[0] = cbString;
        arr[1] = sbString;
        return arr;

    }



}
