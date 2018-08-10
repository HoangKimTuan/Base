package com.tuanhk.di.module;

/**
 * Created by cpu10225 on 17/11/2017.
 */

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.tuanhk.BuildConfig;
import com.tuanhk.data.AppDataManager;
import com.tuanhk.data.DataManager;
import com.tuanhk.data.cache.UserConfig;
import com.tuanhk.data.db.AppDbHelper;
import com.tuanhk.data.db.DbHelper;
import com.tuanhk.data.db.DbOpenHelper;
import com.tuanhk.data.network.ApiHelper;
import com.tuanhk.data.network.AppApiHelper;
import com.tuanhk.home.HomeScreenPresenter;
import com.tuanhk.internal.UserConfigImpl;
import com.tuanhk.login.LoginScreenPresenter;
import com.tuanhk.splashscreen.ISplashScreenView;
import com.tuanhk.splashscreen.SplashScreenPresenter;
import com.tuanhk.ui.presenter.IPresenter;
import com.tuanhk.util.AppConstants;
import com.tuanhk.util.anotation.ApplicationContext;
import com.tuanhk.util.anotation.DatabaseInfo;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApplicationModule {
    private final Application mApplication;

    public ApplicationModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    Cache provideHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkhttpClient(Cache cache) {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.cache(cache);
        return client.build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BuildConfig.BASE_URL)
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    UserConfig providesUserConfig(SharedPreferences sharedPreferences) {
        return new UserConfigImpl(sharedPreferences);
    }

    @Provides
    @Singleton
    SplashScreenPresenter provideSplashScreenPresenterer() {
        return new SplashScreenPresenter();
    }

    @Provides
    @Singleton
    LoginScreenPresenter provideLoginScreenPresenterer(UserConfig userConfig) {
        return new LoginScreenPresenter(userConfig);
    }

    @Provides
    @Singleton
    HomeScreenPresenter provideHomeScreenPresenterer(UserConfig userConfig) {
        return new HomeScreenPresenter(userConfig);
    }
}
