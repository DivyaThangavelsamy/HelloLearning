package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
     private Button goback;

     TextView un,mail,gender,region;

     String st1,st2,st3,st4,st5;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        un=findViewById(R.id.usernameedit);
        mail=findViewById(R.id.mailidedit);
        gender=findViewById(R.id.genderedit);
        region=findViewById(R.id.regionedit);




        st1=getIntent().getExtras().getString("username");
        un.setText(st1);

        st2=getIntent().getExtras().getString("mail");
        mail.setText(st2);

        st3=getIntent().getExtras().getString("gender");
        gender.setText(st3);

        st4=getIntent().getExtras().getString("region");
        region.setText(st4);






    }
}
