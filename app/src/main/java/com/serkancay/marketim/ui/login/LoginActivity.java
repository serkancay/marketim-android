package com.serkancay.marketim.ui.login;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Switch;
import butterknife.BindView;
import butterknife.OnClick;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.serkancay.marketim.R;
import com.serkancay.marketim.ui.base.BaseActivity;

/**
 * Created by S.Serkan Cay on 19.09.2019
 */

public class LoginActivity extends BaseActivity implements LoginView {

    public static void start(Context context) {
        context.startActivity(new Intent(context, LoginActivity.class));
    }

    @BindView(R.id.tilUsername)
    TextInputLayout tilUsername;

    @BindView(R.id.tilPassword)
    TextInputLayout tilPassword;

    @BindView(R.id.tietUsername)
    TextInputEditText tietUsername;

    @BindView(R.id.tietPassword)
    TextInputEditText tietPassword;

    @BindView(R.id.switchRememberMe)
    Switch switchRememberMe;

    private LoginPresenter mPresenter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void onCreated() {
        mPresenter = new LoginPresenter(this);
    }

    @Override
    public void onDestroyed() {
        mPresenter.onDestroy();
    }

    @OnClick({R.id.bLogin})
    public void onViewClicked(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.bLogin: {
                String username = tietUsername.getText().toString().trim();
                String password = tietPassword.getText().toString().trim();
                boolean isRememberMeOn = switchRememberMe.isChecked();
                mPresenter.onLoginButtonClicked(username, password, isRememberMeOn);
            }
        }
    }

    @Override
    public void showUsernameValidateError(final int message) {
        tilUsername.setError(getString(message));
    }

    @Override
    public void showPasswordValidateError(final int message) {
        tilPassword.setError(getString(message));
    }

    @Override
    public void clearValidateErrors() {
        tilUsername.setError("");
        tilPassword.setError("");
    }
}
