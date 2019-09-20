package com.serkancay.marketim.ui.splash;

import com.serkancay.marketim.MainActivity;
import com.serkancay.marketim.ui.base.BaseActivity;
import com.serkancay.marketim.ui.login.LoginActivity;

/**
 * Created by S.Serkan Cay on 19.09.2019
 */

public class SplashActivity extends BaseActivity implements SplashView {

    private SplashPresenter mPresenter;

    @Override
    public void onCreated() {
        mPresenter = new SplashPresenter(this);
    }

    @Override
    public void onResumed() {
        mPresenter.onResume();
    }

    @Override
    public void onDestroyed() {
        mPresenter.onDestroy();
    }

    @Override
    public void navigateToHome() {
        MainActivity.start(context);
        finish();
    }

    @Override
    public void navigateToLogin() {
        LoginActivity.start(context);
        finish();
    }

    @Override
    public void showError() {

    }
}
