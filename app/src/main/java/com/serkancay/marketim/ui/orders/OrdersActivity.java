package com.serkancay.marketim.ui.orders;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.serkancay.marketim.R;
import com.serkancay.marketim.data.network.model.Order;
import com.serkancay.marketim.ui.base.BaseActivity;
import java.util.List;
import javax.inject.Inject;

public class OrdersActivity extends BaseActivity implements OrdersView {

    public static void start(Context context) {
        context.startActivity(new Intent(context, OrdersActivity.class));
    }

    @BindView(R.id.llRoot)
    LinearLayout llRoot;

    @BindView(R.id.rvOrders)
    RecyclerView rvOrders;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Inject
    public OrdersPresenter<OrdersView> mPresenter;

    @Inject
    public OrderListAdapter mOrderListAdapter;

    @Inject
    public LinearLayoutManager mLayoutManager;

    @Override
    public int getLayoutId() {
        return R.layout.activity_orders;
    }

    @Override
    public void onCreated() {
        getActivityComponent().inject(this);
        mLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rvOrders.setLayoutManager(mLayoutManager);
        rvOrders.setAdapter(mOrderListAdapter);
        mPresenter.onAttach(this);
    }

    @Override
    public void onDestroyed() {
        mPresenter.onDetach();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
        rvOrders.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
        rvOrders.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError() {
        Snackbar.make(llRoot, getString(R.string.ui_orders_error_text), BaseTransientBottomBar.LENGTH_SHORT)
                .setBackgroundTint(getResources().getColor(R.color.snackbar_error_bg))
                .setTextColor(getResources().getColor(R.color.dark_text_color)).show();
    }

    @Override
    public void updateOrders(final List<Order> orders) {
        mOrderListAdapter.addItems(orders);
    }
}
