package com.tuanhk.data.db.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by cpu10225 on 24/11/2017.
 */

@Entity(nameInDb = "photo")
public class PhotoDb {
    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb = "title")
    private String title;
    @Property(nameInDb = "url")
    private String url;
    @Generated(hash = 2034164897)
    public PhotoDb(Long id, String title, String url) {
        this.id = id;
        this.title = title;
        this.url = url;
    }
    @Generated(hash = 2069831311)
    public PhotoDb() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
