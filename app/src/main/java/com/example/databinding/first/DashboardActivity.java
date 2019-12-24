package com.example.databinding.first;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.databinding.DataBindingUtil;
import android.widget.EditText;

import com.example.databinding.first.databinding.DashboardviewActivityBinding;

import androidx.appcompat.app.AppCompatActivity;


public class DashboardActivity extends AppCompatActivity {

    Bundle bundle=new Bundle();
    Button buttonclick;
    EditText typeedit;
    String string1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.dashboardview_activity);
        DashboardviewActivityBinding dashboardviewActivityBinding=DataBindingUtil.setContentView(this,R.layout.dashboardview_activity);
        DasboardPojo dasboardPojo=new DasboardPojo();
        dashboardviewActivityBinding.setDashboardview(dasboardPojo);

        final Intent intent = new Intent(this,RecyclerViewActivity.class);
        buttonclick = findViewById(R.id.click);

        buttonclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String NameEdit=DasboardPojo.fullName.get();

              bundle.putString("Name",NameEdit);
                System.out.println("Type:"+NameEdit);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });

    }
}