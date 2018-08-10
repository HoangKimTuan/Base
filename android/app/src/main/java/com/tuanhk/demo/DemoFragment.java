package com.tuanhk.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tuanhk.R;
import com.tuanhk.ui.fragment.BaseFragment;

import javax.inject.Inject;

import butterknife.OnClick;

public class DemoFragment extends BaseFragment implements DemoView {

    @Inject
    DemoPresenter presenter;

    public static DemoFragment newInstance(Bundle args) {
        DemoFragment fragment = new DemoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setupFragmentComponent() {
        getDemoComponent().inject(this);
    }

    @Override
    protected int getResLayoutId() {
        return R.layout.activity_demo;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @OnClick(R.id.demo)
    void OnClickDemo() {
        Toast.makeText(getContext(), presenter.a, Toast.LENGTH_SHORT).show();
    }
}
