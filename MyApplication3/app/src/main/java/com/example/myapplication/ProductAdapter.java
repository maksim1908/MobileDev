package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProductAdapter extends ArrayAdapter<JSONObject> {
    private int listLayout;
    private ArrayList<JSONObject> productsList;
    private Context context;

    public ProductAdapter(Context context, int listLayout , int field, ArrayList<JSONObject> usersList) {
        super(context, listLayout, field, usersList);
        this.context = context;
        this.listLayout=listLayout;
        this.productsList = usersList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View listViewItem = inflater.inflate(listLayout, null, false);
        TextView id = listViewItem.findViewById(R.id.productId);
        TextView name = listViewItem.findViewById(R.id.productTitle);
        TextView price = listViewItem.findViewById(R.id.productPrice);
        try{
            id.setText("id: " + productsList.get(position).getString("id"));
            name.setText("title: "+productsList.get(position).getString("name"));
            price.setText("price: "+productsList.get(position).getString("price")+" BYN");
        }catch (JSONException je){
            je.printStackTrace();
        }
        return listViewItem;
    }

    public int getTotalCount(){
        return productsList.size();
    }
}