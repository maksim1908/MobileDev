package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class fragment_iteminfo extends Fragment {

    private String detailInfo;

    public fragment_iteminfo(String detailInfo) {
        this.detailInfo = detailInfo;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmet_iteminfo, container, false);
        String[] info = detailInfo.split(",");
        TextView id = view.findViewById(R.id.Id);
        TextView name = view.findViewById(R.id.Title);
        TextView price = view.findViewById(R.id.Price);
        id.setText("id: " + info[0]);
        name.setText("Title" + info[1]);
        price.setText("Price:" + info[2] + " BYN");

        return view;
    }
}