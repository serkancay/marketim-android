package com.serkancay.marketim.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import butterknife.ButterKnife;
import com.serkancay.marketim.App;
import com.serkancay.marketim.ui.base.FragmentNavigation.Presenter;

/**
 * Created by S.Serkan Cay on 15.05.2019
 */

public class BaseFragment extends Fragment implements FragmentNavigation.View {

    private ViewGroup vgContainer;

    public Context context;

    public BaseActivity activity;

    protected FragmentNavigation.Presenter mNavigationPresenter;

    public int getLayoutId() {
        return -1;
    }

    public void onCreated(Bundle bundle) {
    }

    public void onResumed() {
    }

    public void onPaused() {
    }

    public void onDestroyed() {
    }

    public void bindEvents() {

    }

    public FragmentNavigation.Presenter getNavigationPresenter() {
        return mNavigationPresenter;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container,
            @Nullable final Bundle savedInstanceState) {
        activity = (BaseActivity) getActivity();
        context = activity;
        if (getLayoutId() != -1) {
            vgContainer = (ViewGroup) inflater.inflate(getLayoutId(), null);
            ButterKnife.bind(this, vgContainer);
        }
        onCreated(savedInstanceState);
        bindEvents();
        return vgContainer;
    }

    @Override
    public void onResume() {
        super.onResume();
        onResumed();
    }

    @Override
    public void onPause() {
        super.onPause();
        onPaused();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        onDestroyed();
    }

    @Override
    public void attachPresenter(final Presenter presenter) {
        mNavigationPresenter = presenter;
    }

    public void replaceFragment(View view, Fragment fragment, boolean addToBackStack) {
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        ft.replace(view.getId(), fragment, fragment.getClass().getSimpleName());
        if (addToBackStack) {
            ft.addToBackStack(fragment.getClass().getSimpleName());
        }
        ft.commit();
    }

    public App getApp() {
        return (App) activity.getApplication();
    }

}
