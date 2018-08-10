package com.tuanhk.ui.photo;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.tuanhk.R;
import com.tuanhk.data.db.model.PhotoDb;
import com.tuanhk.data.network.model.Photo;
import com.tuanhk.ui.base.BaseActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class PhotoActivity extends BaseActivity implements PhotoMvpView {

    ListView lvPhoto;
    List<Photo> list;
    PhotoAdapter adapter;

    @Inject
    PhotoMvpPresenter<PhotoMvpView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        lvPhoto = findViewById(R.id.lvPhoto);
        list = new ArrayList<>();

        getUserComponent().inject(this);
        mPresenter.onAttach(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onIdStickEvent(Integer id) {
        mPresenter.loadPhoto(id);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getApplicationContext(), "Error load photo" + message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showComplete() {
        Toast.makeText(getApplicationContext(), "Complete load photo", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPhoto(List<Photo> photos) {
        for (int i = 0; i < photos.size(); i++) {
            list.add(photos.get(i));
        }
        adapter = new PhotoAdapter(list, this, new PhotoAdapter.PhotoItemListener() {
            @Override
            public void onAddClick(PhotoDb photoDb) {
                mPresenter.insertPhoto(photoDb);
            }
        });
        lvPhoto.setAdapter(adapter);
    }
}
