package com.tuanhk.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.tuanhk.R;
import com.tuanhk.ui.fragment.BaseFragment;

import javax.inject.Inject;

import butterknife.OnClick;

public class HomeScreenFragment extends BaseFragment implements IHomeScreenView {

    @Inject
    HomeScreenPresenter presenter;

    public static HomeScreenFragment newInstance(Bundle args) {
        HomeScreenFragment fragment = new HomeScreenFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setupFragmentComponent() {
        getAppComponent().inject(this);
    }

    @Override
    protected int getResLayoutId() {
        return R.layout.activity_home_screen;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.attachView(this);
    }

    @Override
    public void backToLoginScreen() {
        navigator.startLoginActivity(getContext());
        getActivity().finish();
    }

    @OnClick(R.id.home)
    void onClickHome() {
        presenter.saveLogin(false);
        backToLoginScreen();
    }
}
