package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProductFragment extends Fragment {

    private static final String ARG_PRODUCT_NAME = "productName";
    private static final String ARG_PRODUCT_PRICE = "productPrice";

    public static ProductFragment newInstance(String productName, String productPrice) {
        ProductFragment fragment = new ProductFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PRODUCT_NAME, productName);
        args.putString(ARG_PRODUCT_PRICE, productPrice);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_product, container, false);
        TextView productNameTextView = rootView.findViewById(R.id.productNameTextView);
        TextView productPriceTextView = rootView.findViewById(R.id.productPriceTextView);

        Bundle args = getArguments();
        if (args != null) {
            String productName = args.getString(ARG_PRODUCT_NAME);
            String productPrice = args.getString(ARG_PRODUCT_PRICE);
            productNameTextView.setText(productName);
            productPriceTextView.setText(productPrice);
        }

        return rootView;
    }
}
