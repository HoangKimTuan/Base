package com.tuanhk.splashscreen;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;

import com.tuanhk.R;
import com.tuanhk.ui.fragment.BaseFragment;

import javax.inject.Inject;

public class SplashScreenFragment extends BaseFragment implements ISplashScreenView {

    @Inject
    SplashScreenPresenter presenter;

    public static SplashScreenFragment newInstance(Bundle args) {
        SplashScreenFragment fragment = new SplashScreenFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setupFragmentComponent() {
        getAppComponent().inject(this);
    }

    @Override
    protected int getResLayoutId() {
        return R.layout.activity_splash_screen;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.attachView(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                gotoLoginScreen();
            }
        }, 1500);
    }

    @Override
    public void gotoLoginScreen() {
        navigator.startLoginActivity(getContext());
        getActivity().finish();
    }
}
