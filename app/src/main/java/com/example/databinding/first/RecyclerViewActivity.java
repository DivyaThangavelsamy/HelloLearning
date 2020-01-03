package com.example.databinding.first;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Map;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class RecyclerViewActivity extends AppCompatActivity {

    ArrayList<String> mContacts = new ArrayList<>();
    RecyclerView mRecyclerView;
    public Bundle getbundle = null;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_activity);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);



        SharedPreferences sharedPreferences = getSharedPreferences("ContactName", Context.MODE_PRIVATE); //shared pref  //edit shared pref to put data


        Map<String, ?> data = sharedPreferences.getAll();
        for (Map.Entry value : data.entrySet()) {

            mContacts.add(value.getValue().toString());
        }



        mContacts.add("John");
        mContacts.add("William");
        mContacts.add("Lisa");
        mContacts.add("Abraham");
        mContacts.add("Malone");
        mContacts.add("Kel");
        mContacts.add("John");
        mContacts.add("William");


        UserNameContacts userNameContacts = new UserNameContacts(mContacts);

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new MainAdapter(userNameContacts);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


    }
}


