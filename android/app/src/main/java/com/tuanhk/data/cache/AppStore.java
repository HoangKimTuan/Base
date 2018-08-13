package com.tuanhk.data.cache;

import com.tuanhk.data.network.model.Album;
import com.tuanhk.data.network.model.Comment;
import com.tuanhk.data.network.model.Photo;
import com.tuanhk.data.network.model.Post;
import com.tuanhk.internal.Constants;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface AppStore {

    interface RequestService {
        @GET(Constants.REQUEST_API.ENDPOINT_GET_POSTS)
        Observable<List<Post>> getPostList();

        @GET(Constants.REQUEST_API.ENDPOINT_GET_COMMENTS)
        Observable<List<Comment>> getCommentList(@Path("id") Integer postId);

        @GET(Constants.REQUEST_API.ENDPOINT_GET_ALBUMS)
        Observable<List<Album>> getAlbumList();

        @GET(Constants.REQUEST_API.ENDPOINT_GET_PHOTOS)
        Observable<List<Photo>> getPhotoList(@Path("id") Integer albumId);
    }

    interface Repository {
        Observable<List<Post>> getPostList();
        Observable<List<Comment>> getCommentList(@Path("id") Integer postId);
        Observable<List<Album>> getAlbumList();
        Observable<List<Photo>> getPhotoList(@Path("id") Integer albumId);
    }
}
