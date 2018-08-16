package com.tuanhk.data.util;

import android.content.Context;

import com.tuanhk.data.cache.model.DaoMaster;

import org.greenrobot.greendao.database.Database;

import javax.inject.Singleton;

/**
 * Created by cpu10225 on 20/11/2017.
 */

@Singleton
public class DBOpenHelper extends DaoMaster.OpenHelper {
    public DBOpenHelper(Context context, String name) {
        super(context, name, null);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        DaoMaster.dropAllTables(db, oldVersion, true);
        onCreate(db);
    }
}