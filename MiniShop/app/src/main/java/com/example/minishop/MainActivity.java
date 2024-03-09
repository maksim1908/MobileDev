package com.example.minishop;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Product[] products = {
            new Product(1,"Logitech G Pro",365.25,R.drawable.g403),
            new Product(2,"Logitech G 805",725.00,R.drawable.g805),
            new Product(3,"Razer Deathadder V3 Pro",393.90,R.drawable.v3pro),
            new Product(4,"ASUS ROG Keris Wireless AimPoint",286.43,R.drawable.rog),
            new Product(5,"HyperX Cloud Alpha",295.00,R.drawable.cloudalpha),
            new Product(6,"HyperX Fury S Pro M",69.00,R.drawable.furys),
            new Product(7,"ASUS ROG Azoth",1453.75,R.drawable.asusazoth)
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //футер для ListView
        View footer = LayoutInflater.from(this).inflate(R.layout.footer,null);
        View header = LayoutInflater.from(this).inflate(R.layout.header,null);
        TextView footerTextView = footer.findViewById(R.id.totalItemsTextView);
        ListView mainListView = findViewById(R.id.mainListView);
        mainListView.addFooterView(footer);
        mainListView.addHeaderView(header);





        ProductAdapter adapter = new ProductAdapter(this,R.layout.list_item,products,footerTextView);
        mainListView.setAdapter(adapter);

        Button showBasket = (Button) footer.findViewById(R.id.showCartButton);

        showBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<Product> selectedProducts = new ArrayList<>();
                for (Product product : products) {
                    if (product.isActivated()) {
                        selectedProducts.add(product);

                    }
                }
                Intent intent = new Intent(MainActivity.this, second_activity.class);
                intent.putExtra("selectedProducts", selectedProducts);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Переход в корзину", Toast.LENGTH_SHORT).show();
            }
        });

    }

}