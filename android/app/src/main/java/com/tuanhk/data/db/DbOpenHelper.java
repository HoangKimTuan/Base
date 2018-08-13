package com.tuanhk.data.db;

import android.content.Context;

import com.tuanhk.data.db.model.DaoMaster;
import com.tuanhk.utils.anotation.ApplicationContext;
import com.tuanhk.utils.anotation.DatabaseInfo;

import org.greenrobot.greendao.database.Database;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by cpu10225 on 20/11/2017.
 */

@Singleton
public class DbOpenHelper extends DaoMaster.OpenHelper {
    @Inject
    public DbOpenHelper(@ApplicationContext Context context, @DatabaseInfo String name) {
        super(context, name);
    }

    @Override
    public void onCreate(Database db) {
        super.onCreate(db);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        DaoMaster.createAllTables(db, true);
    }
}
