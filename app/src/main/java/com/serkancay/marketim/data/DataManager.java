package com.serkancay.marketim.data;

import android.content.Context;
import com.serkancay.marketim.data.preferences.IPreferencesHelper;
import com.serkancay.marketim.di.ApplicationContext;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by S.Serkan Cay on 21.09.2019
 */

@Singleton
public class DataManager implements IDataManager{

    private final IPreferencesHelper mPreferencesHelper;

    @Inject
    public DataManager(@ApplicationContext Context context, IPreferencesHelper preferencesHelper) {
        mPreferencesHelper = preferencesHelper;
    }

    public void setUsername(String username) {
        mPreferencesHelper.setUsername(username);
    }

    public String getUsername() {
        return mPreferencesHelper.getUsername();
    }

    public void setPassword(String password) {
        mPreferencesHelper.setPassword(password);
    }

    public String getPassword() {
        return mPreferencesHelper.getPassword();
    }

    public void setRememberMe(boolean isRememberMeOn) {
        mPreferencesHelper.setRememberMe(isRememberMeOn);
    }

    public boolean isRememberMeOn() {
        return mPreferencesHelper.isRememberMeOn();
    }

}
