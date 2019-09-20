package com.serkancay.marketim.ui.login;

import android.text.TextUtils;
import com.serkancay.marketim.BuildConfig;
import com.serkancay.marketim.R;
import com.serkancay.marketim.data.preferences.PreferencesHelper;

/**
 * Created by S.Serkan Cay on 20.09.2019
 */

public class LoginPresenter {

    private LoginView mView;

    private PreferencesHelper mPreferencesHelper;

    private String mUsername;

    private String mPassword;

    private boolean mIsRememberMeOn;

    public LoginPresenter(LoginView view, PreferencesHelper preferencesHelper) {
        mView = view;
        mPreferencesHelper = preferencesHelper;
    }

    public void onDestroy() {
        mView = null;
    }

    public void onLoginButtonClicked(String username, String password, boolean isRememberMeOn) {
        mUsername = username;
        mPassword = password;
        mIsRememberMeOn = isRememberMeOn;
        mView.clearValidateErrors();
        if (validate()) {
            if (BuildConfig.DEFAULT_USERNAME.equals(mUsername) && BuildConfig.DEFAULT_PASSWORD.equals(mPassword)) {
                mPreferencesHelper.setRememberMe(mIsRememberMeOn);
                if (mIsRememberMeOn) {
                    // TODO encrypt credentials
                    mPreferencesHelper.setUsername(mUsername);
                    mPreferencesHelper.setPassword(mPassword);
                }
                mView.navigateToHome();
            } else {
                mView.showLoginFailedError(R.string.ui_login_failed_error_text);
            }
        }
    }

    // Validate user inputs
    private boolean validate() {
        if (TextUtils.isEmpty(mUsername)) {
            if (mView != null) {
                mView.showUsernameValidateError(R.string.ui_login_username_edittext_validate);
            }
            return false;
        } else if (TextUtils.isEmpty(mPassword)) {
            if (mView != null) {
                mView.showPasswordValidateError(R.string.ui_login_password_edittext_validate);
            }
            return false;
        }
        return true;
    }

}
