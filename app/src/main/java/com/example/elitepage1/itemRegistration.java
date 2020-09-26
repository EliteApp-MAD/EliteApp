package com.example.elitepage1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class itemRegistration extends AppCompatActivity {

    EditText name,price,category;
    Button choose,Submit;
    ImageView imageView;
    private Context context;
    final int REQUEST_CODE_GALLERY = 999;


    public static DbHandlerItemReg dbHandlerItemReg;

    private void init() {
        name=(EditText)findViewById(R.id.edar1);
        price=(EditText)findViewById(R.id.edar2);
        //category=(EditText)findViewById(R.id.edar3);
        choose=(Button)findViewById(R.id.btnImg);
        Submit=(Button)findViewById(R.id.btn_reg);
        imageView = (ImageView) findViewById(R.id.imageView);
    }
    @Override
    /*protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_registration);

        init();
       //dbHandlerItemReg = new DbHandlerItemReg(context);
        dbHandlerItemReg = new DbHandlerItemReg(this, "Elite_arr.sqlite", null, 1);

        dbHandlerItemReg.queryData("CREATE TABLE IF NOT EXISTS ITEM (Id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, price VARCHAR, image BLOB)");
//category VARCHAR
        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(
                        itemRegistration.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY);
            }
        });
    }*/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        dbHandlerItemReg = new DbHandlerItemReg(this, "Foodd.sqlite", null, 1);

        dbHandlerItemReg.queryData("CREATE TABLE IF NOT EXISTS FOOD(Id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, price VARCHAR, image BLOB)");

        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(
                        itemRegistration.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY
                );
            }
        });

    }
        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

            if(requestCode == REQUEST_CODE_GALLERY){
                if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    startActivityForResult(intent, REQUEST_CODE_GALLERY);
                }
                else {
                    Toast.makeText(getApplicationContext(), "You don't have permission to access file location!", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {

            if(requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data != null){
                Uri uri = data.getData();

                try {
                    InputStream inputStream = getContentResolver().openInputStream(uri);

                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    imageView.setImageBitmap(bitmap);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

            super.onActivityResult(requestCode, resultCode, data);
        }


    }