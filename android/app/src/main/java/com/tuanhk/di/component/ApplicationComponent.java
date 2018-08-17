package com.tuanhk.di.component;

import android.app.Application;
import android.content.Context;

import com.tuanhk.TuanHKApp;
import com.tuanhk.data.cache.UserConfig;
import com.tuanhk.di.module.ApplicationModule;
import com.tuanhk.login.LoginScreenFragment;
import com.tuanhk.navigation.Navigator;
import com.tuanhk.splashscreen.SplashScreenFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by cpu10225 on 17/11/2017.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public abstract class ApplicationComponent {

    public static ApplicationComponent create(Application application) {
        return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(application))
                .build();
    }

    public abstract void inject(TuanHKApp tuanHKApp);
    public abstract Application application();
    public abstract Context context();
    public abstract Navigator navigator();
    public abstract UserConfig userConfig();

    public abstract void inject(SplashScreenFragment splashScreenFragment);
    public abstract void inject(LoginScreenFragment loginScreenFragment);
}