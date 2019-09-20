package com.serkancay.marketim.ui.login;

/**
 * Created by S.Serkan Cay on 20.09.2019
 */

public class LoginPresenter {

    private LoginView mView;

    public LoginPresenter(LoginView view) {
        mView = view;
    }

    public void onDestroy() {
        mView = null;
    }

}
