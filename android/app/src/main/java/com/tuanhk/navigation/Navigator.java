package com.tuanhk.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.tuanhk.home.HomeScreenActivity;
import com.tuanhk.login.LoginScreenActivity;
import com.tuanhk.splashscreen.SplashScreenActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Navigator {

    private GoogleSignInClient mGoogleSignInClient;

    @Inject
    public Navigator(GoogleSignInClient googleSignInClient) {
        this.mGoogleSignInClient = googleSignInClient;
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

    public void startGoogleSignInClient(Fragment fragment, int requestCode) {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        fragment.startActivityForResult(signInIntent, requestCode);
    }

    public void logout(Activity activity) {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(activity, task -> {
                    startLoginActivity(activity);
                    activity.finish();
                });
    }
}