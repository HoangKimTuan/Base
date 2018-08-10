package com.tuanhk.ui.main;

import com.tuanhk.data.DataManager;
import com.tuanhk.data.network.model.Album;
import com.tuanhk.data.network.model.Post;
import com.tuanhk.ui.base.BasePresenter;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

import rx.Observer;

/**
 * Created by cpu10225 on 14/11/2017.
 */

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {
    @Inject
    public MainPresenter(DataManager mDataManager) {
        super(mDataManager);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }

    @Override
    public void loadPost() {
        getDataManager().getPostList().subscribe(new Observer<List<Post>>() {
            @Override
            public void onCompleted() {
                getMvpView().showComplete();
            }

            @Override
            public void onError(Throwable e) {
                getMvpView().showError(e.getMessage());
            }

            @Override
            public void onNext(List<Post> posts) {
                getMvpView().showPost(posts);
            }
        });
    }

    @Override
    public void clickPost(Integer id) {
        EventBus.getDefault().postSticky(id);
    }

    @Override
    public void loadAlbum() {
        getDataManager().getAlbumList().subscribe(new Observer<List<Album>>() {
            @Override
            public void onCompleted() {
                getMvpView().showComplete();
            }

            @Override
            public void onError(Throwable e) {
                getMvpView().showError(e.getMessage());
            }

            @Override
            public void onNext(List<Album> albums) {
                getMvpView().showAlbum(albums);
            }
        });
    }

    @Override
    public void clickAlbum(Integer id) {
        EventBus.getDefault().postSticky(id);
    }
}
