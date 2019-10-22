package com.example.tokenretro;

import android.content.Context;
import android.content.SharedPreferences;

public class Settings {
    private SharedPreferences settings;

    public Settings(Context context) {
        settings = context.getSharedPreferences("steve_settings", Context.MODE_PRIVATE);
    }

    public String getBearerToken(String usertoken) {
        return settings.getString("token", "");
    }

    public void setBearerToken(String token) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("token", token);
        editor.apply();
    }

    public String getFullName() {
        return settings.getString("name", "");
    }

    public void setFullName(String token) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("name", token);
        editor.apply();
    }

}

