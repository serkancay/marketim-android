package com.serkancay.marketim.ui.orders;

import com.serkancay.marketim.data.IDataManager;
import com.serkancay.marketim.data.network.model.Order;
import com.serkancay.marketim.ui.base.BasePresenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by S.Serkan Cay on 22.09.2019
 */

public class OrdersPresenter<V extends OrdersView> extends BasePresenter<V> implements IOrdersPresenter {

    @Inject
    public OrdersPresenter(final IDataManager dataManager,
            final CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void onAttach(final V view) {
        super.onAttach(view);
        getOrdersData();
    }

    @Override
    public void onLogoutButtonClick() {
        getView().showConfirmLogoutDialog();
    }

    @Override
    public void doLogout() {
        getDataManager().setPassword("");
        getDataManager().setUsername("");
        getDataManager().setRememberMe(false);
        getView().navigateToLoginScreen();
    }

    @Override
    public void onMyOrdersButtonClick() {
        getOrdersData();
    }

    private void getOrdersData() {
        getView().showLoading();
        getCompositeDisposable().add(getDataManager().getOrdersApiCall().subscribeOn(Schedulers.io()).observeOn(
                AndroidSchedulers.mainThread()).subscribe(new Consumer<List<Order>>() {
            @Override
            public void accept(final List<Order> orderList) throws Exception {
                getView().hideLoading();
                getView().updateOrders(orderList);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(final Throwable throwable) throws Exception {
                getView().hideLoading();
                getView().showError();
            }
        }));
    }
}
