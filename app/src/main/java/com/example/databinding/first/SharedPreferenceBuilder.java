package com.example.databinding.first;


import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

@Module
public class SharedPreferenceBuilder {

    SharedPreferenceBuilder sharedPreferenceBuilder;

    public static final String ContactName = "com.example.databinding.first.DashboardActivity";
    Context context;
    SharedPreferences sharedPreferences;

    @Inject
    public SharedPreferenceBuilder(Context context) {
        this.context = context;
    }

    @Provides
    public Context getProvides() {
        return context;
    }

    public String addDataToSharedPreference(String key, String value) {

        sharedPreferences = context.getSharedPreferences("ContactName", Context.MODE_PRIVATE); //shared pref (name,mode)
        sharedPreferences.edit().putString(key, value).commit();
        return "ok";
    }
}


