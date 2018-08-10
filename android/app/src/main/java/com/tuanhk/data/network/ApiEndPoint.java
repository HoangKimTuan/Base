package com.tuanhk.data.network;

import com.tuanhk.BuildConfig;

/**
 * Created by cpu10225 on 20/11/2017.
 */

public final class ApiEndPoint {
    public static final String ENDPOINT_GET_POSTS = "/posts";
    public static final String ENDPOINT_GET_COMMENTS = ENDPOINT_GET_POSTS + "/{id}/comments";
    public static final String ENDPOINT_GET_ALBUMS = "/albums";
    public static final String ENDPOINT_GET_PHOTOS = ENDPOINT_GET_ALBUMS + "/{id}/photos";

    private ApiEndPoint() {}
}
