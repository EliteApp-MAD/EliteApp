package com.example.elitepage1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class Item_buy extends AppCompatActivity {
    ArrayList<ItemList> list1;
    private Context context;

    final int REQUEST_CODE_GALLERY = 999;
    public static SQLiteHelperItem sqLiteHelperItem;
    //public static SQLiteHelper sqLiteHelper1;
    TextView buy_header;
    EditText buy_header4aa;
    TextView buy_header1;
    TextView buy_header2;
    TextView buy_header3;
    TextView buy_header4;
    TextView buy_rate;
    ImageView imageViewItem;


    Button rbt1;
    Button rbt2;
    Button badd;
    Button btn_ra;
    Button btn_save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        list1 = new ArrayList<>();
       context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_buy);
        btn_save=findViewById(R.id.buy_savelist);
        btn_save.setText("Buy");
        buy_header = findViewById(R.id.buy_headera);
        //buy_header.setText(Name);
        buy_header4aa=findViewById(R.id.buy_header4a);
        buy_header1 = findViewById(R.id.buy_header1a);
        //.setText(R.string.buy_header1);
        imageViewItem=findViewById(R.id.imageViewItem);
        buy_header2 = findViewById(R.id.buy_header2a);
        buy_header2.setText(R.string.buy_header2);

        buy_header3 = findViewById(R.id.buy_header3a);
        buy_header3.setText(R.string.buy_header3);

        buy_header4 = findViewById(R.id.buy_header4a);
        buy_header4.setText(R.string.buy_header4);

        buy_rate = findViewById(R.id.buy_ratea);
        buy_rate.setText(R.string.get_rate);

        rbt1 = findViewById(R.id.r_button1a);
        rbt1.setText(R.string.r_btn1);

        rbt2 = findViewById(R.id.r_button2a);
        rbt2.setText(R.string.r_btn2);

        badd = findViewById(R.id.buy_adda);
        badd.setText("View Cart");

        btn_ra = findViewById(R.id.btn_ra);
        btn_ra.setText(R.string.btn_ra);



        final String id = getIntent().getStringExtra("id");
        final String Name = getIntent().getStringExtra("name");
        buy_header.setText(Name);

        final String Price = getIntent().getStringExtra("price");
        buy_header1.setText(Price);

       // final String Image = getIntent().getStringExtra("image");
        //imageViewItem.setText(Image);



        System.out.println(id);
        Integer idx = Integer.parseInt(id);
        Cursor cursor = newReg.sqLiteHelper.getData("SELECT * FROM FOOD WHERE Id='"+id+"'");
        //Cursor c = db.rawQuery("SELECT * FROM tbl1 WHERE TRIM(name) = '"+name.trim()+"'", null);
        list1.clear();
        while (cursor.moveToNext()) {
            int id1 = cursor.getInt(0);
            String name = cursor.getString(1);
            String price = cursor.getString(2);
            String category = cursor.getString(3);
            byte[] image = cursor.getBlob(4);
            //byte[] image = c.getBlob(0);
            Bitmap bmp= BitmapFactory.decodeByteArray(image, 0 , image.length);
            imageViewItem.setImageBitmap(bmp);
            //Toast.makeText(this,"Done", Toast.LENGTH_SHORT).show();
            //list.add(new FOOD(name, price, image, id));
            list1.add(new ItemList(id1, name, price, category, image));

            //final ItemList itemList;
            //buy_header.setText(itemList.getName());
        }

       // byte[] image = cursor.getBlob(4);
        sqLiteHelperItem = new SQLiteHelperItem(this, "Buying_list.sqlite", null, 1);
        sqLiteHelperItem .queryData("CREATE TABLE IF NOT EXISTS CartList(Id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, price VARCHAR, quantity VARCHAR, image BLOB)");

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    sqLiteHelperItem.insertData(
                            buy_header.getText().toString().trim(),
                            buy_header1.getText().toString().trim(),
                            buy_header4aa.getText().toString().trim(),
                            imageViewToByte( imageViewItem)
                    );
                    Toast.makeText(getApplicationContext(), "Added successfully!", Toast.LENGTH_SHORT).show();
                    //name.setText("");
                    //price.setText("");
                   // category.setText("");
                   // imageView.setImageResource(R.mipmap.ic_launcher);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        badd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Item_buy.this,ShoppingCartFinal.class);
                startActivity(intent);

            }
        });

        badd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Item_buy.this,CartListDisplay.class);
                startActivity(intent);

            }
        });


    }

   /* @Override
    protected void onResume() {
        super.onResume();

        badd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Item_buy.this,CartListDisplay.class);
                startActivity(intent);

            }
        });
    }*/
    public static byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

}