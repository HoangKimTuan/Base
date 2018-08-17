package com.tuanhk.login;

import android.content.Context;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.tuanhk.data.cache.UserConfig;
import com.tuanhk.ui.presenter.AbstractPresenter;

import javax.inject.Inject;

public class LoginScreenPresenter extends AbstractPresenter<ILoginScreenView> {

    private UserConfig mUserConfig;

    @Inject
    LoginScreenPresenter(UserConfig userConfig) {
        this.mUserConfig = userConfig;
    }

    public void autoSignIn(Context context) {
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(context);
        if (account == null) {
            return;
        }

        mView.gotoHomeScreen();
    }
}
