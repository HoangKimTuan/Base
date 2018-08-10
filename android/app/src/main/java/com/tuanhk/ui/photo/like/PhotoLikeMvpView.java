package com.tuanhk.ui.photo.like;

import com.tuanhk.data.db.model.PhotoDb;
import com.tuanhk.ui.base.BaseMvpView;

import java.util.List;

/**
 * Created by cpu10225 on 24/11/2017.
 */

public interface PhotoLikeMvpView extends BaseMvpView {
    void showError(String message);
    void showComplete();
    void showPhotoLike(List<PhotoDb> photoDbs);
}
