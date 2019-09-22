package com.serkancay.marketim.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by S.Serkan Cay on 22.09.2019
 */

public class ProductDetail {

    @Expose
    @SerializedName("orderDetail")
    private String mOrderDetail;

    @Expose
    @SerializedName("summaryPrice")
    private double mSummaryPrice;

    public String getOrderDetail() {
        return mOrderDetail;
    }

    public double getSummaryPrice() {
        return mSummaryPrice;
    }
}
