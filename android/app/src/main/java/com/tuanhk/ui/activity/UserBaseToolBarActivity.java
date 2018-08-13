package com.tuanhk.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.tuanhk.R;

import butterknife.BindView;

public abstract class UserBaseToolBarActivity extends UserBaseActivity {

    @BindView(R.id.toolbar)
    protected Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    protected int getResLayoutId() {
        return R.layout.activity_common_actionbar;
    }

    @Override
    public void setTitle(CharSequence title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public void setTitle(int titleId) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(titleId);
        }
    }

    public Toolbar getToolbar() {
        return mToolbar;
    }
}
