package com.example.databinding.first;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.databinding.first.databinding.ActivitySecondBinding;


public class ProfileInfo extends AppCompatActivity {
    private Button goback;
    public Bundle getbundle=null;

    TextView un,mail,gender,region;

    String st1,st2,st3,st4,st5;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySecondBinding profileInfo= DataBindingUtil.setContentView(this,R.layout.activity_second);
        RegistrationForm registrationForm=new RegistrationForm();
        profileInfo.setViewModel(registrationForm);

        getbundle=this.getIntent().getExtras();

        registrationForm.usernameprofile.set(getbundle.getString("Name"));
        registrationForm.emailprofile.set(getbundle.getString("Email"));
        registrationForm.genderprofile.set(getbundle.getString("Gender"));
        registrationForm.regionprofile.set(getbundle.getString("Region"));


        /*un=findViewById(R.id.usernameedit);
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
        region.setText(st4);*/






    }
}

