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
        CartListAdapter.ViewHolder holder = new CartListAdapter.ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.name = (TextView) row.findViewById(R.id.name);
            holder.price = (TextView) row.findViewById(R.id.price);
            holder.quantity = (TextView) row.findViewById(R.id.quantity);
            holder.itemimage = (ImageView) row.findViewById(R.id.imgFood);
            //holder.imageView = (ImageView) row.findViewById(R.id.imgFood);
            row.setTag(holder);
        }
        else {
            holder = (CartListAdapter.ViewHolder) row.getTag();
        }

        CartList  list = cartList.get(position);

        holder.name.setText(list.getName());
        holder.price.setText(list.getPrice());

        byte[] foodImage = list.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(foodImage, 0, foodImage.length);
        holder.itemimage.setImageBitmap(bitmap);
        return row;
    }
}
