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
import com.tuanhk.internal.UserConfigImpl;
import com.tuanhk.utils.AppConstants;
import com.tuanhk.di.anotation.DatabaseInfo;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
    @Singleton
    Context provideContext() {
        return mApplication;
    }

    @Provides
    @Singleton
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
    Retrofit provideRetrofit() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BuildConfig.BASE_URL)
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    UserConfig providesUserConfig(SharedPreferences sharedPreferences) {
        return new UserConfigImpl(sharedPreferences);
    }

    @Provides
    AppStore.RequestService providesAccountService(Retrofit retrofit) {
        return retrofit.create(AppStore.RequestService.class);
    }

    @Provides
    AppStore.Repository providesAccountRepository(AppStore.RequestService service) {
        return new AppRepositoryImpl(service);
    }








    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
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


}
