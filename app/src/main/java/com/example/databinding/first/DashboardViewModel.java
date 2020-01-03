package com.example.databinding.first;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

public class DashboardViewModel extends ViewModel {
    public static ObservableField<String> fullName = new ObservableField<>();
}
