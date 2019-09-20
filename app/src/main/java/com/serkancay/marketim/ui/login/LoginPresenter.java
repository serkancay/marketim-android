package com.serkancay.marketim.ui.login;

import android.text.TextUtils;
import com.serkancay.marketim.R;

/**
 * Created by S.Serkan Cay on 20.09.2019
 */

public class LoginPresenter {

    private LoginView mView;

    private String mUsername;

    private String mPassword;

    private boolean mIsRememberMeOn;

    public LoginPresenter(LoginView view) {
        mView = view;
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
            // TODO login in to app
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
