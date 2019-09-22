package com.serkancay.marketim.ui.orders;

import com.serkancay.marketim.data.network.model.Order;
import com.serkancay.marketim.ui.base.View;
import java.util.List;

/**
 * Created by S.Serkan Cay on 22.09.2019
 */

public interface OrdersView extends View {

    void showLoading();

    void hideLoading();

    void showError();

    void updateOrders(List<Order> orders);

}
