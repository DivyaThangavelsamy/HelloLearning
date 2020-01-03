package com.example.databinding.first;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {
    public static ObservableField<String> loginusername = new ObservableField<>();
    public static ObservableField<String> loginpassword = new ObservableField<>();
}
