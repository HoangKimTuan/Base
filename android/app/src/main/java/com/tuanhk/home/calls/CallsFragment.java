package com.tuanhk.home.calls;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.tuanhk.R;
import com.tuanhk.data.network.model.Post;
import com.tuanhk.ui.fragment.BaseFragment;
import com.tuanhk.ui.recyclerview.HorizontalDividerDecoration;
import com.tuanhk.utils.AndroidUtils;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CallsFragment extends BaseFragment implements ICallsView, CallsAdapter.OnClickPostListener {

    @Inject
    CallsPresenter presenter;

    private static final int PADDING_ITEM = 60;
    @BindView(R.id.listview)
    RecyclerView mListView;
    private CallsAdapter mAdapter;

    public static CallsFragment newInstance(Bundle args) {
        CallsFragment fragment = new CallsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setupFragmentComponent() {
        getAppComponent().inject(this);
    }

    @Override
    protected int getResLayoutId() {
        return R.layout.fragment_calls;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.attachView(this);
        mListView.setHasFixedSize(true);
        mListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mListView.addItemDecoration(new HorizontalDividerDecoration(getActivity(), AndroidUtils.dp(PADDING_ITEM), R.drawable.line_divider));
        mListView.setAdapter(mAdapter);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new CallsAdapter(getContext(), this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.listBankSupport();
    }

    @Override
    public void onClickPost(Post card) {

    }

    @Override
    public void addData(List<Post> postList) {
        mAdapter.setData(postList);
    }
}
