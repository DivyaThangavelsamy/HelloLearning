package com.example.databinding.first;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.databinding.first.databinding.LoginActivityBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

public class LoginActivity extends AppCompatActivity {
    Bundle bundle = new Bundle();
    LoginViewModel loginViewModel;
    Button buttonclick;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final LoginActivityBinding loginActivityBinding = DataBindingUtil.setContentView(this, R.layout.login_activity);

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        loginActivityBinding.setLoginview(loginViewModel);
        final ResponseBuilderComponent responseBuilderComponent = DaggerResponseBuilderComponent.create();

        final Intent intent = new Intent(this, DashboardActivity.class);
        buttonclick = findViewById(R.id.loginButton);
        buttonclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernamelogin = loginViewModel.loginusername.get();
                System.out.println("Username=" + usernamelogin);
                String passwordlogin = loginViewModel.loginpassword.get();
                System.out.println("Password=" + passwordlogin);
                String message = responseBuilderComponent.getResponseBuilder().getValidation(usernamelogin, passwordlogin);
                if ("Success".equals(message)) {
                    startActivity(intent);
                    finish();

                } else {
                    System.out.println("Failed");
                }
            }

        });

    }
}

