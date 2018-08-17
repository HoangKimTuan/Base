package com.tuanhk.home.contacts;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.tuanhk.R;
import com.tuanhk.ui.fragment.BaseFragment;

import javax.inject.Inject;

import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactsFragment extends BaseFragment implements IContactsView  {

    @Inject
    ContactsPresenter mPresenter;

    public static ContactsFragment newInstance(Bundle args) {
        ContactsFragment fragment = new ContactsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setupFragmentComponent() {
        getUserComponent().inject(this);
    }

    @Override
    protected int getResLayoutId() {
        return R.layout.fragment_contacts;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.attachView(this);
    }

    @Override
    public void backToLoginScreen() {
        navigator.startLoginActivity(getContext());
        getActivity().finish();
    }

    @OnClick(R.id.logout)
    void onLogout() {
        mPresenter.saveLogin(false);
        backToLoginScreen();
    }

}
