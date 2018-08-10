package com.tuanhk.data.db.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by cpu10225 on 20/11/2017.
 */

@Entity(nameInDb = "comment")
public class Comment {
    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb = "name")
    private String name;
    @Property(nameInDb = "email")
    private String email;
    @Property(nameInDb = "body")
    private String body;
    @Generated(hash = 1085202829)
    public Comment(Long id, String name, String email, String body) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }
    @Generated(hash = 1669165771)
    public Comment() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getBody() {
        return this.body;
    }
    public void setBody(String body) {
        this.body = body;
    }
}
