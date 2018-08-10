package com.tuanhk.login;

import com.tuanhk.data.cache.UserConfig;
import com.tuanhk.ui.presenter.AbstractPresenter;

import javax.inject.Inject;

public class LoginScreenPresenter extends AbstractPresenter<ILoginScreenView> {

    UserConfig mUserConfig;

    @Inject
    public LoginScreenPresenter(UserConfig userConfig) {
        mUserConfig = userConfig;
    }

    public void autoLogin() {
        if (mUserConfig.hasCurrentUser()) {
            mView.gotoHomeScreen();
        }
    }

    public void saveLogin(boolean status) {
        mUserConfig.saveConfigLogin(status);
    }
}