package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.PopupMenuCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import android.widget.Toast;



import com.example.databinding.first.R;

public class Main extends AppCompatActivity {

    private Button buttonLaunch;
    public EditText usernameedit,passwordedit,mailidedit;
    public RadioGroup genderedit;
    public Spinner regionedit;
    public String string1,string2,string3,string4,string5;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLaunch = (Button) findViewById(R.id.signup);

        buttonLaunch.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View view) {
                launchActivity();
            }

    });

    }



    private void launchActivity(){
        Intent intent = new Intent(this,SecondActivity.class);

        usernameedit = (EditText) findViewById(R.id.usernameedit);
        string1=usernameedit.getText().toString();
        intent.putExtra("username",string1);

        passwordedit =(EditText)findViewById(R.id.passwordedit);
        string2=passwordedit.getText().toString();
        intent.putExtra("password",string2);

        mailidedit = (EditText)findViewById(R.id.mailidedit);
        string3=mailidedit.getText().toString();
        intent.putExtra("mail",string3);

        genderedit =(RadioGroup)findViewById(R.id.radioGroup);
        int id=genderedit.getCheckedRadioButtonId();
        RadioButton radioButton=(RadioButton) findViewById(id);
        string4=radioButton.getText().toString();
        intent.putExtra("gender",string4);

        regionedit = (Spinner)findViewById(R.id.spinner3);
        String region=String.valueOf(regionedit.getSelectedItem());
        intent.putExtra("region",region);
        startActivity(intent);
        finish();


    }



        public void toastMe(View view)
        {
            Toast myToast = Toast.makeText(this,"Hi Toast!",
                    Toast.LENGTH_SHORT);
            myToast.show();
        }

    public void countMe(View view)
    {
        Toast showCountTextView = Toast.makeText(this,"Count",
                Toast.LENGTH_SHORT);
        showCountTextView.show();

    }


    }

