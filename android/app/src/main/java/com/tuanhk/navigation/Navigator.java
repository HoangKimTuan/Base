package com.tuanhk.navigation;

import android.content.Context;
import android.content.Intent;

import com.tuanhk.home.HomeScreenActivity;
import com.tuanhk.login.LoginScreenActivity;
import com.tuanhk.splashscreen.SplashScreenActivity;

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

    public void startHomeActivity(Context context) {
        Intent intent = getIntentHome(context);
        context.startActivity(intent);
    }

    public Intent getIntentHome(Context context) {
        Intent intent = new Intent(context, HomeScreenActivity.class);
        return intent;
    }
}