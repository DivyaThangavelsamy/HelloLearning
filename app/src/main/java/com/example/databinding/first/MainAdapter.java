package com.example.databinding.first;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    // ArrayList<String> mContacts;
    UserNameContacts userNameContacts;

    public MainAdapter(UserNameContacts userNameContacts) {
        this.userNameContacts = userNameContacts;
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {
        holder.mFullName.setText(userNameContacts.mContacts.get(position));
    }

    @Override
    public int getItemCount() {
        return userNameContacts.mContacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mFullName;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mFullName = (TextView) itemView.findViewById(R.id.full_name);

        }

    }
}


