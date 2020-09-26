package com.example.elitepage1;


import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
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



public class ItemListDis extends AppCompatActivity {

    GridView gridView;
    GridLayout gridLayout;
    LinearLayout linearLayout;
    ArrayList<ItemList> list;
    ItemListAdapter adapter = null;
    Button btnbuy;
    Context context;
    Button btnsugne;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_list_activity);
        btnsugne=findViewById(R.id.btnsugnew);
        btnsugne.setText(R.string.suggest_h);
        //linearLayout = findViewById(R.id.gridView1);
        btnbuy = findViewById(R.id.buy_btn2);
        gridView = findViewById(R.id.gridView);
        list = new ArrayList<>();
        adapter = new ItemListAdapter(this, R.layout.list_view_item, list);
        gridView.setAdapter(adapter);
        context = this;

        final Cursor cursor = newReg.sqLiteHelper.getData("SELECT * FROM FOOD");
        list.clear();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String price = cursor.getString(2);
            String category = cursor.getString(3);
            byte[] image = cursor.getBlob(4);

            //list.add(new FOOD(name, price, image, id));
            list.add(new ItemList(id, name, price, category, image));
        }
        adapter.notifyDataSetChanged();



        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
               // final ItemList itemList
                // -
                final ItemList itemList =list.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Confirmation");
                builder.setMessage("Confirm the Item");

                builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                       //startActivity(new Intent(context,Item_buy.class));
                        Intent intent =new Intent(context,Item_buy.class);

                        intent.putExtra("id",String.valueOf(itemList.getId()));
                        intent.putExtra("name",String.valueOf(itemList.getName()));
                        intent.putExtra("price",String.valueOf(itemList.getPrice()));
                        intent.putExtra("image",String.valueOf(itemList.getImage()));
                        //imageViewToByte(imageView)
                       // byte[] image = cursor.getBlob(4);
                      //  Bitmap bmp= BitmapFactory.decodeByteArray(image, 0 , image.length);
                       // intent.putExtra("imageData", bmp);
                       // imageView.setImageBitmap(bmp);
                        //Toast.makeText(this,"Done", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        //Toast.makeText(getApplicationContext(), "Update", Toast.LENGTH_SHORT).show();
                        //showDialogUpdate(ItemListDis.this);
                    }
                });
                builder.show();
            }
        });
        btnsugne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ItemListDis.this,Item_Suggest.class);
                startActivity(intent);

            }
        });

    }

    ImageView imageViewFood;

   /*private void showDialogUpdate(Activity activity) {

        final Dialog dialog = new Dialog(activity);
        dialog.setContentView(R.layout.activity_item_buy);
        dialog.setTitle("Buy");

       // imageViewFood = (ImageView) dialog.findViewById(R.id.imageViewItem);
      //  final EditText edtName = (EditText) dialog.findViewById(R.id.edtName);
      //  final EditText edtPrice = (EditText) dialog.findViewById(R.id.edtPrice);
       // Button btnUpdate = (Button) dialog.findViewById(R.id.btnUpdate);

        // set width for dialog
        int width = (int) (activity.getResources().getDisplayMetrics().widthPixels * 0.95);
        // set height for dialog
        int height = (int) (activity.getResources().getDisplayMetrics().heightPixels * 0.7);
        dialog.getWindow().setLayout(width, height);
        dialog.show();

        imageViewFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // request photo library
                ActivityCompat.requestPermissions(
                        ItemListDis.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        888
                );
            }
        });*/





}
