package com.serkancay.marketim.data.network;

import com.serkancay.marketim.data.network.model.response.OrdersResponse;
import io.reactivex.Single;

/**
 * Created by S.Serkan Cay on 22.09.2019
 */

public interface IApiHelper {

    Single<OrdersResponse> getOrdersApiCall();

}
