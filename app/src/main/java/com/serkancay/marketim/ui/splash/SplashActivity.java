package com.serkancay.marketim.ui.splash;

import com.serkancay.marketim.MainActivity;
import com.serkancay.marketim.ui.base.BaseActivity;

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
    }

    @Override
    public void showError() {

    }
}
