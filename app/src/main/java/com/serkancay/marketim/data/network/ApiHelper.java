package com.serkancay.marketim.data.network;

import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.serkancay.marketim.data.network.model.Order;
import io.reactivex.Single;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by S.Serkan Cay on 22.09.2019
 */

@Singleton
public class ApiHelper implements IApiHelper {

    @Inject
    public ApiHelper() {

    }

    @Override
    public Single<List<Order>> getOrdersApiCall() {
        return Rx2AndroidNetworking.get(ApiEndpoint.ENDPOINT_ORDERS)
                .build()
                .getObjectListSingle(Order.class);
    }
}
