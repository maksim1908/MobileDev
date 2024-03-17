package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;


public class MainActivity extends AppCompatActivity {

    String URL_PATH;
    private Button parseJson;
    private EditText editTextUrl;
    ListView productList;
    ProgressBar progressBar;
    TextView footerTextView;
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

        /*productList = findViewById(R.id.productList);
        View footer = LayoutInflater.from(this).inflate(R.layout.footer,null);
        View header = LayoutInflater.from(this).inflate(R.layout.header,null);
        footerTextView = footer.findViewById(R.id.totalItemsTextView);
        productList.addFooterView(footer);
        productList.addHeaderView(header);*/


        parseJson = findViewById(R.id.parseJSON);
        editTextUrl = findViewById(R.id.editTextURL);
        editTextUrl.setText("https://raw.githubusercontent.com/maksim1908/Lab/main/products.json");


        parseJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                URL_PATH = editTextUrl.getText().toString();
                getJsonDataFromUrlPath(URL_PATH);
            }
        });
    }

    private void getJsonDataFromUrlPath(String url_path){
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(ListView.VISIBLE);
        System.out.println("======================================="+url_path);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url_path, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.INVISIBLE);
                try {
                    JSONObject jsonObject = new JSONObject(response);
//                    JSONArray jsonArr = jsonObject.getJSONArray("products");
//                    ArrayList<JSONObject> listItems = getArrayListFromJSON(jsonArr);
//                    ProductAdapter adapter = new ProductAdapter(getApplicationContext(),R.layout.list_item,R.id.productTitle,listItems);
//                    productList.setAdapter(adapter);
//                    footerTextView.setText("Total count: " + String.valueOf(adapter.getTotalCount()));
                    Iterator<String> keys = jsonObject.keys();
                    while(keys.hasNext()) {
                        String key = keys.next();
                        if (jsonObject.get(key) instanceof JSONArray) {
                            JSONArray jsonArr = jsonObject.getJSONArray(key);
                            ArrayList<JSONObject> listItems = getArrayListFromJSON(jsonArr);
                            /*ProductAdapter adapter = new ProductAdapter(getApplicationContext(), R.layout.list_item, R.id.productTitle, listItems);
                            productList.setAdapter(adapter);
                            footerTextView.setText("Total count: " + String.valueOf(adapter.getTotalCount()));*/
                            displayFragment(listItems);
                        }
                    }
                }
                catch (JSONException exception){
                    exception.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getApplicationContext(),volleyError.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private ArrayList<JSONObject> getArrayListFromJSON(JSONArray jsonArray){
        ArrayList<JSONObject> listItems = new ArrayList<>();
        try {
            if(jsonArray != null){
                for(int i = 0; i<jsonArray.length(); i++){
                    listItems.add(jsonArray.getJSONObject(i));
                }
            }
        }
        catch (JSONException exception){
            exception.printStackTrace();
        }
        return listItems;
    }

    private void displayFragment(ArrayList<JSONObject> listItems) {
        fragment_list fragment = new fragment_list(listItems);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}