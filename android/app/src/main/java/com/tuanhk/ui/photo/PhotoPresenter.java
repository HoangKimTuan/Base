package com.tuanhk.ui.photo;

import com.tuanhk.data.DataManager;
import com.tuanhk.data.db.model.PhotoDb;
import com.tuanhk.data.network.model.Photo;
import com.tuanhk.ui.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import rx.Observer;

/**
 * Created by cpu10225 on 24/11/2017.
 */

public class PhotoPresenter<V extends PhotoMvpView> extends BasePresenter<V> implements PhotoMvpPresenter<V> {

    @Inject
    public PhotoPresenter(DataManager mDataManager) {
        super(mDataManager);
    }

    @Override
    public void loadPhoto(Integer photoId) {
        getDataManager().getPhotoList(photoId).subscribe(new Observer<List<Photo>>() {
            @Override
            public void onCompleted() {
                getMvpView().showComplete();
            }

            @Override
            public void onError(Throwable e) {
                getMvpView().showError(e.getMessage());
            }

            @Override
            public void onNext(List<Photo> photos) {
                getMvpView().showPhoto(photos);
            }
        });
    }

    @Override
    public void insertPhoto(PhotoDb photoDb) {
        getDataManager().insertPhoto(photoDb);
    }
}
