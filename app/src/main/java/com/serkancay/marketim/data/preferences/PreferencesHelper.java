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

    public void setRememberMe(boolean isRememberMeOn) {
        setSharedPreferenceBoolean(Keys.REMEMBER_ME, isRememberMeOn);
    }

    public boolean isRememberMeOn() {
        return getSharedPreferenceBoolean(Keys.REMEMBER_ME, false);
    }

    public void setUsername(String username) {
        setSharedPreferenceString(Keys.USERNAME, username);
    }

    public String getUsername() {
        return getSharedPreferenceString(Keys.USERNAME, "");
    }

    public void setPassword(String password) {
        setSharedPreferenceString(Keys.PASSWORD, password);
    }

    public String getPassword() {
        return getSharedPreferenceString(Keys.PASSWORD, "");
    }

    public class Keys {

        public static final String REMEMBER_ME = "REMEMBER_ME";

        public static final String USERNAME = "USERNAME";

        public static final String PASSWORD = "PASSWORD";
    }

}
