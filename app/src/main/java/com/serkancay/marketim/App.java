package com.serkancay.marketim;

import android.app.Application;
import com.serkancay.marketim.data.preferences.PreferencesHelper;
import com.serkancay.marketim.di.component.ApplicationComponent;
import com.serkancay.marketim.di.component.DaggerApplicationComponent;
import com.serkancay.marketim.di.module.ApplicationModule;

/**
 * Created by S.Serkan Cay on 19.09.2019
 */

public class App extends Application {

    private ApplicationComponent mApplicationComponent;

    private PreferencesHelper mPreferencesHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);

        mPreferencesHelper = new PreferencesHelper(getApplicationContext());
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    public PreferencesHelper getPreferencesHelper() {
        return mPreferencesHelper;
    }
}
