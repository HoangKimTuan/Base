package com.tuanhk.home.contacts;

import com.tuanhk.data.cache.UserConfig;
import com.tuanhk.ui.presenter.AbstractPresenter;

import javax.inject.Inject;

public class ContactsPresenter extends AbstractPresenter<IContactsView> {

    private UserConfig mUserConfig;

    @Inject
    ContactsPresenter(UserConfig userConfig) {
        mUserConfig = userConfig;
    }

    public void saveLogin(boolean status) {
        mUserConfig.saveConfigLogin(status);
    }
}
