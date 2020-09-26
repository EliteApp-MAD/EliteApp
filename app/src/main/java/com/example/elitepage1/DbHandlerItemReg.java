package com.example.elitepage1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

/*public class DbHandlerItemReg extends SQLiteOpenHelper {

    private static final int VERSION =1;
    private static final String DB_NAME ="Elite_ar";
    private static final String TABLE_NAME ="Item";

    private static final String suggestedID ="SuggestedID";
    private static final String ItemName="itemName";
    private static final String customerID="CustomerID";

   //public DbHandlerItemReg(@Nullable Context context) {
     //  super(context, DB_NAME, null, VERSION );
   // }
    public DbHandlerItemReg(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


   /* @Override
    public void onCreate(SQLiteDatabase db) {
        String TABLE_CREATE_QUERY = "CREATE TABLE "+TABLE_NAME+" "+
                "("
                +suggestedID+" INTEGER PRIMARY KEY  AUTOINCREMENT, "
                +ItemName + " TEXT, "
                +customerID + " TEXT "+
                ");";

        /*CREATE TABLE SuggestedItem(SuggestedID INTEGER PRIMARY KEY AUTOINCREMENT, itemName TEXT,CustomerID INTEGER);
        */
       // db.execSQL(TABLE_CREATE_QUERY);
   // }

 /*   @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public void insertData(String name, String price,String category, byte[] image){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO Item VALUES (NULL, ?, ?, ?, ?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, name);
        statement.bindString(2, price);
        statement.bindString(3, category);
        statement.bindBlob(4, image);

        statement.executeInsert();
    }


   // @Override
  /*  public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS SuggestedItem";
        //drop table if existed
        db.execSQL(DROP_TABLE_QUERY);
        //create table again
        onCreate(db);
    }
    public boolean addItem(Add_Item_Suggest add_item){
            SQLiteDatabase sqliteDatabase = getWritableDatabase();
            ContentValues contentValues = new  ContentValues();

            contentValues.put(ItemName,add_item.getItemName());
            contentValues.put(customerID,add_item.getCustomerID());

            //save to table

        long rowInserted= sqliteDatabase.insert(TABLE_NAME,null,contentValues);
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


    }*/
//}
public class DbHandlerItemReg extends SQLiteOpenHelper {

    public DbHandlerItemReg(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void queryData(String sql) {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public void insertData(String name, String price, byte[] image) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO ITEM VALUES (NULL, ?, ?, ?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, name);
        statement.bindString(2, price);
        statement.bindBlob(3, image);

        statement.executeInsert();
    }

    public void updateData(String name, String price, byte[] image, int id) {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "UPDATE FOOD SET name = ?, price = ?, image = ? WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);

        statement.bindString(1, name);
        statement.bindString(2, price);
        statement.bindBlob(3, image);
        statement.bindDouble(4, (double) id);

        statement.execute();
        database.close();
    }

    public void deleteData(int id) {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "DELETE FROM ITEM WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1, (double) id);

        statement.execute();
        database.close();
    }

    public Cursor getData(String sql) {
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}