package com.serkancay.marketim.ui.splash;

import com.serkancay.marketim.ui.orders.OrdersActivity;
import com.serkancay.marketim.ui.base.BaseActivity;
import com.serkancay.marketim.ui.login.LoginActivity;
import javax.inject.Inject;

/**
 * Created by S.Serkan Cay on 19.09.2019
 */

public class SplashActivity extends BaseActivity implements SplashView {

    @Inject
    public SplashPresenter<SplashView> mPresenter;

    @Override
    public void onCreated() {
        getActivityComponent().inject(this);
        mPresenter.onAttach(this);
    }

    @Override
    public void onDestroyed() {
        mPresenter.onDetach();
    }

    @Override
    public void navigateToHome() {
        OrdersActivity.start(context);
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
