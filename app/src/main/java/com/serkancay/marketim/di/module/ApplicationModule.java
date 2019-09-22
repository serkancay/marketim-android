package com.serkancay.marketim.di.module;

import android.app.Application;
import android.content.Context;
import com.serkancay.marketim.data.DataManager;
import com.serkancay.marketim.data.IDataManager;
import com.serkancay.marketim.data.network.ApiHelper;
import com.serkancay.marketim.data.network.IApiHelper;
import com.serkancay.marketim.data.preferences.IPreferencesHelper;
import com.serkancay.marketim.data.preferences.PreferencesHelper;
import com.serkancay.marketim.di.ApplicationContext;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

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

    @Provides
    @Singleton
    IDataManager provideDataManager(DataManager dataManager) {
        return dataManager;
    }

    @Provides
    @Singleton
    IPreferencesHelper providePreferencesHelper(PreferencesHelper preferencesHelper) {
        return preferencesHelper;
    }

    @Provides
    @Singleton
    IApiHelper provideApiHelper(ApiHelper apiHelper) {
        return apiHelper;
    }
}
