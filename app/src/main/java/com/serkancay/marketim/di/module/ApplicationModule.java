package com.serkancay.marketim.di.module;

import android.app.Application;
import android.content.Context;
import com.serkancay.marketim.di.ApplicationContext;
import dagger.Module;
import dagger.Provides;

/**
 * Created by S.Serkan Cay on 21.09.2019
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

}
