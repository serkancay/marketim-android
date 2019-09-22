package com.serkancay.marketim.data.network;

import com.serkancay.marketim.data.network.model.Order;
import io.reactivex.Single;
import java.util.List;

/**
 * Created by S.Serkan Cay on 22.09.2019
 */

public interface IApiHelper {

    Single<List<Order>> getOrdersApiCall();

}
