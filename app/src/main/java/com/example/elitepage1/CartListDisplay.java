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


public class CartListDisplay extends AppCompatActivity {
    GridView gridView;
    GridLayout gridLayout;
    LinearLayout linearLayout;
    ArrayList<CartList> list;
    CartListAdapter adapter = null;
    //  Button btnbuy;
    Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_list_activity);

        //linearLayout = findViewById(R.id.gridView1);
        //   btnbuy = findViewById(R.id.buy_btn2);
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

            //list.add(new FOOD(name, price, image, id));
            list.add(new CartList(id, name, price, quantity, image));
        }
        adapter.notifyDataSetChanged();

  /*      gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // final ItemList itemList
                // -
                final CartList cartList =list.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Test");
                builder.setMessage("dddd");

                builder.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
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
        }); */


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
