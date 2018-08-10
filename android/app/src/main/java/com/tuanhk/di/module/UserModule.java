package com.tuanhk.di.module;

import com.tuanhk.ui.base.BaseMvpView;
import com.tuanhk.ui.comment.CommentMvpPresenter;
import com.tuanhk.ui.comment.CommentMvpView;
import com.tuanhk.ui.comment.CommentPresenter;
import com.tuanhk.ui.comment.like.CommentLikeMvpPresenter;
import com.tuanhk.ui.comment.like.CommentLikeMvpView;
import com.tuanhk.ui.comment.like.CommentLikePresenter;
import com.tuanhk.ui.main.MainMvpPresenter;
import com.tuanhk.ui.main.MainMvpView;
import com.tuanhk.ui.main.MainPresenter;
import com.tuanhk.ui.photo.PhotoMvpPresenter;
import com.tuanhk.ui.photo.PhotoMvpView;
import com.tuanhk.ui.photo.PhotoPresenter;
import com.tuanhk.ui.photo.like.PhotoLikeMvpPresenter;
import com.tuanhk.ui.photo.like.PhotoLikeMvpView;
import com.tuanhk.ui.photo.like.PhotoLikePresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cpu10225 on 14/11/2017.
 */

@Module
public class UserModule {
    private BaseMvpView mView;

    public UserModule(BaseMvpView mView) {
        this.mView = mView;
    }

    @Provides
    BaseMvpView provideBaseMvpView() {
        return mView;
    }

    @Provides
    MainMvpPresenter<MainMvpView> provideMainMvpPresenter(MainPresenter<MainMvpView> presenter)
    {
        return presenter;
    }

    @Provides
    CommentMvpPresenter<CommentMvpView> provideCommentMvpPresenter(CommentPresenter<CommentMvpView> presenter)
    {
        return presenter;
    }

    @Provides
    CommentLikeMvpPresenter<CommentLikeMvpView> provideCommentLikeMvpPresenter(CommentLikePresenter<CommentLikeMvpView> presenter) {
        return presenter;
    }

    @Provides
    PhotoMvpPresenter<PhotoMvpView> providePhotoMvpPresenter(PhotoPresenter<PhotoMvpView> presenter) {
        return presenter;
    }

    @Provides
    PhotoLikeMvpPresenter<PhotoLikeMvpView> providePhotoLikeMvpPresenter(PhotoLikePresenter<PhotoLikeMvpView> presenter) {
        return presenter;
    }
}
