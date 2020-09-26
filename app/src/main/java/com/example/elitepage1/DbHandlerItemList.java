package com.example.elitepage1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DbHandlerItemList extends SQLiteOpenHelper {

    private static final int VERSION =1;
    private static final String DB_NAME ="Elite_ar";
    private static final String TABLE_NAME ="SuggestedItem";

    private static final String suggestedID ="SuggestedID";
    private static final String ItemName="itemName";
    private static final String customerID="CustomerID";

    public DbHandlerItemList(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION );
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String TABLE_CREATE_QUERY = "CREATE TABLE "+TABLE_NAME+" "+
                "("
                +suggestedID+" INTEGER PRIMARY KEY  AUTOINCREMENT, "
                +ItemName + " TEXT, "
                +customerID + " TEXT "+
                ");";

        /*CREATE TABLE SuggestedItem(SuggestedID INTEGER PRIMARY KEY AUTOINCREMENT, itemName TEXT,CustomerID INTEGER);
        */
        db.execSQL(TABLE_CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS SuggestedItem";
        //drop table if existed
        db.execSQL(DROP_TABLE_QUERY);
        //create table again
        onCreate(db);
    }
    public boolean sugesst(Add_Item_Suggest add_item){
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


    }
}
