package com.tuanhk.internal;

import android.content.SharedPreferences;

import com.tuanhk.data.cache.UserConfig;

public class UserConfigImpl implements UserConfig {

    private final SharedPreferences preferences;

    public UserConfigImpl(SharedPreferences pref) {
        this.preferences = pref;
    }

    @Override
    public boolean hasCurrentUser() {
        return preferences.getBoolean(Constants.PREF_AUTO_LOGIN, false);
    }

    @Override
    public void saveConfigLogin(boolean status) {
        SharedPreferences.Editor editor = preferences.edit();

        editor.putBoolean(Constants.PREF_AUTO_LOGIN, status);
        editor.apply();
    }
}
