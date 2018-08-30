package com.tuanhk.home.calls;

import android.annotation.SuppressLint;

import com.tuanhk.data.cache.AppStore;
import com.tuanhk.data.api.entity.Post;
import com.tuanhk.internal.Constants;
import com.tuanhk.ui.presenter.AbstractPresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class CallsPresenter extends AbstractPresenter<ICallsView> {

    private AppStore.Repository mAppStoreRepository;
    private AppStore.LocalStorage mAppLocalStorage;

    @Inject
    CallsPresenter(AppStore.Repository appStoreRepository, AppStore.LocalStorage localStorage) {
        this.mAppStoreRepository = appStoreRepository;
        this.mAppLocalStorage = localStorage;
    }

    public int a() {
        return 2;
    }

    @SuppressLint("CheckResult")
    public void loadPost() {
        mAppStoreRepository.getPostList()
                .flatMap(Observable::fromIterable)
                .take(Constants.LIMIT_ITEM_LIST)
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::updatePostList);
    }

    private void updatePostList(List<Post> postList) {
        if (mView == null) {
            return;
        }
        mView.addData(postList);
    }

    public void putPost(Post post) {
        mAppLocalStorage.put(post);
    }
}
