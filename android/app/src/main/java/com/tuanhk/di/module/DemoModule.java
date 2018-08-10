package com.tuanhk.di.module;

import com.tuanhk.demo.DemoPresenter;
import com.tuanhk.demo.DemoView;
import com.tuanhk.splashscreen.ISplashScreenView;
import com.tuanhk.splashscreen.SplashScreenPresenter;
import com.tuanhk.ui.presenter.IPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DemoModule {

    public DemoModule() {

    }

    @Provides
    IPresenter<DemoView> provideDemoPresenter(DemoPresenter presenter) {
        return presenter;
    }
}
