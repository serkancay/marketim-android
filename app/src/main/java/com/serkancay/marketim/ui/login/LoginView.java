package com.serkancay.marketim.ui.login;

/**
 * Created by S.Serkan Cay on 20.09.2019
 */

public interface LoginView {

    void showUsernameValidateError(int message);

    void showPasswordValidateError(int message);

    void clearValidateErrors();

    void showLoginFailedError(int message);

    void navigateToHome();

}
