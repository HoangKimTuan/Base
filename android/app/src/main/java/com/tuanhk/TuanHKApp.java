package com.tuanhk;

import android.app.Application;

import com.tuanhk.di.component.ApplicationComponent;
import com.tuanhk.di.component.DaggerApplicationComponent;
import com.tuanhk.di.component.DaggerDemoComponent;
import com.tuanhk.di.component.DemoComponent;
import com.tuanhk.di.module.ApplicationModule;
import com.tuanhk.di.module.DemoModule;

/**
 * Created by cpu10225 on 14/11/2017.
 */

public class TuanHKApp extends Application {
    private static TuanHKApp _instance;
    private ApplicationComponent mApplicationComponent;
    private DemoComponent mDemoComponent;

    public static TuanHKApp instance() {
        return _instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        _instance = this;
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mDemoComponent = DaggerDemoComponent.builder()
                .demoModule(new DemoModule())
                .applicationComponent(mApplicationComponent)
                .build();
    }

    public ApplicationComponent getAppComponent() {
        return mApplicationComponent;
    }

    public DemoComponent getDemoComponent() {
        return mDemoComponent;
    }
}
