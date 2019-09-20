package com.serkancay.marketim;

import android.app.Application;
import com.serkancay.marketim.data.preferences.PreferencesHelper;

/**
 * Created by S.Serkan Cay on 19.09.2019
 */

public class App extends Application {

    private PreferencesHelper mPreferencesHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        mPreferencesHelper = new PreferencesHelper(getApplicationContext());
    }

    public PreferencesHelper getPreferencesHelper() {
        return mPreferencesHelper;
    }
}
