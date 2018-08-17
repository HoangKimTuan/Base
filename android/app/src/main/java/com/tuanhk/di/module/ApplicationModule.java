package com.tuanhk.di.module;

/**
 * Created by cpu10225 on 17/11/2017.
 */

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.tuanhk.BuildConfig;
import com.tuanhk.data.api.mapper.PlatformDaoMapper;
import com.tuanhk.data.cache.AppStore;
import com.tuanhk.data.cache.UserConfig;
import com.tuanhk.data.cache.model.DaoMaster;
import com.tuanhk.data.cache.model.DaoSession;
import com.tuanhk.data.repository.AppLocalStorageImpl;
import com.tuanhk.data.repository.AppRepositoryImpl;
import com.tuanhk.data.util.DBOpenHelper;
import com.tuanhk.internal.UserConfigImpl;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.greenrobot.greendao.database.Database;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
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
    UserConfig providesUserConfig(SharedPreferences sharedPreferences) {
        return new UserConfigImpl(sharedPreferences);
    }

}
