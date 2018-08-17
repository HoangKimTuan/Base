package com.tuanhk.di.module;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tuanhk.BuildConfig;
import com.tuanhk.data.api.mapper.PlatformDaoMapper;
import com.tuanhk.data.cache.AppStore;
import com.tuanhk.data.cache.UserConfig;
import com.tuanhk.data.cache.model.DaoMaster;
import com.tuanhk.data.cache.model.DaoSession;
import com.tuanhk.data.repository.AppLocalStorageImpl;
import com.tuanhk.data.repository.AppRepositoryImpl;
import com.tuanhk.data.util.DBOpenHelper;
import com.tuanhk.di.anotation.UserScope;
import com.tuanhk.internal.UserConfigImpl;

import org.greenrobot.greendao.database.Database;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cpu10225 on 14/11/2017.
 */

@Module
public class UserModule {

    public UserModule() {

    }

    @UserScope
    @Provides
    DaoSession provideDaoSession(Context context) {
        DaoMaster.OpenHelper helper = new DBOpenHelper(context, "tuanhk.db");
        Database db = helper.getWritableDb();
        DaoMaster daoMaster = new DaoMaster(db);
        return daoMaster.newSession();
    }

    @UserScope
    @Provides
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

    @UserScope
    @Provides
    PlatformDaoMapper providesPlatformDaoMapper() {
        return new PlatformDaoMapper();
    }

    @UserScope
    @Provides
    AppStore.RequestService providesAccountService(Retrofit retrofit) {
        return retrofit.create(AppStore.RequestService.class);
    }

    @UserScope
    @Provides
    AppStore.Repository providesAppRepository(AppStore.RequestService service) {
        return new AppRepositoryImpl(service);
    }

    @UserScope
    @Provides
    AppStore.LocalStorage providesAppLocalStorage(DaoSession daoSession, PlatformDaoMapper platformDaoMapper) {
        return new AppLocalStorageImpl(daoSession, platformDaoMapper);
    }
}
