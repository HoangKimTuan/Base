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
import com.tuanhk.data.cache.AppStore;
import com.tuanhk.data.cache.UserConfig;
import com.tuanhk.data.db.AppDbHelper;
import com.tuanhk.data.db.DbHelper;
import com.tuanhk.data.network.ApiHelper;
import com.tuanhk.data.network.AppApiHelper;
import com.tuanhk.data.repository.AppRepositoryImpl;
import com.tuanhk.home.HomeScreenPresenter;
import com.tuanhk.home.calls.CallsPresenter;
import com.tuanhk.internal.UserConfigImpl;
import com.tuanhk.login.LoginScreenPresenter;
import com.tuanhk.splashscreen.SplashScreenPresenter;
import com.tuanhk.utils.AppConstants;
import com.tuanhk.utils.anotation.ApplicationContext;
import com.tuanhk.utils.anotation.DatabaseInfo;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tuanhk.utils.anotation.UserScope;

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

    @Provides
    @Singleton
    CallsPresenter provideCallsPresenterer(AppStore.Repository appStoreRepository) {
        return new CallsPresenter(appStoreRepository);
    }

    @Provides
    AppStore.RequestService providesAccountService(Retrofit retrofit) {
        return retrofit.create(AppStore.RequestService.class);
    }

    @Provides
    AppStore.Repository providesAccountRepository(AppStore.RequestService service) {
        return new AppRepositoryImpl(service);
    }
}
