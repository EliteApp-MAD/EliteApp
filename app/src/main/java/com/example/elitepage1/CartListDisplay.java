package com.example.elitepage1;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.ArrayList;


public class CartListDisplay extends AppCompatActivity {
    GridView gridView;
    GridLayout gridLayout;
    LinearLayout linearLayout;
    ArrayList<CartList> list;
    CartListAdapter adapter = null;
    Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_list_activity);

        gridView = findViewById(R.id.gridView1);
        list = new ArrayList<>();
        adapter = new CartListAdapter(this, R.layout.shopping_cart, list);
        gridView.setAdapter(adapter);
        context = this;

        final Cursor cursor = Item_buy.sqLiteHelperItem.getData1("SELECT * FROM CartList");
        list.clear();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String price = cursor.getString(2);
            String quantity = cursor.getString(3);
            byte[] image = cursor.getBlob(4);

            list.add(new CartList(id, name, price, quantity, image));
        }
        adapter.notifyDataSetChanged();

      gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                CharSequence[] items = {"Update", "Delete"};
                AlertDialog.Builder dialog = new AlertDialog.Builder(CartListDisplay.this);

                dialog.setTitle("Choose an action");
                dialog.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int item) {
                        if(item == 0){
                            //update
                            Toast.makeText(getApplicationContext(), "Update...", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            //delete
                            Toast.makeText(getApplicationContext(), "Delete...", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dialog.show();
                return true;
            }
        });
    }

    ImageView imageViewFood;

}
