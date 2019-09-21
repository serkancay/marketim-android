package com.serkancay.marketim.ui.splash;

import android.os.Handler;
import android.util.Log;
import com.serkancay.marketim.data.IDataManager;
import com.serkancay.marketim.ui.base.BasePresenter;
import javax.inject.Inject;

/**
 * Created by S.Serkan Cay on 19.09.2019
 */

public class SplashPresenter<V extends SplashView> extends BasePresenter<V> implements ISplashPresenter {

    private static final int SPLASH_DELAY_TIME = 2000;

    @Inject
    public SplashPresenter(IDataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void onAttach(final V view) {
        super.onAttach(view);
        navigateToLoginWithDelay();
    }

    public void navigateToHomeWithDelay() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getView().navigateToHome();
            }
        }, SPLASH_DELAY_TIME);
    }

    public void navigateToLoginWithDelay() {
        Log.d("Username", getDataManager().getUsername());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getView().navigateToLogin();
            }
        }, SPLASH_DELAY_TIME);
    }

}
