package com.serkancay.marketim.ui.orders;

import android.content.Context;
import android.content.Intent;
import com.serkancay.marketim.R;
import com.serkancay.marketim.data.network.model.Order;
import com.serkancay.marketim.ui.base.BaseActivity;
import java.util.List;
import javax.inject.Inject;

public class OrdersActivity extends BaseActivity implements OrdersView {

    public static void start(Context context) {
        context.startActivity(new Intent(context, OrdersActivity.class));
    }

    @Inject
    public OrdersPresenter<OrdersView> mPresenter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_orders;
    }

    @Override
    public void onCreated() {
        getActivityComponent().inject(this);
        mPresenter.onAttach(this);
    }

    @Override
    public void onDestroyed() {
        mPresenter.onDetach();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void updateOrders(final List<Order> orders) {

    }
}
