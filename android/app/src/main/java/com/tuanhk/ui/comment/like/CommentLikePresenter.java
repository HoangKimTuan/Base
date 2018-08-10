package com.tuanhk.ui.comment.like;

import com.tuanhk.data.DataManager;
import com.tuanhk.data.db.model.Comment;
import com.tuanhk.ui.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import rx.Observer;

/**
 * Created by cpu10225 on 21/11/2017.
 */

public class CommentLikePresenter<V extends CommentLikeMvpView> extends BasePresenter<V> implements CommentLikeMvpPresenter<V> {
    @Inject
    public CommentLikePresenter(DataManager mDataManager) {
        super(mDataManager);
    }

    @Override
    public void getCommentList() {
        getDataManager().getAllComment().subscribe(new Observer<List<Comment>>() {
            @Override
            public void onCompleted() {
                getMvpView().showComplete();
            }

            @Override
            public void onError(Throwable e) {
                getMvpView().showError(e.getMessage());
            }

            @Override
            public void onNext(List<Comment> comments) {
                getMvpView().showCommentLike(comments);
            }
        });
    }

    @Override
    public void removeComment(Long id) {
        getDataManager().removeComment(id);
    }
}
