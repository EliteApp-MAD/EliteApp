package com.example.elitepage1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Item_Suggest extends AppCompatActivity {

    TextView suggest_h;
    Button btn_sub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item__suggest);

        suggest_h=findViewById(R.id.Suggest_header);
        suggest_h.setText(R.string.suggest_h);

        btn_sub=findViewById(R.id.btn_sub);
        btn_sub.setText(R.string.btn_sub);
    }
}