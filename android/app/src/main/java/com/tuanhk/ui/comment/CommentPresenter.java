package com.tuanhk.ui.comment;

import com.tuanhk.data.DataManager;
import com.tuanhk.data.network.model.Comment;
import com.tuanhk.ui.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import rx.Observer;

/**
 * Created by cpu10225 on 17/11/2017.
 */

public class CommentPresenter<V extends CommentMvpView> extends BasePresenter<V> implements CommentMvpPresenter<V> {
    @Inject
    public CommentPresenter(DataManager mDataManager) {
        super(mDataManager);
    }

    @Override
    public void loadComment(Integer postId) {
        getDataManager().getCommentList(postId).subscribe(new Observer<List<Comment>>() {
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
                getMvpView().showComment(comments);
            }
        });
    }

    @Override
    public void insertComment(com.tuanhk.data.db.model.Comment comment) {
        getDataManager().insertComment(comment);
    }
}
