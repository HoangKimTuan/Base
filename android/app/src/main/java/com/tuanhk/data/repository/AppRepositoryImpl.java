package com.tuanhk.data.repository;

import com.tuanhk.data.cache.AppStore;
import com.tuanhk.data.network.model.Album;
import com.tuanhk.data.network.model.Comment;
import com.tuanhk.data.network.model.Photo;
import com.tuanhk.data.network.model.Post;

import java.util.List;

import rx.Observable;

public class AppRepositoryImpl implements AppStore.Repository {

    private final AppStore.RequestService mRequestService;

    public AppRepositoryImpl(AppStore.RequestService requestService) {
        mRequestService = requestService;
    }

    @Override
    public Observable<List<Post>> getPostList() {
        return null;
    }

    @Override
    public Observable<List<Comment>> getCommentList(Integer postId) {
        return null;
    }

    @Override
    public Observable<List<Album>> getAlbumList() {
        return null;
    }

    @Override
    public Observable<List<Photo>> getPhotoList(Integer albumId) {
        return null;
    }
}
