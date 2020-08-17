package com.example.elitepage1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

public class Display extends AppCompatActivity {


    TextView fv_heder;
    Button btn1_nav;
    Button buy_btn1;
    Button buy_btn2;
    Button buy_btn3;
    Button buy_btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        fv_heder=findViewById(R.id.fv_header);
        fv_heder.setText(R.string.fv_header);

        btn1_nav=findViewById(R.id.bin1_nav);
        btn1_nav.setText(R.string.btn1_nav);

        buy_btn1=findViewById(R.id.buy_btn1);
        buy_btn1.setText(R.string.buy_btn);
        buy_btn2=findViewById(R.id.buy_btn2);
        buy_btn2.setText(R.string.buy_btn);
        buy_btn3=findViewById(R.id.buy_btn3);
        buy_btn3.setText(R.string.buy_btn);
        buy_btn4=findViewById(R.id.buy_btn4);
        buy_btn4.setText(R.string.buy_btn);




    }
    @Override
    protected void onResume() {
        super.onResume();

        btn1_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Display.this,Item_Suggest.class);
                startActivity(intent);

            }
        });
        buy_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Display.this,Item_buy.class);
                startActivity(intent);

            }
        });
    }

}