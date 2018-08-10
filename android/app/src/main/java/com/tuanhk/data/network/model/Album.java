package com.tuanhk.data.network.model;

/**
 * Created by cpu10225 on 24/11/2017.
 */

public class Album {
    private final Integer userId;
    private final Integer id;
    private final String title;

    public Album(Integer userId, Integer id, String title) {
        this.userId = userId;
        this.id = id;
        this.title = title;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    @Override
    public String toString() {
        return getTitle();
    }
}
