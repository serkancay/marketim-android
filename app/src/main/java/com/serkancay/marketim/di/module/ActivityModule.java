package com.serkancay.marketim.di.module;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.serkancay.marketim.data.network.model.Order;
import com.serkancay.marketim.di.ActivityContext;
import com.serkancay.marketim.di.PerActivity;
import com.serkancay.marketim.ui.login.ILoginPresenter;
import com.serkancay.marketim.ui.login.LoginPresenter;
import com.serkancay.marketim.ui.login.LoginView;
import com.serkancay.marketim.ui.orders.IOrdersPresenter;
import com.serkancay.marketim.ui.orders.OrderListAdapter;
import com.serkancay.marketim.ui.orders.OrdersPresenter;
import com.serkancay.marketim.ui.orders.OrdersView;
import com.serkancay.marketim.ui.splash.ISplashPresenter;
import com.serkancay.marketim.ui.splash.SplashPresenter;
import com.serkancay.marketim.ui.splash.SplashView;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;

/**
 * Created by S.Serkan Cay on 21.09.2019
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        mActivity = activity;
    }

    @Provides
    @ActivityContext
    public Context provideContext() {
        return mActivity;
    }

    @Provides
    public AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    @PerActivity
    public ISplashPresenter<SplashView> provideSplashPresenter(SplashPresenter<SplashView> presenter) {
        return presenter;
    }

    @Provides
    public ILoginPresenter<LoginView> provideLoginPresenter(LoginPresenter<LoginView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    public IOrdersPresenter<OrdersView> provideOrdersPresenter(OrdersPresenter<OrdersView> presenter) {
        return presenter;
    }

    @Provides
    public OrderListAdapter provideOrderListAdapter() {
        return new OrderListAdapter(new ArrayList<Order>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }

}
