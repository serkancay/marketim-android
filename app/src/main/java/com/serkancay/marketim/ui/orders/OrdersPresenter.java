package com.serkancay.marketim.ui.orders;

import com.serkancay.marketim.data.IDataManager;
import com.serkancay.marketim.ui.base.BasePresenter;
import io.reactivex.disposables.CompositeDisposable;
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
    }
}
