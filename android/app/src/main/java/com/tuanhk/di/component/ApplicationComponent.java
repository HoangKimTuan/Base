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
public interface ApplicationComponent {
    void inject(TuanHKApp app);
    Application application();
    DataManager dataManager();
    @ApplicationContext
    Context context();
    Navigator navigator();
    AppStore.Repository appRepository();
    void inject(SplashScreenFragment splashScreenFragment);
    void inject(LoginScreenFragment loginScreenFragment);
    void inject(HomeScreenFragment homeScreenFragment);
    void inject(CallsFragment callsFragment);
}