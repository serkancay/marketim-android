package com.serkancay.marketim.di.component;

import android.app.Application;
import android.content.Context;
import com.serkancay.marketim.App;
import com.serkancay.marketim.di.ApplicationContext;
import com.serkancay.marketim.di.module.ApplicationModule;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by S.Serkan Cay on 21.09.2019
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(App app);

    @ApplicationContext
    public Context context();

    public Application application();

}
