package com.tuanhk.home;

import com.tuanhk.data.cache.UserConfig;
import com.tuanhk.ui.presenter.AbstractPresenter;

import javax.inject.Inject;

public class HomeScreenPresenter extends AbstractPresenter<IHomeScreenView> {

    UserConfig mUserConfig;

    @Inject
    public HomeScreenPresenter(UserConfig userConfig) {
        mUserConfig = userConfig;
    }

    public void saveLogin(boolean status) {
        mUserConfig.saveConfigLogin(status);
    }
}
