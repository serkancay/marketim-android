package com.serkancay.marketim.data.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import com.serkancay.marketim.di.ApplicationContext;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PreferencesHelper implements IPreferencesHelper {

    private final static String PREF_FILE = "PREF";

    private final SharedPreferences mSharedPreferences;

    @Inject
    public PreferencesHelper(@ApplicationContext Context context) {
        mSharedPreferences = context.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
    }

    public void setSharedPreferenceString(String key, String value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public void setSharedPreferenceInt(String key, int value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public void setSharedPreferenceBoolean(String key, boolean value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public String getSharedPreferenceString(String key, String defValue) {
        return mSharedPreferences.getString(key, defValue);
    }

    public int getSharedPreferenceInt(String key, int defValue) {
        return mSharedPreferences.getInt(key, defValue);
    }

    public boolean getSharedPreferenceBoolean(String key, boolean defValue) {
        return mSharedPreferences.getBoolean(key, defValue);
    }

    @Override
    public void setRememberMe(boolean isRememberMeOn) {
        setSharedPreferenceBoolean(Keys.REMEMBER_ME, isRememberMeOn);
    }

    @Override
    public boolean isRememberMeOn() {
        return getSharedPreferenceBoolean(Keys.REMEMBER_ME, false);
    }

    @Override
    public void setUsername(String username) {
        setSharedPreferenceString(Keys.USERNAME, username);
    }

    @Override
    public String getUsername() {
        return getSharedPreferenceString(Keys.USERNAME, "");
    }

    @Override
    public void setPassword(String password) {
        setSharedPreferenceString(Keys.PASSWORD, password);
    }

    @Override
    public String getPassword() {
        return getSharedPreferenceString(Keys.PASSWORD, "");
    }

    public class Keys {

        public static final String REMEMBER_ME = "REMEMBER_ME";

        public static final String USERNAME = "USERNAME";

        public static final String PASSWORD = "PASSWORD";
    }

}
