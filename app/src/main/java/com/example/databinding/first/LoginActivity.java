package com.example.databinding.first;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.databinding.first.databinding.LoginActivityBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class LoginActivity extends AppCompatActivity {
    Bundle bundle = new Bundle();
    Button buttonclick;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final LoginActivityBinding loginActivityBinding = DataBindingUtil.setContentView(this, R.layout.login_activity);
        LoginPojo loginPojo = new LoginPojo();
        loginActivityBinding.setLoginview(loginPojo);

        final Intent intent = new Intent(this, DashboardActivity.class);
        buttonclick = findViewById(R.id.loginButton);
        buttonclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernamelogin = LoginPojo.loginusername.get();
                System.out.println("Username=" + usernamelogin);
                String passwordlogin = LoginPojo.loginpassword.get();
                System.out.println("Password=" + passwordlogin);
                if ((usernamelogin.equals("admin")) && (passwordlogin.equals("admin"))) {

                    //System.out.println("Hi");

                  intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                   startActivity(intent);

                }



            }
        });
    }
}

