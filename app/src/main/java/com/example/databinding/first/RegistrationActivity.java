package com.example.databinding.first;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.databinding.first.databinding.ActivityMainBinding;


public class RegistrationActivity extends AppCompatActivity {

    Bundle bundle=new Bundle();
    public Button buttonLaunch;
    Intent intent;
    public EditText usernameedit,passwordedit,mailidedit;
    public RadioGroup genderedit;
    public Spinner regionedit;
    RegistrationForm registrationForm;
    public String string1,string2,string3,string4,string5;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


       ActivityMainBinding mBinding= DataBindingUtil.setContentView(this, R.layout.activity_main);
         registrationForm=new RegistrationForm();
        mBinding.setViewModel(registrationForm);



        final Intent intent = new Intent(this, ProfileInfo.class);


        buttonLaunch = findViewById(R.id.signup);
        buttonLaunch.setOnClickListener(new View.OnClickListener(){


            public void onClick(View view) {

                AlertDialog.Builder builder=new AlertDialog.Builder(RegistrationActivity.this);
                builder.setMessage("Do you want to proceed");
                builder.setCancelable(false);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        final String username=registrationForm.userName.get();
                        final  String mailid=registrationForm.mailid.get();
                        final String gender=registrationForm.gender.get();
                        final String region=registrationForm.region.get();

                        bundle.putString("Name",username);
                        bundle.putString("Email",mailid);
                        bundle.putString("Gender",gender);
                        bundle.putString("Region",region);
                        intent.putExtras(bundle);
                        startActivity(intent);

                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alertDialog=builder.create();
                alertDialog.show();

            }

        });

        }

    //static Toast toast;

    @BindingAdapter({"toastMessage"})
    public static void toastMe(View view,String message)

    {

        if(message!=null) {
            Toast.makeText(view.getContext(), message,
                    Toast.LENGTH_SHORT).show();
           // Handler handler = new Handler();
           // handler.postDelayed(new Runnable() {
             //   @Override
               // public void run() {
               //     toast.show();
               // }
           // }, 1000);
        }

    }



/*
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


    }/*





   /* public void countMe(View view)
    {
        Toast showCountTextView = Toast.makeText(this,"Count",
                Toast.LENGTH_SHORT);
        showCountTextView.show();

    }*/


}

