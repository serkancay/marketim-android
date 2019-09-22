package com.serkancay.marketim.di.component;

import com.serkancay.marketim.di.PerActivity;
import com.serkancay.marketim.di.module.ActivityModule;
import com.serkancay.marketim.ui.login.LoginActivity;
import com.serkancay.marketim.ui.orders.OrdersActivity;
import com.serkancay.marketim.ui.splash.SplashActivity;
import dagger.Component;

/**
 * Created by S.Serkan Cay on 21.09.2019
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(LoginActivity activity);

    void inject(SplashActivity activity);

    void inject(OrdersActivity activity);

}
