package com.example.databinding.first;

import android.os.Bundle;

import java.util.ArrayList;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class RecyclerViewActivity extends AppCompatActivity {

        ArrayList<String> mContacts=new ArrayList<>();
        RecyclerView mRecyclerView;
        public Bundle getbundle=null;
        RecyclerView.LayoutManager mLayoutManager;
        RecyclerView.Adapter mAdapter;



        @Override
        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.recyclerview_activity);
           mRecyclerView=(RecyclerView)findViewById(R.id.recycler_view);
         getbundle=this.getIntent().getExtras();
         mContacts.add(getbundle.getString("Name"));

           /*if(getIntent().hasExtra("Name")){
               mContacts.add(getIntent().getStringExtra("Name"));

           }*/


            mContacts.add("John");
            mContacts.add("William");
            mContacts.add("Lisa");
            mContacts.add("Abraham");
            mContacts.add("Malone");
            mContacts.add("Kel");
            mContacts.add("John");
            mContacts.add("William");
            mContacts.add("Lisa");
            mContacts.add("Abraham");
            mContacts.add("Malone");
            mContacts.add("Kel");
            mContacts.add("John");
            mContacts.add("William");
            mContacts.add("Lisa");
            mContacts.add("Abraham");
            mContacts.add("Malone");
            mContacts.add("Kel");
            mContacts.add("John");
            mContacts.add("William");
            mContacts.add("Lisa");
            mContacts.add("Abraham");
            mContacts.add("Malone");
            mContacts.add("Kel");
            mContacts.add("John");
            mContacts.add("William");
            mContacts.add("Lisa");
            mContacts.add("Abraham");
            mContacts.add("Malone");
            mContacts.add("Kel");
            mContacts.add("John");
            mContacts.add("William");
            mContacts.add("Lisa");
            mContacts.add("Abraham");
            mContacts.add("Malone");
            mContacts.add("Kel");
            mContacts.add("John");
            mContacts.add("William");
            mContacts.add("Lisa");
            mContacts.add("Abraham");
            mContacts.add("Malone");
            mContacts.add("Kel");
            mContacts.add("John");
            mContacts.add("William");
            mContacts.add("Lisa");
            mContacts.add("Abraham");
            mContacts.add("Malone");
            mContacts.add("Kel");
            mContacts.add("John");
            mContacts.add("William");
            mContacts.add("Lisa");
            mContacts.add("Abraham");
            mContacts.add("Malone");
            mContacts.add("Kel");
            mContacts.add("John");
            mContacts.add("William");
            mContacts.add("Lisa");
            mContacts.add("Abraham");
            mContacts.add("Malone");
            mContacts.add("Kel");
            Contacts contacts=new Contacts(mContacts);

            mRecyclerView.setHasFixedSize(true);
            mLayoutManager=new LinearLayoutManager(this);
            mAdapter=new MainAdapter(contacts);
            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setAdapter(mAdapter);




        }}

