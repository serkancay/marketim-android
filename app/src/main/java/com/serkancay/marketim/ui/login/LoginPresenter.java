package com.serkancay.marketim.ui.login;

import android.text.TextUtils;
import com.serkancay.marketim.BuildConfig;
import com.serkancay.marketim.R;
import com.serkancay.marketim.data.IDataManager;
import com.serkancay.marketim.ui.base.BasePresenter;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Inject;

/**
 * Created by S.Serkan Cay on 20.09.2019
 */

public class LoginPresenter<V extends LoginView> extends BasePresenter<V> implements ILoginPresenter {

    private String mUsername;

    private String mPassword;

    private boolean mIsRememberMeOn;

    @Inject
    public LoginPresenter(IDataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void onAttach(final V view) {
        super.onAttach(view);
    }

    public void onLoginButtonClicked(String username, String password, boolean isRememberMeOn) {
        mUsername = username;
        mPassword = password;
        mIsRememberMeOn = isRememberMeOn;
        getView().clearValidateErrors();
        if (validate()) {
            if (BuildConfig.DEFAULT_USERNAME.equals(mUsername) && BuildConfig.DEFAULT_PASSWORD.equals(mPassword)) {
                getDataManager().setRememberMe(mIsRememberMeOn);
                if (mIsRememberMeOn) {
                    getDataManager().setUsername(mUsername);
                    getDataManager().setPassword(mPassword);
                }
                getView().navigateToHome();
            } else {
                getView().showLoginFailedError(R.string.ui_login_failed_error_text);
            }
        }
    }

    // Validate user inputs
    private boolean validate() {
        if (TextUtils.isEmpty(mUsername)) {
            if (getView() != null) {
                getView().showUsernameValidateError(R.string.ui_login_username_edittext_validate);
            }
            return false;
        } else if (TextUtils.isEmpty(mPassword)) {
            if (getView() != null) {
                getView().showPasswordValidateError(R.string.ui_login_password_edittext_validate);
            }
            return false;
        }
        return true;
    }

}
