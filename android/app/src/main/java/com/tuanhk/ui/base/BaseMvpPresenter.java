package com.tuanhk.ui.base;

/**
 * Created by cpu10225 on 17/11/2017.
 */

public interface BaseMvpPresenter<V extends BaseMvpView> {
    void onAttach(V mvpView);
    void onDetach();
}
