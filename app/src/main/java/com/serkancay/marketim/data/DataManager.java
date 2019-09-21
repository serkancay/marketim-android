package com.serkancay.marketim.data;

import android.content.Context;
import com.serkancay.marketim.data.preferences.IPreferencesHelper;
import com.serkancay.marketim.di.ApplicationContext;
import com.serkancay.marketim.util.keystore.CryptorUtil;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by S.Serkan Cay on 21.09.2019
 */

@Singleton
public class DataManager implements IDataManager {

    private final Context mContext;

    private final IPreferencesHelper mPreferencesHelper;

    @Inject
    public DataManager(@ApplicationContext Context context, IPreferencesHelper preferencesHelper) {
        mContext = context;
        mPreferencesHelper = preferencesHelper;
    }

    /**
     * Encrypts username and saves
     */
    public void setUsername(String username) {
        String encryptedUsername = CryptorUtil.encrypt(mContext, username);
        mPreferencesHelper.setUsername(encryptedUsername);
    }

    /**
     * Returns decrypted username
     */
    public String getUsername() {
        String username = mPreferencesHelper.getUsername();
        String encryptedUsername = CryptorUtil.decrypt(mContext, username);
        return encryptedUsername;
    }

    /**
     * Encrypts password and saves
     */
    public void setPassword(String password) {
        String encryptedPassword = CryptorUtil.encrypt(mContext, password);
        mPreferencesHelper.setPassword(encryptedPassword);
    }

    /**
     * Returns decrypted password
     */
    public String getPassword() {
        String password = mPreferencesHelper.getPassword();
        String encryptedPassword = CryptorUtil.decrypt(mContext, password);
        return encryptedPassword;
    }

    public void setRememberMe(boolean isRememberMeOn) {
        mPreferencesHelper.setRememberMe(isRememberMeOn);
    }

    public boolean isRememberMeOn() {
        return mPreferencesHelper.isRememberMeOn();
    }

}
