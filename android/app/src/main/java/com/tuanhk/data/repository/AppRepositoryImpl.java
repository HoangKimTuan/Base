package com.tuanhk.data.repository;

import com.tuanhk.data.cache.AppStore;
import com.tuanhk.data.api.entity.Post;

import java.util.List;

import io.reactivex.Observable;

public class AppRepositoryImpl implements AppStore.Repository {

    private final AppStore.RequestService mRequestService;

    public AppRepositoryImpl(AppStore.RequestService requestService) {
        mRequestService = requestService;
    }

    @Override
    public Observable<List<Post>> getPostList() {
        return mRequestService.getPostList();
    }

}
