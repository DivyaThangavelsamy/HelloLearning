package com.example.databinding.first;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.databinding.DataBindingUtil;
import android.widget.EditText;

import com.example.databinding.first.databinding.DashboardviewActivityBinding;

import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;


public class DashboardActivity extends AppCompatActivity {

    Bundle bundle=new Bundle();
    Button buttonclick,displayclick;

    EditText typeedit;
    String string1;
    SharedPreferences sharedPreferences;//instance of shared Pref

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.dashboardview_activity);
        DashboardviewActivityBinding dashboardviewActivityBinding=DataBindingUtil.setContentView(this,R.layout.dashboardview_activity);
        DasboardPojo dasboardPojo=new DasboardPojo();
        dashboardviewActivityBinding.setDashboardview(dasboardPojo);

        final Intent intent = new Intent(this,RecyclerViewActivity.class);
        buttonclick = findViewById(R.id.click);
        displayclick= findViewById(R.id.display);

        sharedPreferences = getSharedPreferences("ContactName", Context.MODE_PRIVATE); //shared pref (name,mode)

        buttonclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String NameEdit=DasboardPojo.fullName.get();


                System.out.println("Type:"+NameEdit);


                SharedPreferences.Editor editor = sharedPreferences.edit(); //edit shared pref to put data

                editor.putString(NameEdit,NameEdit).commit(); //put data in shared pref

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