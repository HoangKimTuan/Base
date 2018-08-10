package com.tuanhk.ui.comment;

import com.tuanhk.data.db.model.Comment;
import com.tuanhk.ui.base.BaseMvpPresenter;

/**
 * Created by cpu10225 on 17/11/2017.
 */

public interface CommentMvpPresenter<V extends CommentMvpView> extends BaseMvpPresenter<V> {
    void loadComment(Integer postId);
    void insertComment(Comment comment);
}
