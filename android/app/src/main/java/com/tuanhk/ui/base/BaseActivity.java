package com.tuanhk.ui.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.tuanhk.R;
import com.tuanhk.TuanHKApp;
import com.tuanhk.di.component.DaggerUserComponent;
import com.tuanhk.di.component.UserComponent;
import com.tuanhk.di.module.UserModule;
import com.tuanhk.ui.comment.like.CommentLikeActivity;
import com.tuanhk.ui.main.MainActivity;
import com.tuanhk.ui.photo.like.PhotoLikeActivity;

/**
 * Created by cpu10225 on 17/11/2017.
 */

public class BaseActivity extends AppCompatActivity implements BaseMvpView {
    private UserComponent mUserComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserComponent = DaggerUserComponent.builder()
                .userModule(new UserModule(this))
                .applicationComponent(((TuanHKApp) getApplication()).getAppComponent())
                .build();
    }

    public UserComponent getUserComponent() {
        return mUserComponent;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_like_comment:
                startActivity(new Intent(this, CommentLikeActivity.class));
                return true;
            case R.id.item_like_photo:
                startActivity(new Intent(this, PhotoLikeActivity.class));
                return true;
            case R.id.item_home:
                startActivity(new Intent(this, MainActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
