package com.tuanhk.data.repository;

import com.tuanhk.data.cache.AppStore;
import com.tuanhk.data.api.mapper.PlatformDaoMapper;
import com.tuanhk.data.cache.model.DaoSession;
import com.tuanhk.data.cache.model.PostRecent;
import com.tuanhk.data.cache.model.PostRecentDao;
import com.tuanhk.data.api.entity.Post;

public class AppLocalStorageImpl implements AppStore.LocalStorage {

    private final DaoSession mDaoSession;
    private final PlatformDaoMapper mPlatformDaoMapper;

    public AppLocalStorageImpl(DaoSession daoSession, PlatformDaoMapper platformDaoMapper) {
        this.mDaoSession = daoSession;
        this.mPlatformDaoMapper = platformDaoMapper;
    }

    @Override
    public void put(Post post) {
        PostRecent postRecent = mPlatformDaoMapper.transform(post);
        if (postRecent == null) {
            return;
        }
        mDaoSession.getPostRecentDao().insertOrReplaceInTx(postRecent);
    }

    @Override
    public Post get(long id) {
        PostRecent postRecent = mDaoSession.getPostRecentDao().queryBuilder()
                .where(PostRecentDao.Properties.id.eq(id))
                .unique();

        Post post = mPlatformDaoMapper.transform(postRecent);
        return post;
    }
}
