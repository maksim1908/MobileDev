package com.example.minishop;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class second_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.second), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        View footer = LayoutInflater.from(this).inflate(R.layout.basket_footer,null);
        View header = LayoutInflater.from(this).inflate(R.layout.basket_header,null);
        TextView footerTextView = footer.findViewById(R.id.totalItemsBasket);
        TextView totalPrice = footer.findViewById(R.id.totalItemsPrice);
        ListView basketListView = findViewById(R.id.basketListView); // Здесь используем правильный идентификатор
        basketListView.addFooterView(footer);
        basketListView.addHeaderView(header);

        Intent intent = getIntent();
        if (intent != null) {
            ArrayList<Product> selectedProducts = (ArrayList<Product>) intent.getSerializableExtra("selectedProducts");
            Product[] products = selectedProducts.toArray(new Product[selectedProducts.size()]);
            for (Product product : products) {
                System.out.println(product);
            }

            if (selectedProducts != null) {
                ProductAdapter adapter = new ProductAdapter(this,R.layout.backet_list_item, products, footerTextView);
                basketListView.setAdapter(adapter);
                footerTextView.setText("Total count:"+adapter.getActivatedProductCount());
                totalPrice.setText(String.format("Total price: %.2f BYN", adapter.getTotalPrice()));
            }
        }


    }
}