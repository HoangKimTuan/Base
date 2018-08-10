package com.tuanhk.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.tuanhk.R;
import com.tuanhk.ui.fragment.BaseFragment;

import javax.inject.Inject;

public class LoginScreenFragment extends BaseFragment implements ILoginScreenView {

    @Inject
    LoginScreenPresenter presenter;

    public static LoginScreenFragment newInstance(Bundle args) {
        LoginScreenFragment fragment = new LoginScreenFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setupFragmentComponent() {
        getAppComponent().inject(this);
    }

    @Override
    protected int getResLayoutId() {
        return R.layout.activity_login_screen;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.attachView(this);
    }

    @Override
    public void gotoHomeScreen() {
        navigator.startLoginActivity(getContext());
        getActivity().finish();
    }
}
