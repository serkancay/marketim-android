package com.serkancay.marketim.data.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;


public class PreferencesHelper {

    private final static String PREF_FILE = "PREF";

    private Context mContext;

    private Gson mGson;

    public PreferencesHelper(Context context) {
        mContext = context;
        mGson = new Gson();
    }

    public void setSharedPreferenceString(String key, String value) {
        SharedPreferences settings = mContext.getSharedPreferences(PREF_FILE, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public void setSharedPreferenceInt(String key, int value) {
        SharedPreferences settings = mContext.getSharedPreferences(PREF_FILE, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public void setSharedPreferenceBoolean(String key, boolean value) {
        SharedPreferences settings = mContext.getSharedPreferences(PREF_FILE, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public String getSharedPreferenceString(String key, String defValue) {
        SharedPreferences settings = mContext.getSharedPreferences(PREF_FILE, 0);
        return settings.getString(key, defValue);
    }

    public int getSharedPreferenceInt(String key, int defValue) {
        SharedPreferences settings = mContext.getSharedPreferences(PREF_FILE, 0);
        return settings.getInt(key, defValue);
    }

    public boolean getSharedPreferenceBoolean(String key, boolean defValue) {
        SharedPreferences settings = mContext.getSharedPreferences(PREF_FILE, 0);
        return settings.getBoolean(key, defValue);
    }

    public class Keys {

    }

}
