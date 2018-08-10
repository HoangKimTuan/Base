package com.tuanhk.ui.comment.like;

import com.tuanhk.ui.base.BaseMvpPresenter;

/**
 * Created by cpu10225 on 21/11/2017.
 */

public interface CommentLikeMvpPresenter<V extends CommentLikeMvpView> extends BaseMvpPresenter<V> {
    void getCommentList();
    void removeComment(Long id);
}
