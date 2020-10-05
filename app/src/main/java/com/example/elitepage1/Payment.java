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
import android.widget.Toast;


public class Payment extends AppCompatActivity {


    private EditText amount, reference, date, time;
    private Button add;
  private DbHandlerPMT dbHandler;
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
        dbHandler = new DbHandlerPMT(context);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userAmount = amount.getText().toString();
                String userReference = reference.getText().toString();
                String userDate = date.getText().toString();
                String userTime = time.getText().toString();


                ToPay toPay = new ToPay(userAmount,userReference,userDate,userTime);
                dbHandler.addPay(toPay);

                startActivity(new Intent(context,ViewPmt.class));

                Toast.makeText(getApplicationContext(),"Payment details inserted",Toast.LENGTH_SHORT).show();
            }



        });
    }
}