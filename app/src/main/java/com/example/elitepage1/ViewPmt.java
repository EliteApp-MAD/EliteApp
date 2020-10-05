package com.example.elitepage1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;
public class ViewPmt extends AppCompatActivity {

    private Button add;
    private ListView listView;
    private TextView count;
    Context context;
   private DbHandlerPMT  dbHandler;
   private List<ToPay> toPays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pmt);

        context = this;
        dbHandler = new DbHandlerPMT(context);

        add = findViewById(R.id.add);
        listView = findViewById(R.id.todolist);
        count = findViewById(R.id.todocount);

        toPays = new ArrayList<>();
        toPays = dbHandler.getAllToPays();


        //Call adapter
        ToPayAdapter adapter = new ToPayAdapter(context,R.layout.single_payment,toPays);

       //set adapter to listview
        listView.setAdapter(adapter);

        //calculation
        //get payment counts from the table
        int countPay = dbHandler.countPay();
        count.setText("You have "+countPay+" Payments");


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,Payment.class));
            }
        });




        // Alert Dialog Box
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final ToPay toPay = toPays.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(toPay.getAmount());
                builder.setMessage(toPay.getReference());
                builder.setTitle(toPay.getDate());
                builder.setMessage(toPay.getTime());


                builder.setPositiveButton("Finished", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       // toPay.setFinished(System.currentTimeMillis());
                        //dbHandler.updateSingleToDo(todo);
                        startActivity(new Intent(context,ViewPmt.class));
                    }
                });


                //delete
                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dbHandler.deleteToPay(toPay.getId());
                        startActivity(new Intent(context,ViewPmt.class));
                    }
                });

                //update
                builder.setNeutralButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context,EditPmt.class);
                       intent.putExtra("id",String.valueOf(toPay.getId()));
                        startActivity(intent);
                    }
                });
                builder.show();
            }
        });






    }
}