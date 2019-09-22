package com.serkancay.marketim.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by S.Serkan Cay on 22.09.2019
 */

public class Order {

    @Expose
    @SerializedName("date")
    private String mDate;

    @Expose
    @SerializedName("month")
    private String mMonth;

    @Expose
    @SerializedName("marketName")
    private String mMarketName;

    @Expose
    @SerializedName("orderName")
    private String mOrderName;

    @Expose
    @SerializedName("productPrice")
    private double mProductPrice;

    @Expose
    @SerializedName("productState")
    private String mProductState;

    @Expose
    @SerializedName("productDetail")
    private ProductDetail mProductDetail;

    public String getDate() {
        return mDate;
    }

    public String getMonth() {
        return mMonth;
    }

    public String getMarketName() {
        return mMarketName;
    }

    public String getOrderName() {
        return mOrderName;
    }

    public double getProductPrice() {
        return mProductPrice;
    }

    public String getProductState() {
        return mProductState;
    }

    public ProductDetail getProductDetail() {
        return mProductDetail;
    }
}
