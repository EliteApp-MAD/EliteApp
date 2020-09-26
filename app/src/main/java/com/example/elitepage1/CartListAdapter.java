package com.example.elitepage1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CartListAdapter extends BaseAdapter {

    private Context context;
    private  int layout;
    private ArrayList<CartList> cartList;

    public CartListAdapter(Context context, int layout, ArrayList<CartList> cartList) {
        this.context = context;
        this.layout = layout;
        this.cartList = cartList;
    }

    @Override
    public int getCount() {
        return cartList.size();
    }

    @Override
    public Object getItem(int position) {
        return cartList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView itemimage;
        TextView name, price, quantity;

    }
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        //CartListAdapter.ViewHolder holder = new CartListAdapter.ViewHolder();
        ViewHolder holder1 =  new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder1.name = (TextView) row.findViewById(R.id.txtName1);
            holder1.price = (TextView) row.findViewById(R.id.txtPrice1);
            holder1.quantity = (TextView) row.findViewById(R.id.txtCategory1);
            holder1.itemimage = (ImageView) row.findViewById(R.id.imgitem);
            //holder.imageView = (ImageView) row.findViewById(R.id.imgFood);
            row.setTag(holder1);
        }
        else {
            holder1 = (ViewHolder) row.getTag();
        }

        CartList  list1 = cartList.get(position);

        holder1.name.setText(list1.getName());
        holder1.price.setText(list1.getPrice());
        holder1.quantity.setText(list1.getQuantity());

        byte[] foodImage1 = list1.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(foodImage1, 0, foodImage1.length);
        holder1.itemimage.setImageBitmap(bitmap);
        return row;
    }
}
