package com.serkancay.marketim.ui.orders;

import com.serkancay.marketim.di.PerActivity;

/**
 * Created by S.Serkan Cay on 22.09.2019
 */

@PerActivity
public interface IOrdersPresenter<V extends OrdersView> {

    void onLogoutButtonClick();

    void doLogout();

}
