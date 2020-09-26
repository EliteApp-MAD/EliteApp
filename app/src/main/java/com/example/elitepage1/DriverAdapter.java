package com.example.elitepage1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class DriverAdapter extends ArrayAdapter<DriverModel> {

    private Context context;
    private int resource;
    List<DriverModel> driverModels;
    DriverAdapter(Context context, int resource, List<DriverModel> driverModels){
        super(context,resource,driverModels);
        this.context = context;
        this.resource = resource;
        this.driverModels = driverModels;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        @SuppressLint("ViewHolder") View row = inflater.inflate(resource,parent,false);

        TextView name = row.findViewById(R.id.editTextname);
        TextView time = row.findViewById(R.id.editTexttime);
        TextView phone = row.findViewById(R.id.editTextphone);
        TextView vehicleno = row.findViewById(R.id.editTextvehicleno);
        TextView successfulldeliveries = row.findViewById(R.id.editTextsuccessfulldeliveries);
        ImageButton select = row.findViewById(R.id.buttonSELECT);

        DriverModel driverModel = driverModels.get(position);
        name.setText(driverModel.getName());
        time.setText(driverModel.getTime());
        phone.setText(driverModel.getPhone());
        vehicleno.setText(driverModel.getVehicleno());
        successfulldeliveries.setText(driverModel.getSuccessfulldeliveries());
        select.setVisibility(View.VISIBLE);

        return row;
    }
}
