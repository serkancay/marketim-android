package com.serkancay.marketim.ui.base;

import com.serkancay.marketim.data.IDataManager;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Inject;

/**
 * Created by S.Serkan Cay on 21.09.2019
 */

public class BasePresenter<V extends View> implements Presenter<V> {

    private V mView;

    private final IDataManager mDataManager;

    private final CompositeDisposable mCompositeDisposable;

    @Inject
    public BasePresenter(IDataManager dataManager, CompositeDisposable compositeDisposable) {
        mDataManager = dataManager;
        mCompositeDisposable = compositeDisposable;
    }

    @Override
    public void onAttach(V view) {
        mView = view;
    }

    @Override
    public void onDetach() {
        mCompositeDisposable.dispose();
        mView = null;
    }

    public V getView() {
        return mView;
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    public IDataManager getDataManager() {
        return mDataManager;
    }
}
