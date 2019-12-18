package com.example.databinding.first;

import android.app.AppComponentFactory;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.ViewModel;

public class RegistrationForm {
    static boolean usernameenabled;


    private static Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])" +
            "(?=.*[a-z])" +
            "(?=.*[A-Z])" +
            "(?=.*[@#$%^&+=])" +
            "(?=\\S+$)" +
            ".{8,}" +
            "$");

    private static Pattern EMAIL_PATTERN = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");


    @BindingAdapter("userNameValidator")
    public static void userNameValidator(EditText editText, String username) {
        System.out.println("Username is" + username);

        int minimumLength = 5;
        if (TextUtils.isEmpty(username)) {
            editText.setError(null);
            return;
        }
        if (editText.getText().toString().length() < minimumLength) {
            editText.setError("username must be minimum" + minimumLength + "length");
        } else {
            editText.setError(null);
            usernameenabled = true;
        }


    }

    @BindingAdapter("emailidValidator")
    public static void emailidValidator(EditText editText, String emailid) {
        System.out.println("Emailid is" + emailid);
        if (TextUtils.isEmpty(emailid)) {
            editText.setError(null);
            return;
        }
        if (!EMAIL_PATTERN.matcher(emailid).matches()) {
            editText.setError("Not a Valid Email");
        } else
            editText.setError(null);
    }

    @BindingAdapter("passwordValidator")
    public static void passwordValidator(EditText editText, String password) {


        if (TextUtils.isEmpty(password)) {
            editText.setError(null);
            return;
        }

        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            editText.setError("Password too weak-Password should contain 1 Upper Case,1 Lower Case,1 Special Character and 1 Numeric and minimum length should be 8");
        } else {
            editText.setError(null);
        }

    }

    @BindingAdapter("phonenumberValidator")
    public static void phonenumberValidator(EditText editText, String phonenumber) {
        if (TextUtils.isEmpty(phonenumber)) {
            editText.setError(null);
            return;
        }
        if (editText.getText().toString().length() != 10) {
            editText.setError("Phone Number must be 10 digits");


        } else {
            editText.setError(null);
        }


    }

    @BindingAdapter("AgreeCheckBoxValidator")

    public void AgreeCheckBoxValidator(CheckBox checkbox) {
        checkbox.setEnabled(false);
        if (usernameenabled == true) {
            checkbox.setEnabled(true);

        }


    /*if(checkBox.isChecked()){
        signup.setVisibility(View.VISIBLE);
    }*/

    }

}



