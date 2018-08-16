package com.tuanhk.data.api.entity;

/**
 * Created by cpu10225 on 14/11/2017.
 */

public class Post {
    private final Integer id;
    private final String title;
    private final String body;

    public Post(Integer id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return getTitle();
    }
}
