package com.serkancay.marketim.data;

import android.content.Context;
import com.serkancay.marketim.data.network.IApiHelper;
import com.serkancay.marketim.data.network.model.response.OrdersResponse;
import com.serkancay.marketim.data.preferences.IPreferencesHelper;
import com.serkancay.marketim.di.ApplicationContext;
import com.serkancay.marketim.util.keystore.CryptorUtil;
import io.reactivex.Single;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by S.Serkan Cay on 21.09.2019
 */

@Singleton
public class DataManager implements IDataManager {

    private final Context mContext;

    private final IPreferencesHelper mPreferencesHelper;

    private final IApiHelper mApiHelper;

    @Inject
    public DataManager(@ApplicationContext Context context, IPreferencesHelper preferencesHelper,
            IApiHelper apiHelper) {
        mContext = context;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
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

    @Override
    public Single<OrdersResponse> getOrdersApiCall() {
        return mApiHelper.getOrdersApiCall();
    }
}
