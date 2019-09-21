package com.serkancay.marketim.ui.base;

/**
 * Created by S.Serkan Cay on 21.09.2019
 */

public class BasePresenter<V extends View> implements Presenter<V> {

    private V mView;

    @Override
    public void onAttach(V view) {
        mView = view;
    }

    @Override
    public void onDetach() {
        mView = null;
    }

    public V getView() {
        return mView;
    }

}
