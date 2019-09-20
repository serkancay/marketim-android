package com.serkancay.marketim.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.ButterKnife;
import com.serkancay.marketim.App;

/**
 * Created by S.Serkan Cay on 15.05.2019
 */

public class BaseActivity extends AppCompatActivity {

    public Context context;

    public BaseActivity activity;

    public int getLayoutId() {
        return -1;
    }

    public void bindEvents() {
    }

    public void onCreated() {
    }

    public void onResumed() {
    }

    public void onPaused() {
    }

    public void onDestroyed() {
    }

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        activity = this;

        if (getLayoutId() != -1) {
            setContentView(getLayoutId());
            ButterKnife.bind(this);
        }

        onCreated();
        bindEvents();
    }

    @Override
    protected void onResume() {
        super.onResume();
        onResumed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        onPaused();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onDestroyed();
    }

    public void replaceFragment(View view, Fragment fragment, boolean addToBackStack) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(view.getId(), fragment, fragment.getClass().getSimpleName());
        if (addToBackStack) {
            ft.addToBackStack(fragment.getClass().getSimpleName());
        }
        ft.commit();
    }

    public void removeFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.remove(fragment);
        if (addToBackStack) {
            ft.addToBackStack(fragment.getClass().getSimpleName());
        }
        ft.commit();
    }

    public void clearBackStack() {
        getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    public App getApp() {
        return (App) activity.getApplication();
    }
}
