package com.tuanhk.data.db;

import com.tuanhk.data.db.model.Comment;
import com.tuanhk.data.db.model.DaoMaster;
import com.tuanhk.data.db.model.DaoSession;
import com.tuanhk.data.db.model.PhotoDb;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by cpu10225 on 20/11/2017.
 */

@Singleton
public class AppDbHelper implements DbHelper {
    private final DaoSession mDaoSession;

    @Inject
    public AppDbHelper(DbOpenHelper dbOpenHelper) {
        this.mDaoSession = new DaoMaster(dbOpenHelper.getWritableDb()).newSession();
    }

    @Override
    public Long insertComment(final Comment comment) {
        return mDaoSession.getCommentDao().insert(comment);
    }

    @Override
    public void removeComment(Long id) {
        mDaoSession.getCommentDao().deleteByKey(id);
    }

    @Override
    public Observable<List<Comment>> getAllComment() {
        return Observable.fromCallable(new Callable<List<Comment>>() {
            @Override
            public List<Comment> call() throws Exception {
                return mDaoSession.getCommentDao().loadAll();
            }
        });
    }

    @Override
    public Long insertPhoto(final PhotoDb photoDb) {
        return mDaoSession.getPhotoDbDao().insert(photoDb);
    }

    @Override
    public void removePhoto(Long id) {
        mDaoSession.getPhotoDbDao().deleteByKey(id);
    }

    @Override
    public Observable<List<PhotoDb>> getAllPhoto() {
        return Observable.fromCallable(new Callable<List<PhotoDb>>() {
            @Override
            public List<PhotoDb> call() throws Exception {
                return mDaoSession.getPhotoDbDao().loadAll();
            }
        });
    }
}
