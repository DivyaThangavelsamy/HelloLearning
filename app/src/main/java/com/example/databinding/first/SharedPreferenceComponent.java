package com.example.databinding.first;

import dagger.Component;

@Component(modules = SharedPreferenceBuilder.class)

public interface SharedPreferenceComponent {

    void getSharedPreferenceComponentObject(DashboardActivity dashboardActivity);

    SharedPreferenceBuilder getSharedPreferenceBuilder();
}
