package com.tuanhk.home.calls;

import com.tuanhk.data.cache.AppStore;
import com.tuanhk.data.api.entity.Post;
import com.tuanhk.internal.Constants;
import com.tuanhk.ui.presenter.AbstractPresenter;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class CallsPresenter extends AbstractPresenter<ICallsView> {

    private AppStore.Repository mAppStoreRepository;
    private AppStore.LocalStorage mAppLocalStorage;

    @Inject
    CallsPresenter(AppStore.Repository appStoreRepository, AppStore.LocalStorage localStorage) {
        this.mAppStoreRepository = appStoreRepository;
        this.mAppLocalStorage = localStorage;
    }

    public void listBankSupport() {
        mAppStoreRepository.getPostList()
                .flatMap(Observable::from)
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
