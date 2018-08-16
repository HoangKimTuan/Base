package com.tuanhk.data.api.mapper;

import com.tuanhk.data.cache.model.PostRecent;
import com.tuanhk.data.api.entity.Post;

import javax.inject.Inject;

public class PlatformDaoMapper {
    @Inject
    public PlatformDaoMapper() {
    }

    public PostRecent transform(Post post) {
        PostRecent postRecent = null;
        if (post != null) {
            postRecent = new PostRecent();
            postRecent.id = (post.getId());
            postRecent.title = (post.getTitle());
            postRecent.body = (post.getBody());
        }
        return postRecent;
    }

    public Post transform(PostRecent postRecent) {
        Post post = null;
        if (postRecent != null) {
            post = new Post((int) postRecent.getId(), postRecent.getTitle(), postRecent.getBody());
        }
        return post;
    }
}
