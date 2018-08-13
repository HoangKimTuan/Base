package com.tuanhk.internal;

public interface Constants {

    String PREF_AUTO_LOGIN = "pref_auto_login";

    public interface REQUEST_API {
        public static final String ENDPOINT_GET_POSTS = "/posts";
        public static final String ENDPOINT_GET_COMMENTS = ENDPOINT_GET_POSTS + "/{id}/comments";
        public static final String ENDPOINT_GET_ALBUMS = "/albums";
        public static final String ENDPOINT_GET_PHOTOS = ENDPOINT_GET_ALBUMS + "/{id}/photos";
    }
}
