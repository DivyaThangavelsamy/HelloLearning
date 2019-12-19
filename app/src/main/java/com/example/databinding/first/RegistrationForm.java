package com.example.databinding.first;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.regex.Pattern;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;

public class RegistrationForm {

    public final ObservableField<String> userName = new ObservableField<>();
    public final ObservableField<String> mailid = new ObservableField<>();
    public final ObservableField<String> password = new ObservableField<>();
    public final ObservableField<String> gender = new ObservableField<>();
    public final ObservableField<String> region =new ObservableField<>();
    public final ObservableField<String> phonenumber = new ObservableField<>();
    public final ObservableField<String> toastMessage=new ObservableField<>();
    public final ObservableField<Boolean> signUp= new ObservableField<>();
    public final ObservableField<String> usernameprofile = new ObservableField<>();
    public final ObservableField<String> emailprofile = new ObservableField<>();
    public final ObservableField<String> genderprofile = new ObservableField<>();
    public final ObservableField<String> regionprofile = new ObservableField<>();

    public Button buttonLaunch;
    boolean userNameIs;
    boolean emailIdIs;
    boolean passwordIs;
    boolean selectedRegionIf;
    boolean selectedgenderIf;
    boolean phonenumberIs;
    boolean checkedChangeIs;
    boolean IsEnabled;



    private static Pattern EMAIL_PATTERN = Pattern.compile("^[a-z0-9-\\+]+(\\.[a-z0-9-]+)*@"
            + "[a-z0-9-]+(\\.[a-z0-9]+)*(\\.[ a-z]{2,})$");

    private static Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])" +
            "(?=.*[a-z])" +
            "(?=.*[A-Z])" +
            "(?=.*[@#$%^&+=])" +
            "(?=\\S+$)" +
            ".{8,}" +
            "$");




public TextWatcher usernameValidation=new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {


        System.out.println(userName.get());
        int minimumLength = 5;

        if (TextUtils.isEmpty(userName.get())) {
            System.out.println("Username is Required");
            toastMessage.set("Username is required");

        } else if (userName.get().length() < 5) {
            System.out.println("Username must be length of 5");
            toastMessage.set("Username must be length of 5");
        } else {
            userNameIs =true;

        }
    }
};
public TextWatcher emailidValidation=new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        System.out.println(mailid.get());
        if(userNameIs==true) {
            if (TextUtils.isEmpty(mailid.get())) {
                System.out.println(mailid.get());
                toastMessage.set("EmailId is required");
            }
            if (!EMAIL_PATTERN.matcher(mailid.get()).matches()) {
                toastMessage.set("Not a Valid Email");
            } else {
                emailIdIs = true;

            }
        }
        else{
               mailid.set("");
               toastMessage.set("Enter Valid UserName");
            }

        }

    };


public TextWatcher passwordValidation=new TextWatcher() {

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        System.out.println(password.get());
        if (emailIdIs == true) {

            if (TextUtils.isEmpty(password.get())) {
                System.out.println("Password is Required");
                toastMessage.set("Password is required");
            }
            if (!PASSWORD_PATTERN.matcher(password.get()).matches()) {
                toastMessage.set("Not a Valid Password");
            } else
                passwordIs = true;
        } else {
            password.set("");
            toastMessage.set("Enter a Valid Email Id");
        }

    }
};


    public void onCheckedChanged(boolean checked) {
        if (checked == true) {
            System.out.println(checked);
            checkedChangeIs = true;

        }
    }


    public void onSelectedItem(AdapterView parent, View view, int pos, long id) {
        region.set((String) parent.getSelectedItem());

        if (parent.getSelectedItem().equals("Select")) {

            selectedRegionIf = true;

        }
    }

    public void genderValidation(String value) {
        gender.set(value);
        if (!TextUtils.isEmpty(gender.get())) {
            selectedgenderIf = true;
        }
    }

    public TextWatcher phoneNumberValidation = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override


        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (passwordIs == true && selectedRegionIf == true && selectedgenderIf == true && checkedChangeIs == true) {

                if (TextUtils.isEmpty(phonenumber.get())) {
                    toastMessage.set("Enter a phone number");

                }
                if (phonenumber.get().length() != 10) {
                    toastMessage.set("Phone Number must be 10 digits");
                } else {
                    phonenumberIs = true;
                }
            } else {
                phonenumber.set("");
                toastMessage.set("Enter Valid Password");

            }
            IsEnabled();
        }
    };




        public void IsEnabled() {
            if (phonenumberIs == true) {
                signUp.set(true);
            } else {
                signUp.set(false);
            }
        }
    }





