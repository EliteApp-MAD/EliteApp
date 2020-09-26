package com.example.elitepage1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class SQLiteHelperItem extends SQLiteOpenHelper {

    private static final String TABLE_NAME ="CartList";

    private static final String ID ="ID";
    private static final String Name="name";
    private static final String Price="price";
    private static final String Quantity ="quantity";
    private static final String image ="image";


    public SQLiteHelperItem(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public void insertData(String name, String price, String quantity , byte[] image){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO CartList VALUES (NULL, ?, ?, ?, ?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, name);
        statement.bindString(2, price);
        statement.bindString(3, quantity );
        statement.bindBlob(4, image);

        statement.executeInsert();
    }

    public void updateData(String name, String price, byte[] image, int id) {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "UPDATE FOOD SET name = ?, price = ?, image = ? WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);

        statement.bindString(1, name);
        statement.bindString(2, price);
        statement.bindBlob(3, image);
        statement.bindDouble(4, (double)id);

        statement.execute();
        database.close();
    }
    public void selectData( int id) {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "SELECT * FROM FOOD  WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);




        statement.execute();
        database.close();
    }


    public  void deleteData(int id) {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "DELETE FROM FOOD WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1, (double)id);

        statement.execute();
        database.close();
    }

    public Cursor getData1(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }
   /* public  ItemList getData(int id){
        SQLiteDatabase database = getWritableDatabase();
        //String sql
        database.query(TABLE_NAME,new String[]{ID,Name,,price,category});
        //return database.rawQuery(sql, null);
    }*/

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
