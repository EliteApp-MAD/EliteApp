package com.example.elitepage1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Delivery1 extends AppCompatActivity {
    EditText name,time,phone,vehicleno,successfulldeliveries;
    Button buttonEdit;

    private DbHandler dbHandler;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery1);

        name = findViewById(R.id.editTextname);
        time = findViewById(R.id.editTexttime);
        phone = findViewById(R.id.editTextphone);
        vehicleno = findViewById(R.id.editTextvehicleno);
        successfulldeliveries = findViewById(R.id.editTextsuccessfulldeliveries);
        buttonEdit = findViewById(R.id.buttonEdit);
        context=this;
        dbHandler = new DbHandler(context);

        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = name.getText().toString();
                String userTime = time.getText().toString();
                String userPhone = phone.getText().toString();
                String userVehicleno = vehicleno.getText().toString();
                String userSuccessfulldeliveries = successfulldeliveries.getText().toString();

                DriverModel driverModel = new DriverModel(userName,userTime,userPhone,userVehicleno,userSuccessfulldeliveries);

                dbHandler.delivery1(driverModel);

                startActivity(new Intent(context,driverlist.class));

                boolean isInserted= dbHandler.delivery1(driverModel);
                if(isInserted == true)

                    Toast.makeText(Delivery1.this,"Data Inserted",Toast.LENGTH_SHORT).show();

                else
                    Toast.makeText(Delivery1.this,"Data not Inserted",Toast.LENGTH_SHORT).show();
            }




        });






    }


}