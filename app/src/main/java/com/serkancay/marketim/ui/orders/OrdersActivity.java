package com.serkancay.marketim.ui.orders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.serkancay.marketim.R;
import com.serkancay.marketim.ui.base.BaseActivity;

public class OrdersActivity extends BaseActivity {

    public static void start(Context context) {
        context.startActivity(new Intent(context, OrdersActivity.class));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_orders;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
    }
}
