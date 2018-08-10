package com.tuanhk.data.network.model;

/**
 * Created by cpu10225 on 24/11/2017.
 */

public class Photo {
    private final int albumId;
    private final int id;
    private final String title;
    private final String url;
    private final String thumbnailUrl;

    public Photo(int albumId, int id, String name, String url, String thumbnailUrl) {
        this.albumId = albumId;
        this.id = id;
        this.title = name;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }

    public int getAlbumId() {
        return albumId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
}
