package com.tuanhk.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.tuanhk.R;
import com.tuanhk.ui.fragment.BaseFragment;

import javax.inject.Inject;

import butterknife.OnClick;

public class LoginScreenFragment extends BaseFragment implements ILoginScreenView {

    @Inject
    LoginScreenPresenter mPresenter;

    private final int RC_SIGN_IN = 106;

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
        mPresenter.attachView(this);
        mPresenter.autoSignIn(getContext());
    }

    @Override
    public void gotoHomeScreen() {
        navigator.startHomeActivity(getContext());
        getActivity().finish();
    }

    @OnClick(R.id.login)
    void onClickLogin() {
        navigator.startGoogleSignInClient(this, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            gotoHomeScreen();
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            updateUI(null);
        }
    }

    private void updateUI(GoogleSignInAccount account) {

    }
}
