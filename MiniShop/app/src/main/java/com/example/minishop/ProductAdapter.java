package com.example.minishop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

//public class ProductAdapter extends ArrayAdapter<Product> {
//    private Context context;
//    private Product[] products;
//
//    private TextView footerTextView;
//
//    int list_item;
//    //private int item;
//    public ProductAdapter(Context context,Product[] products,TextView footerTextView){
//        super(context,R.layout.list_item,products);
//        this.context = context;
//        this.products = products;
//        this.footerTextView = footerTextView;
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View view = inflater.inflate(R.layout.list_item,parent,false);
//
//        TextView productId = (TextView) view.findViewById(R.id.productId);
//        TextView productTitle = (TextView) view.findViewById(R.id.productTitle);
//        TextView productPrice = (TextView) view.findViewById(R.id.productPrice);
//        ImageView productImage = (ImageView) view.findViewById(R.id.productImage);
//        CheckBox checkBox = (CheckBox) view.findViewById(R.id.productCheckbox);
//
//
//        productId.setText("id:"+String.valueOf(this.products[position].getId()));
//        productTitle.setText("Title"+this.products[position].getTitle());
//        productPrice.setText("Price:" + String.valueOf(this.products[position].getPrice()) + " BYN");
//        productImage.setImageResource(this.products[position].getProductImage());
//        checkBox.setChecked(this.products[position].isActivated());
//
//        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                products[position].setActivated(isChecked); // Устанавливаем состояние чекбокса в объекте Product
//                System.out.println(products[position].getTitle() + " = " + isChecked);
//                footerTextView.setText("Total items: " + getActivatedProductCount());
//                System.out.println(getActivatedProductCount());
//            }
//        });
//
//        return view;
//    }
//
//    public int getActivatedProductCount() {
//        int count = 0;
//        for (Product product : products) {
//            if (product.isActivated()) {
//                count++;
//            }
//        }
//        return count;
//    }
//
//    public double getTotalPrice() {
//        double totalPrice=0;
//        for (Product product : products) {
//            totalPrice+=product.getPrice();
//        }
//        return totalPrice;
//    }
//
//}
public class ProductAdapter extends ArrayAdapter<Product> {
    private Context context;
    private Product[] products;
    private TextView footerTextView;
    private int layoutResourceId;

    public ProductAdapter(Context context, int layoutResourceId, Product[] products, TextView footerTextView) {
        super(context, layoutResourceId, products);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.products = products;
        this.footerTextView = footerTextView;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = convertView;
        view = inflater.inflate(layoutResourceId, parent, false);

        if (this.layoutResourceId == R.layout.list_item){
            TextView productId = view.findViewById(R.id.productId);
            TextView productTitle = view.findViewById(R.id.productTitle);
            TextView productPrice = view.findViewById(R.id.productPrice);
            ImageView productImage = view.findViewById(R.id.productImage);
            CheckBox checkBox = view.findViewById(R.id.productCheckbox);

            productId.setText("id: " + String.valueOf(products[position].getId()));
            productTitle.setText("Title: " + products[position].getTitle());
            productPrice.setText("Price: " + String.valueOf(products[position].getPrice()) + " BYN");
            productImage.setImageResource(products[position].getProductImage());
            checkBox.setChecked(products[position].isActivated());

            checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
                products[position].setActivated(isChecked);
                footerTextView.setText("Total items: " + getActivatedProductCount());
            });
        }
        else{
            TextView productId = view.findViewById(R.id.productId);
            TextView productTitle = view.findViewById(R.id.productTitle);
            TextView productPrice = view.findViewById(R.id.productPrice);
            ImageView productImage = view.findViewById(R.id.productImage);
            CheckBox checkBox = view.findViewById(R.id.productCheckbox);

            productId.setText("id: " + String.valueOf(products[position].getId()));
            productTitle.setText("Title: " + products[position].getTitle());
            productPrice.setText("Price: " + String.valueOf(products[position].getPrice()) + " BYN");
            productImage.setImageResource(products[position].getProductImage());
        }

        return view;
    }

    public int getActivatedProductCount() {
        int count = 0;
        for (Product product : products) {
            if (product.isActivated()) {
                count++;
            }
        }
        return count;
    }
    public double getTotalPrice() {
        double totalPrice=0;
        for (Product product : products) {
            totalPrice+=product.getPrice();
        }
        return totalPrice;
    }
}