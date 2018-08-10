package com.tuanhk.ui.main;

import com.tuanhk.ui.base.BaseMvpPresenter;

/**
 * Created by cpu10225 on 17/11/2017.
 */

public interface MainMvpPresenter<V extends MainMvpView> extends BaseMvpPresenter<V> {
    void loadPost();
    void clickPost(Integer id);
    void loadAlbum();
    void clickAlbum(Integer id);
}
