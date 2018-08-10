package com.tuanhk.ui.comment;

import android.os.Bundle;

import com.tuanhk.R;
import com.tuanhk.ui.fragment.BaseFragment;

public class CommentFragment extends BaseFragment {
    public static CommentFragment newInstance(Bundle args) {
        CommentFragment fragment = new CommentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setupFragmentComponent() {

    }

    @Override
    protected int getResLayoutId() {
        return R.layout.activity_comment;
    }
}
