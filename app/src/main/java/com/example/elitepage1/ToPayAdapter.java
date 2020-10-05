package com.example.elitepage1;

import android.content.Context;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class ToPayAdapter extends ArrayAdapter<ToPay> {

    private Context context;
    private int resource;
    List<ToPay> toPays;



    ToPayAdapter(Context context, int resource, List<ToPay> toPays){

        super(context,resource,toPays);
        this.context = context;
        this.resource = resource;
        this.toPays = toPays;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);


        TextView amount = row.findViewById(R.id.amount);
        TextView reference = row.findViewById(R.id.reference);
        TextView date = row.findViewById(R.id.date);
        TextView time = row.findViewById(R.id.time);
        ImageView imageView = row.findViewById(R.id.imageView14);


        //
        ToPay toPay = toPays.get(position);

        amount.setText(toPay.getAmount());
        reference.setText(toPay.getReference());
        date.setText(toPay.getDate());
        time.setText(toPay.getTime());
        imageView.setVisibility(row.VISIBLE);


        return row;
    }



}
