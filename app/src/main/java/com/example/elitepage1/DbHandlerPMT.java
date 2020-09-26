package com.example.elitepage1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHandlerPMT extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DB_NAME = "payment";
    private static final String TABLE_NAME = "payment";


    // Column names
    private static final String ID = "id";
    private static final String AMOUNT = "amount";
    private static final String REFERENCE = "reference";
    private static final String DATE = "date";
    private static final String TIME = "time";





    public DbHandlerPMT(@Nullable Context context ) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String TABLE_CREATE_QUERY = "CREATE TABLE "+TABLE_NAME+" " +
                "("
                +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +AMOUNT + " TEXT,"
                +REFERENCE + " TEXT,"
                +DATE+ " TEXT,"
                +TIME+" TEXT" +
                ");";




        /*
            CREATE TABLE payment (id INTEGER PRIMARY KEY AUTOINCREMENT, amount TEXT, reference TEXT,
            date TEXT,time TEXT); */

        sqLiteDatabase.execSQL(TABLE_CREATE_QUERY);



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS "+ TABLE_NAME;
        // Drop older table if existed
        sqLiteDatabase.execSQL(DROP_TABLE_QUERY);
        // Create tables again
        onCreate(sqLiteDatabase);

    }
}
