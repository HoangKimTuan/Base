package com.tuanhk.login;

import android.support.annotation.Nullable;

import com.tuanhk.splashscreen.SplashScreenFragment;
import com.tuanhk.ui.activity.BaseActivity;
import com.tuanhk.ui.fragment.BaseFragment;

public class LoginScreenActivity extends BaseActivity {

    @Nullable
    @Override
    protected BaseFragment getFragmentToHost() {
        return LoginScreenFragment.newInstance(getIntent().getExtras());
    }
}
