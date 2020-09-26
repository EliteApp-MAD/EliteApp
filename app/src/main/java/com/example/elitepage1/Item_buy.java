package com.example.elitepage1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Item_buy extends AppCompatActivity {

    TextView buy_header;

    TextView buy_header1;
    TextView buy_header2;
    TextView buy_header3;
    TextView buy_header4;
    TextView buy_rate;


    Button rbt1;
    Button rbt2;
    Button badd;
    Button btn_ra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_buy);

        buy_header=findViewById(R.id.buy_headera);
        buy_header.setText(R.string.buy_header);

        buy_header1=findViewById(R.id.buy_header1a);
        buy_header1.setText(R.string.buy_header1);

        buy_header2=findViewById(R.id.buy_header2a);
        buy_header2.setText(R.string.buy_header2);

        buy_header3=findViewById(R.id.buy_header3a);
        buy_header3.setText(R.string.buy_header3);

        buy_header4=findViewById(R.id.buy_header4a);
        buy_header4.setText(R.string.buy_header4);

        buy_rate=findViewById(R.id.buy_ratea);
        buy_rate.setText(R.string.get_rate);

        rbt1=findViewById(R.id.r_button1a);
        rbt1.setText(R.string.r_btn1);

        rbt2=findViewById(R.id.r_button2a);
        rbt2.setText(R.string.r_btn2);

        badd=findViewById(R.id.buy_adda);
        badd.setText(R.string.btn_add);

        btn_ra=findViewById(R.id.btn_ra);
        btn_ra.setText(R.string.btn_ra);
    }

}