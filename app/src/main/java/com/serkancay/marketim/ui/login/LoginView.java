package com.serkancay.marketim.ui.login;

import com.serkancay.marketim.ui.base.View;

/**
 * Created by S.Serkan Cay on 20.09.2019
 */

public interface LoginView extends View {

    void showUsernameValidateError(int message);

    void showPasswordValidateError(int message);

    void clearValidateErrors();

    void showLoginFailedError(int message);

    void navigateToHome();

}
