package com.tuanhk.di.component;

import android.app.Application;
import android.content.Context;

import com.tuanhk.TuanHKApp;
import com.tuanhk.data.DataManager;
import com.tuanhk.di.module.ApplicationModule;
import com.tuanhk.navigation.Navigator;
import com.tuanhk.splashscreen.SplashScreenFragment;
import com.tuanhk.util.anotation.ApplicationContext;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by cpu10225 on 17/11/2017.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(TuanHKApp app);
    Application application();
    DataManager dataManager();
    @ApplicationContext
    Context context();
    Navigator navigator();
    void inject(SplashScreenFragment splashScreenFragment);
}