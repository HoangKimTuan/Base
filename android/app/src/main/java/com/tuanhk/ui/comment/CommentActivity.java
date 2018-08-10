package com.tuanhk.ui.comment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;
import android.widget.Toast;

import com.tuanhk.R;
import com.tuanhk.data.network.model.Comment;
import com.tuanhk.ui.activity.BaseToolBarActivity;
import com.tuanhk.ui.base.BaseActivity;
import com.tuanhk.ui.fragment.BaseFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CommentActivity extends BaseActivity implements CommentMvpView {

    ListView lvComment;
    ArrayList<Comment> list;
    CommentAdapter adapter;

    @Inject
    CommentMvpPresenter<CommentMvpView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        lvComment = findViewById(R.id.lvComment);
        list = new ArrayList<>();

        getUserComponent().inject(this);
        mPresenter.onAttach(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onIdStickEvent(Integer id) {
        mPresenter.loadComment(id);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getApplicationContext(), "Error load commment" + message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showComplete() {
        Toast.makeText(getApplicationContext(), "Complete load comment", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showComment(List<Comment> comments) {
        for (int i = 0; i < comments.size(); i++) {
            list.add(comments.get(i));
        }
        adapter = new CommentAdapter(list, this, new CommentAdapter.CommentItemListener() {
            @Override
            public void onAddClick(com.tuanhk.data.db.model.Comment comment) {
                mPresenter.insertComment(comment);
            }
        });
        lvComment.setAdapter(adapter);
    }
}
