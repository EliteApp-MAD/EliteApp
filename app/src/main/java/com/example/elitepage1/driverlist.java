package com.example.elitepage1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class driverlist extends AppCompatActivity {

    private ListView listView;
    private List<DriverModel> driverModels;
    private DbHandler dbHandler;
    private Context context;
    private Button ADD;
    private TextView count;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driverlist);
        context = this;
        dbHandler = new DbHandler(this);
        dbHandler = new DbHandler(context);
        listView = findViewById(R.id.driverlist);
        ADD = findViewById(R.id.ADD);
        count = findViewById(R.id.count);

        int countdriver = dbHandler.countdriver();
        count.setText(+countdriver+"Available Drivers");

        driverModels = new ArrayList<>();
        driverModels = dbHandler.getAllDrivers();

        DriverAdapter adapter = new DriverAdapter(context,R.layout.activity_driver,driverModels);
        listView.setAdapter(adapter);

        ADD = findViewById(R.id.ADD);

        ADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),deliverydetails.class);
                startActivity(i);
            }
        });
    }
}