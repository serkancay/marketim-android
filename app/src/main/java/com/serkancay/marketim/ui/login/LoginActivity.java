package com.serkancay.marketim.ui.login;

import android.content.Context;
import android.content.Intent;
import com.serkancay.marketim.R;
import com.serkancay.marketim.ui.base.BaseActivity;

/**
 * Created by S.Serkan Cay on 19.09.2019
 */

public class LoginActivity extends BaseActivity {

    public static void start(Context context) {
        context.startActivity(new Intent(context, LoginActivity.class));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

}
