package com.serkancay.marketim.data.network;

import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.serkancay.marketim.data.network.model.response.OrdersResponse;
import io.reactivex.Single;
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
    public Single<OrdersResponse> getOrdersApiCall() {
        return Rx2AndroidNetworking.get(ApiEndpoint.ENDPOINT_ORDERS)
                .build()
                .getObjectSingle(OrdersResponse.class);
    }
}
