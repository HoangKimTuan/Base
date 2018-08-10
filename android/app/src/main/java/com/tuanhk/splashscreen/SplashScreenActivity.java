package com.tuanhk.splashscreen;

import android.support.annotation.Nullable;

import com.tuanhk.ui.activity.BaseActivity;
import com.tuanhk.ui.fragment.BaseFragment;

public class SplashScreenActivity extends BaseActivity {

    @Nullable
    @Override
    protected BaseFragment getFragmentToHost() {
        return SplashScreenFragment.newInstance(getIntent().getExtras());
    }
}
