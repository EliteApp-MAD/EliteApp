package com.example.elitepage1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


public class Payment extends AppCompatActivity {


    private EditText amount, reference, date, time;
    private Button add;
  //  private DbHandler dbHandler;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        amount = findViewById(R.id.editTextAmount);
        reference = findViewById(R.id.editTextReference);
        date = findViewById(R.id.editTextDate);
        time = findViewById(R.id.editTextTime);

        add = findViewById(R.id.buttonAdd);
        context = this;

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(context,ViewPmt.class));
            }
        });
    }
}