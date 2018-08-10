package com.tuanhk.ui.comment.like;

import com.tuanhk.data.db.model.Comment;
import com.tuanhk.ui.base.BaseMvpView;

import java.util.List;

/**
 * Created by cpu10225 on 21/11/2017.
 */

public interface CommentLikeMvpView extends BaseMvpView {
    void showError(String message);
    void showComplete();
    void showCommentLike(List<Comment> comments);
}
