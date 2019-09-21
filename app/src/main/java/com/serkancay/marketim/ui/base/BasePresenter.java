package com.serkancay.marketim.ui.base;

import com.serkancay.marketim.data.IDataManager;
import javax.inject.Inject;

/**
 * Created by S.Serkan Cay on 21.09.2019
 */

public class BasePresenter<V extends View> implements Presenter<V> {

    private V mView;

    private final IDataManager mDataManager;

    @Inject
    public BasePresenter(IDataManager dataManager) {
        mDataManager = dataManager;
    }

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

    public IDataManager getDataManager() {
        return mDataManager;
    }
}
