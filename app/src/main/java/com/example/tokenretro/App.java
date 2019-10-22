package com.example.tokenretro;

import android.app.Application;

import com.facebook.stetho.Stetho;

public class App extends Application {
    public Settings settings;

    @Override
    public void onCreate() {
        super.onCreate();

        settings = new Settings(getApplicationContext());
        Stetho.initializeWithDefaults(this);
    }
}
