package com.example.databinding.first;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

   // ArrayList<String> mContacts;
Contacts contacts;

    public MainAdapter(Contacts contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {
             holder.mFullName.setText(contacts.mContacts.get(position));
    }

    @Override
    public int getItemCount() {
        return contacts.mContacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public EditText mFullName;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mFullName=(EditText)itemView.findViewById(R.id.full_name);

            }

        }
    }


