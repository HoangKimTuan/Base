package com.tuanhk.data.cache;

import com.tuanhk.data.api.entity.Post;
import com.tuanhk.internal.Constants;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface AppStore {

    interface LocalStorage {

        void put(Post post);

        Post get(long id);
    }

    interface RequestService {
        @GET(Constants.REQUEST_API.ENDPOINT_GET_POSTS)
        Observable<List<Post>> getPostList();

//        @GET(Constants.REQUEST_API.ENDPOINT_GET_COMMENTS)
//        Observable<List<Comment>> getCommentList(@Path("id") Integer postId);
    }

    interface Repository {
        Observable<List<Post>> getPostList();
//        Observable<List<Comment>> getCommentList(@Path("id") Integer postId);
    }
}
