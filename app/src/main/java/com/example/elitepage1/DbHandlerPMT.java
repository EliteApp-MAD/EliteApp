package com.example.elitepage1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.Nullable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;


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


    public DbHandlerPMT(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String TABLE_CREATE_QUERY = "CREATE TABLE " + TABLE_NAME + " " +
                "("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + AMOUNT + " TEXT,"
                + REFERENCE + " TEXT,"
                + DATE + " TEXT,"
                + TIME + " TEXT" +
                ");";
        /*
            CREATE TABLE payment (id INTEGER PRIMARY KEY AUTOINCREMENT, amount TEXT, reference TEXT,
            date TEXT,time TEXT); */

        sqLiteDatabase.execSQL(TABLE_CREATE_QUERY);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;
        // Drop older table if existed
        sqLiteDatabase.execSQL(DROP_TABLE_QUERY);
        // Create tables again
        onCreate(sqLiteDatabase);

    }


    // Add a single payment
    public void addPay(ToPay toPay) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(AMOUNT, toPay.getAmount());
        contentValues.put(REFERENCE, toPay.getReference());
        contentValues.put(DATE, toPay.getDate());
        contentValues.put(TIME, toPay.getTime());


        //save to table
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        // close database
        sqLiteDatabase.close();
    }


    // Count all the payments
    public int countPay() {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = db.rawQuery(query, null);
        return cursor.getCount();
    }


    // Get all Payments into a list
    public List<ToPay> getAllToPays() {

        List<ToPay> toPays = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                // Create new toPays object
                ToPay toPay = new ToPay();
                //
                toPay.setId(cursor.getInt(0));
                toPay.setAmount(cursor.getString(1));
                toPay.setReference(cursor.getString(2));
                toPay.setDate(cursor.getString(3));
                toPay.setTime(cursor.getString(4));

                //toPays
                toPays.add(toPay);
            } while (cursor.moveToNext());
        }
        return toPays;
    }


    // Delete item
    public void deleteToPay(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME, "id =?", new String[]{String.valueOf(id)});
        db.close();
    }



    // Update a single Payments
    public int updateSingleToDo(ToPay toPay) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(AMOUNT, toPay.getAmount());
        contentValues.put(REFERENCE, toPay.getReference());
        contentValues.put(DATE, toPay.getDate());
        contentValues.put(TIME, toPay.getTime());
        int status = db.update(TABLE_NAME, contentValues, ID + " =?",
                new String[]{String.valueOf(toPay.getId())});

        db.close();
        return status;
    }







     /* // Get a single todo
    public ToDo getSingleToDo(int id){
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.query(TABLE_NAME,new String[]{ID,TITLE,DESCRIPTION,STARTED, FINISHED},
                ID + "= ?",new String[]{String.valueOf(id)}
                ,null,null,null);

        ToDo toDo;
        if(cursor != null){
            cursor.moveToFirst();
            toDo = new ToDo(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getLong(3),
                    cursor.getLong(4)
            );
            return toDo;
        }
        return null;
    } */
}
