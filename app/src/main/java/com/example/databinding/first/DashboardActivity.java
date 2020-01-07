package com.example.databinding.first;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.databinding.DataBindingUtil;

import android.widget.EditText;

import com.example.databinding.first.databinding.DashboardviewActivityBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;


public class DashboardActivity extends AppCompatActivity {

    Bundle bundle = new Bundle();
    DashboardViewModel dashboardViewModel;
    Button buttonclick, displayclick;

    EditText typeedit;
    String string1;
    SharedPreferences sharedPreferences;//instance of shared Pref

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DashboardviewActivityBinding dashboardviewActivityBinding = DataBindingUtil.setContentView(this, R.layout.dashboardview_activity);

        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);

        final SharedPreferenceComponent sharedPreferenceComponent = DaggerSharedPreferenceComponent.builder().sharedPreferenceBuilder(new SharedPreferenceBuilder(this)).build();
        sharedPreferenceComponent.getSharedPreferenceComponentObject(this);
        DaggerResponseBuilderComponent.create();
        dashboardviewActivityBinding.setDashboardview(dashboardViewModel);
        final Intent intent = new Intent(this, RecyclerViewActivity.class);
        buttonclick = findViewById(R.id.click);
        displayclick = findViewById(R.id.display);


        buttonclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sharedPreferenceComponent.getSharedPreferenceBuilder().addDataToSharedPreference(dashboardViewModel.fullName.get(), dashboardViewModel.fullName.get());


                String NameEdit = DashboardViewModel.fullName.get();


            }
        });
        displayclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(intent);
            }
        });
    }
}