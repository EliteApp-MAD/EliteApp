package com.example.elitepage1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class EditPmt extends AppCompatActivity {


    private EditText amount, reference, date, time;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_pmt);


        amount = findViewById(R.id.editTextAmountUp);
        reference = findViewById(R.id.editTextReferenceUp);
        date = findViewById(R.id.editTextDateUp);
        time = findViewById(R.id.editTextTimeUp);

        add = findViewById(R.id.buttonAddUp);


    }
}