package com.example.elitepage1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Item_Suggest extends AppCompatActivity {

    TextView suggest_h;
    private  DbHandlerItemList dbHandler;
    Button btn_sub;
    EditText suggest;
    EditText cusid;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item__suggest);

        suggest_h=findViewById(R.id.Suggest_header);
        suggest_h.setText(R.string.suggest_h);

        btn_sub=findViewById(R.id.btn_sub);
        btn_sub.setText(R.string.btn_sub);

    suggest=findViewById(R.id.sugesstItem);
    cusid=findViewById(R.id.customerID);
        context=this;
        dbHandler = new DbHandlerItemList(context);

        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = suggest.getText().toString();
                String id =cusid.getText().toString();
                Add_Item_Suggest add_item = new Add_Item_Suggest(item,id);
                boolean isInserted= dbHandler.sugesst(add_item);
                if(isInserted == true)

                    Toast.makeText(Item_Suggest.this,"Data Inserted",Toast.LENGTH_SHORT).show();

                else
                    Toast.makeText(Item_Suggest.this,"Data not Inserted",Toast.LENGTH_SHORT).show();
            }
        });

    }


    protected void onResume() {
        super.onResume();


        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // Intent intent = new Intent(FirstActivity.this,SecondActivity.class);

                //intent.putExtra("Number1",input1);
                //intent.putExtra("Number2",input2);
                //startActivity(intent);

                Context context = getApplicationContext(); //The context to use. Usually your Application or Activity object
                CharSequence message = "Successfull Request"; //Display string
                int duration = Toast.LENGTH_SHORT; //How long the toast message will lasts
                Toast toast = Toast.makeText(context, message, duration);
                toast.show();
               // toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);
            }
        });
    }

}