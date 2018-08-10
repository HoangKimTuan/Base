package com.tuanhk.ui.photo.like;

import com.tuanhk.data.DataManager;
import com.tuanhk.data.db.model.PhotoDb;
import com.tuanhk.ui.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import rx.Observer;

/**
 * Created by cpu10225 on 24/11/2017.
 */

public class PhotoLikePresenter<V extends PhotoLikeMvpView> extends BasePresenter<V> implements PhotoLikeMvpPresenter<V> {

    @Inject
    public PhotoLikePresenter(DataManager mDataManager) {
        super(mDataManager);
    }


    @Override
    public void getPhotoList() {
        getDataManager().getAllPhoto().subscribe(new Observer<List<PhotoDb>>() {
            @Override
            public void onCompleted() {
                getMvpView().showComplete();
            }

            @Override
            public void onError(Throwable e) {
                getMvpView().showError(e.getMessage());
            }

            @Override
            public void onNext(List<PhotoDb> photoDbs) {
                getMvpView().showPhotoLike(photoDbs);
            }
        });
    }

    @Override
    public void removePhoto(Long id) {
        getDataManager().removePhoto(id);
    }
}
