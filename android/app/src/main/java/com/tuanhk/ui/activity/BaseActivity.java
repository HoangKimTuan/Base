package com.tuanhk.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.tuanhk.R;
import com.tuanhk.TuanHKApp;
import com.tuanhk.di.component.ApplicationComponent;
import com.tuanhk.ui.fragment.BaseFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {
    protected final String TAG = getClass().getSimpleName();
//    protected final EventBus mEventBus = getAppComponent().eventBus();
//    protected final Navigator navigator = getAppComponent().navigator();
    private Unbinder unbinder;
    private boolean mResumed;

    protected void setupUserComponent(ApplicationComponent applicationComponent) {
    }

    @Nullable
    protected abstract BaseFragment getFragmentToHost();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupUserComponent(getAppComponent());
        setContentView(getResLayoutId());
        if (savedInstanceState == null) {
            hostFragment(getFragmentToHost());
        }
    }

    protected int getResLayoutId() {
        return R.layout.activity_common;
    }

    protected void hostFragment(BaseFragment fragment, int id) {
        if (fragment != null && getFragmentManager().findFragmentByTag(fragment.getTag()) == null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(id, fragment, fragment.TAG);
            ft.commit();
        }
    }

    protected void hostFragment(BaseFragment fragment) {
        hostFragment(fragment, R.id.fragment_container);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        unbinder = ButterKnife.bind(this);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        unbinder = ButterKnife.bind(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        mResumed = false;
    }

    @Override
    public void onResume() {
        super.onResume();
        mResumed = true;
    }

    @Override
    protected void onDestroy() {
        try {
            super.onDestroy();
            unbinder.unbind();
        } catch (Exception e) {
            Log.d(TAG, "Exception onDestroy BaseActivity");
        }
    }

    @Override
    public void onBackPressed() {
        if (!mResumed) {
            return;
        }

        Fragment activeFragment = getActiveFragment();
        if (activeFragment instanceof BaseFragment) {
            if (((BaseFragment) activeFragment).onBackPressed()) {
                return;
            }
        }

        super.onBackPressed();
    }

    protected Fragment getActiveFragment() {
        return getSupportFragmentManager().findFragmentById(R.id.fragment_container);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return false;
    }

//    public void showToast(String message) {
//        ToastUtil.showToast(this, message);
//    }
//
//    public void showToast(int message) {
//        ToastUtil.showToast(this, message);
//    }

    protected ApplicationComponent getAppComponent() {
        return TuanHKApp.instance().getAppComponent();
    }

//    public void showNetworkErrorDialog() {
//        showNetworkErrorDialog(null);
//    }
//
//    public void showNetworkErrorDialog(OnSweetDialogListener listener) {
//        DialogHelper.showNetworkErrorDialog(this, listener);
//    }
//
//    public void showCustomDialog(String message,
//                                 String cancelBtnText,
//                                 int dialogType,
//                                 final OnEventDialogListener listener) {
//        DialogHelper.showCustomDialog(this,
//                message,
//                cancelBtnText,
//                dialogType,
//                listener);
//    }
//
//    public void showNotificationDialog(String message) {
//        DialogHelper.showNotificationDialog(this,
//                message);
//    }
//
//    public void showWarningDialog(String message,
//                                  final OnEventDialogListener cancelListener) {
//        DialogHelper.showWarningDialog(this,
//                message,
//                cancelListener);
//    }
//
//    public void showErrorDialog(String message) {
//        DialogHelper.showNotificationDialog(this, message, null);
//    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Fragment activeFragment = getActiveFragment();
        if (activeFragment instanceof BaseFragment) {
            ((BaseFragment) activeFragment).onNewIntent(intent);
        }
    }
}
