package com.tuanhk.data.cache.model;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import java.util.Map;

public class DaoSession extends AbstractDaoSession {

    private final DaoConfig postDaoConfig;

    private final PostRecentDao postRecentDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        postDaoConfig = daoConfigMap.get(PostRecentDao.class).clone();
        postDaoConfig.initIdentityScope(type);

        postRecentDao = new PostRecentDao(postDaoConfig, this);

        registerDao(PostRecent.class, postRecentDao);
    }

    public void clear() {
        postDaoConfig.clearIdentityScope();
    }

    public PostRecentDao getPostRecentDao() {
        return postRecentDao;
    }
}