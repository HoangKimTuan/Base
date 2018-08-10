package com.tuanhk.home;

import android.support.annotation.Nullable;

import com.tuanhk.ui.activity.BaseActivity;
import com.tuanhk.ui.fragment.BaseFragment;

public class HomeScreenActivity extends BaseActivity {

    @Nullable
    @Override
    protected BaseFragment getFragmentToHost() {
        return HomeScreenFragment.newInstance(getIntent().getExtras());
    }
}
