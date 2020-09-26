package com.example.elitepage1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DbHandler extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DB_Name = "ELITE";
    private static final String TABLE_NAME = "DRIVERS";

    //columns Names
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String TIME = "time";
    private static final String PHONE = "phone";
    private static final String VEHICLENO = "vehicleno";
    private static final String SUCCESSFULLDELIVERIES = "successfulldeliveries";

    public DbHandler(@Nullable Context context) {

        super(context, DB_Name, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String TABLE_CREATE_QUERY = "CREATE TABLE "+TABLE_NAME+" "+
                "("
                +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +NAME + " TEXT, "
                +TIME + " TEXT, "
                +PHONE + " TEXT,"
                +VEHICLENO + " TEXT, "
                +SUCCESSFULLDELIVERIES + " TEXT "+
                ");";

        /*
            CREATE TABLE DRIVERS(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT, time TEXT, phone TEXT, vehicleno TEXT, successfulldeliveries TEXT);

         */

        db.execSQL(TABLE_CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS DRIVERS";
        //DROP OLDER TABLE IF EXISTS
        db.execSQL(DROP_TABLE_QUERY);
        //create table again
        onCreate(db);
    }

    public boolean delivery1(DriverModel driverModel){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(NAME,driverModel.getName());
        contentValues.put(TIME,driverModel.getTime());
        contentValues.put(PHONE,driverModel.getPhone());
        contentValues.put(VEHICLENO,driverModel.getVehicleno());
        contentValues.put(SUCCESSFULLDELIVERIES,driverModel.getSuccessfulldeliveries());

        //save to table
        long rowInserted = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        if(rowInserted==-1)
            return false;
        else
            return true;
        // if(rowInserted != -1){
        // Context context = ;

        //Toast.makeText(context, "New row added, row id: " + rowInserted, Toast.LENGTH_SHORT).show();}
        //  else
        //Toast.makeText(myContext, "Something wrong", Toast.LENGTH_SHORT).show();
        //sqliteDatabase.close();

    }

    public int countdriver(){
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+ TABLE_NAME;

        Cursor cursor = db.rawQuery(query,null);
        return cursor.getCount();
    }

    public List<DriverModel>getAllDrivers(){
        List<DriverModel> driverModels = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME;

        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do {
                //create new drivermodel object
                DriverModel driverModel = new DriverModel();

                driverModel.setId(cursor.getInt(0));
                driverModel.setName(cursor.getString(1));
                driverModel.setTime(cursor.getString(2));
                driverModel.setPhone(cursor.getString(3));
                driverModel.setVehicleno(cursor.getString(4));
                driverModel.setSuccessfulldeliveries(cursor.getString(5));

                driverModels.add(driverModel);
            }while (cursor.moveToNext());
        }
        return driverModels;
    }
}
