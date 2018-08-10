package com.tuanhk.navigation;

import android.content.Context;
import android.content.Intent;

import com.tuanhk.login.LoginScreenActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Navigator {

    @Inject
    public Navigator() {
    }

    public void startLoginActivity(Context context) {
        Intent intent = getIntentLogin(context);
        context.startActivity(intent);
    }

    public Intent getIntentLogin(Context context) {
        Intent intent = new Intent(context, LoginScreenActivity.class);
        return intent;
    }
}