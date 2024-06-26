package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.ProductAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class fragment_list extends Fragment {

    private ListView productList;
    private ArrayList<JSONObject> listItems;

    public fragment_list(ArrayList<JSONObject> listItems) {
        this.listItems = listItems;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listview, container, false);

        productList = view.findViewById(R.id.productList);
        View footer = inflater.inflate(R.layout.footer,null);
        View header = inflater.inflate(R.layout.header,null);
        TextView footerTextView = footer.findViewById(R.id.totalItemsTextView);
        productList.addFooterView(footer);
        productList.addHeaderView(header);
        ProductAdapter adapter = new ProductAdapter(requireContext(), R.layout.list_item, R.id.productTitle, listItems);
        productList.setAdapter(adapter);
        footerTextView.setText("Total count: " + String.valueOf(adapter.getTotalCount()));
        productList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "Информация в отдельном фрагменте", Toast.LENGTH_SHORT).show();
                JSONObject selectedItem = listItems.get(position-1);
                try {
                    String detailInfo = selectedItem.getString("id") + ","
                            + selectedItem.getString("name") + ","
                             + selectedItem.getString("price");

                    FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, new fragment_iteminfo(detailInfo));
                    transaction.addToBackStack(null);
                    transaction.commit();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        return view;
    }
}