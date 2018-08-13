package com.tuanhk.di.component;

import com.tuanhk.di.module.UserModule;
import com.tuanhk.ui.comment.CommentActivity;
import com.tuanhk.ui.comment.like.CommentLikeActivity;
import com.tuanhk.ui.main.MainActivity;
import com.tuanhk.ui.photo.PhotoActivity;
import com.tuanhk.ui.photo.like.PhotoLikeActivity;
import com.tuanhk.utils.anotation.CustomScope;

import dagger.Component;

/**
 * Created by cpu10225 on 14/11/2017.
 */

@CustomScope
@Component(dependencies = ApplicationComponent.class, modules = {UserModule.class})
public interface UserComponent {
    void inject(MainActivity mainActivity);
    void inject(CommentActivity commentActivity);
    void inject(CommentLikeActivity commentLikeActivity);
    void inject(PhotoActivity photoActivity);
    void inject(PhotoLikeActivity photoLikeActivity);
}
