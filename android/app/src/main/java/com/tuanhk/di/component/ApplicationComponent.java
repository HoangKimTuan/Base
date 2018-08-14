package com.tuanhk.di.component;

import android.app.Application;
import android.content.Context;

import com.tuanhk.TuanHKApp;
import com.tuanhk.data.DataManager;
import com.tuanhk.data.cache.AppStore;
import com.tuanhk.di.module.ApplicationModule;
import com.tuanhk.home.HomeScreenFragment;
import com.tuanhk.home.calls.CallsFragment;
import com.tuanhk.login.LoginScreenFragment;
import com.tuanhk.navigation.Navigator;
import com.tuanhk.splashscreen.SplashScreenFragment;
import com.tuanhk.utils.anotation.ApplicationContext;

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
    @ApplicationContext
    public abstract Context context();
    public abstract Navigator navigator();
    public abstract AppStore.Repository appRepository();
    public abstract void inject(SplashScreenFragment splashScreenFragment);
    public abstract void inject(LoginScreenFragment loginScreenFragment);
    public abstract void inject(HomeScreenFragment homeScreenFragment);
}