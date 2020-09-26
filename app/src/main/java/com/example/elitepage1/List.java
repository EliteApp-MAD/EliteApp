package com.example.elitepage1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class List extends AppCompatActivity {

    TextView search_header;
    Button btn1_bakery;
    Button btn2_fv;
    Button btn3_g;
    Button btn4_hc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        search_header = findViewById(R.id.Search_header);
        search_header.setText("SEARCH");

        btn1_bakery=findViewById(R.id.btn1_b);
        btn1_bakery.setText("Bakery                                            SEA ALL");

        btn2_fv=findViewById(R.id.btn2_fv);
        btn2_fv.setText("Fruit & Vegetable                                      SEA ALL");

        btn3_g=findViewById(R.id.btn3_g);
        btn3_g.setText("Grocery                                                  SEE ALL");

        btn4_hc=findViewById(R.id.btn4_hc);
        btn4_hc.setText("Home care                                               SEA ALL");
    }

    @Override
    protected void onResume() {
        super.onResume();

        btn2_fv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(List.this,Display.class);
                startActivity(intent);

            }
        });
    }
}