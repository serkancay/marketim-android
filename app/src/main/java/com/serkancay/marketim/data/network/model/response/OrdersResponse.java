package com.serkancay.marketim.data.network.model.response;

import com.serkancay.marketim.data.network.model.Order;
import java.util.List;

/**
 * Created by S.Serkan Cay on 22.09.2019
 */

public class OrdersResponse {

    private List<Order> mOrders;

    public List<Order> getOrders() {
        return mOrders;
    }
}
