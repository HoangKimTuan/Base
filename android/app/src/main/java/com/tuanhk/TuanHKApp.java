package com.tuanhk;

import android.app.Application;

import com.tuanhk.di.component.ApplicationComponent;
import com.tuanhk.di.component.DaggerUserComponent;
import com.tuanhk.di.component.UserComponent;
import com.tuanhk.di.module.UserModule;

/**
 * Created by cpu10225 on 14/11/2017.
 */

public class TuanHKApp extends Application {
    private static TuanHKApp _instance;
    private ApplicationComponent mApplicationComponent;
    private UserComponent mUserComponent;

    public static TuanHKApp instance() {
        return _instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        _instance = this;
        mApplicationComponent = ApplicationComponent.create(this);
        mApplicationComponent.inject(this);

        mUserComponent = DaggerUserComponent.builder()
                .userModule(new UserModule())
                .applicationComponent(mApplicationComponent)
                .build();
    }

    public ApplicationComponent getAppComponent() {
        return mApplicationComponent;
    }

    public UserComponent getUserComponent() {
        return mUserComponent;
    }
}
