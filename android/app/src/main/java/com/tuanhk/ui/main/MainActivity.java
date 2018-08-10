package com.tuanhk.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.tuanhk.R;
import com.tuanhk.data.network.model.Album;
import com.tuanhk.data.network.model.Post;
import com.tuanhk.demo.DemoActivity;
import com.tuanhk.ui.base.BaseActivity;
import com.tuanhk.ui.comment.CommentActivity;
import com.tuanhk.ui.photo.PhotoActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainMvpView {
    ListView lvPost, lvAlbum;
    ArrayList<Post> listPost;
    ArrayList<Album> listAlbum;
    ArrayAdapter<Post> adapterPost;
    ArrayAdapter<Album> adapterAlbum;

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvPost = findViewById(R.id.lvPost);
        lvPost.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mPresenter.clickPost(listPost.get(i).getId());
                startActivity(new Intent(MainActivity.this, CommentActivity.class));
            }
        });
        listPost = new ArrayList<>();

        lvAlbum = findViewById(R.id.lvAlbum);
        lvAlbum.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mPresenter.clickAlbum(listAlbum.get(i).getId());
                startActivity(new Intent(MainActivity.this, PhotoActivity.class));
            }
        });
        listAlbum = new ArrayList<>();

        getUserComponent().inject(this);
        mPresenter.onAttach(this);
        mPresenter.loadPost();
        mPresenter.loadAlbum();

        findViewById(R.id.show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DemoActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void showPost(List<Post> posts) {
        for (int i = 0; i < posts.size(); i++) {
            listPost.add(posts.get(i));
        }
        adapterPost = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listPost);
        lvPost.setAdapter(adapterPost);
    }

    @Override
    public void showAlbum(List<Album> albums) {
        for (int i = 0; i < albums.size(); i++) {
            listAlbum.add(albums.get(i));
        }
        adapterAlbum = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listAlbum);
        lvAlbum.setAdapter(adapterAlbum);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getApplicationContext(), "Error load post" + message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showComplete() {
        Toast.makeText(getApplicationContext(), "Complete load post", Toast.LENGTH_SHORT).show();
    }
}
