package com.serkancay.marketim.ui.base;

/**
 * Created by S.Serkan Cay on 21.09.2019
 */

public interface Presenter<V extends View> {

    public void onAttach(V view);

    public void onDetach();

}
