package com.tuanhk.data.network;

import com.tuanhk.data.network.model.Album;
import com.tuanhk.data.network.model.Comment;
import com.tuanhk.data.network.model.Photo;
import com.tuanhk.data.network.model.Post;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Retrofit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by cpu10225 on 20/11/2017.
 */

@Singleton
public class AppApiHelper implements ApiHelper {
    private final Retrofit mRetrofit;

    @Inject
    public AppApiHelper(Retrofit mRetrofit) {
        this.mRetrofit = mRetrofit;
    }

    @Override
    public Observable<List<Post>> getPostList() {
        return mRetrofit.create(ApiHelper.class).getPostList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io());
    }

    @Override
    public Observable<List<Comment>> getCommentList(Integer postId) {
        return mRetrofit.create(ApiHelper.class).getCommentList(postId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io());
    }

    @Override
    public Observable<List<Album>> getAlbumList() {
        return mRetrofit.create(ApiHelper.class).getAlbumList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io());
    }

    @Override
    public Observable<List<Photo>> getPhotoList(Integer albumId) {
        return mRetrofit.create(ApiHelper.class).getPhotoList(albumId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io());
    }
}
