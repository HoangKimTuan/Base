package com.tuanhk.demo;

import com.tuanhk.ui.presenter.AbstractPresenter;

import javax.inject.Inject;

public class DemoPresenter extends AbstractPresenter<DemoView> {
    String a = "1";

    @Inject
    public DemoPresenter() {

    }
}
