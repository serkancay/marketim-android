package com.serkancay.marketim.ui.splash;

import android.os.Handler;

/**
 * Created by S.Serkan Cay on 19.09.2019
 */

public class SplashPresenter {

    private static final int SPLASH_DELAY_TIME = 2000;

    private SplashView mView;

    public SplashPresenter(SplashView view) {
        mView = view;
    }

    public void onResume() {
        navigateToHomeWithDelay();
    }

    public void onDestroy() {
        mView = null;
    }

    public void navigateToHomeWithDelay() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mView.navigateToHome();
            }
        }, SPLASH_DELAY_TIME);
    }

}
