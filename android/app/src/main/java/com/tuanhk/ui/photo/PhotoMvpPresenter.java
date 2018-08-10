package com.tuanhk.ui.photo;

import com.tuanhk.data.db.model.PhotoDb;
import com.tuanhk.ui.base.BaseMvpPresenter;

/**
 * Created by cpu10225 on 24/11/2017.
 */

public interface PhotoMvpPresenter<V extends PhotoMvpView> extends BaseMvpPresenter<V> {
    void loadPhoto(Integer photoId);
    void insertPhoto(PhotoDb photoDb);
}
