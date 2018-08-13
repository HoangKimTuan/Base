package com.tuanhk.demo;

import android.support.annotation.Nullable;

import com.tuanhk.ui.activity.UserBaseToolBarActivity;
import com.tuanhk.ui.fragment.BaseFragment;

public class DemoActivity extends UserBaseToolBarActivity {

    @Nullable
    @Override
    protected BaseFragment getFragmentToHost() {
        return DemoFragment.newInstance(getIntent().getExtras());
    }
}
