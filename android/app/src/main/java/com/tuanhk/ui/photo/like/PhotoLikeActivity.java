package com.tuanhk.ui.photo.like;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.tuanhk.R;
import com.tuanhk.data.db.model.PhotoDb;
import com.tuanhk.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class PhotoLikeActivity extends BaseActivity implements PhotoLikeMvpView {

    ListView lvPhotoLike;
    List<PhotoDb> list;
    PhotoLikeAdapter adapter;

    @Inject
    PhotoLikeMvpPresenter<PhotoLikeMvpView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_like);

        lvPhotoLike = findViewById(R.id.lvPhotoLike);
        list = new ArrayList<>();

        getUserComponent().inject(this);
        mPresenter.onAttach(this);
        mPresenter.getPhotoList();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getApplicationContext(), "Error load photo like" + message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showComplete() {
        Toast.makeText(getApplicationContext(), "Complete load photo like", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPhotoLike(List<PhotoDb> photoDbs) {
        for (int i = 0; i < photoDbs.size(); i++) {
            list.add(photoDbs.get(i));
        }
        adapter = new PhotoLikeAdapter(list, this, new PhotoLikeAdapter.PhotoLikeItemListener() {
            @Override
            public void onRemoveClick(Long id, int index) {
                mPresenter.removePhoto(id);
                list.remove(index);
                adapter.notifyDataSetChanged();
            }
        });
        lvPhotoLike.setAdapter(adapter);
    }
}
