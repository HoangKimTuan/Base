package com.tuanhk.home.calls;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tuanhk.R;
import com.tuanhk.data.network.model.Post;
import com.tuanhk.ui.adapter.AbsRecyclerAdapter;
import com.tuanhk.ui.recyclerview.OnItemClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

final class CallsAdapter extends AbsRecyclerAdapter<Post, CallsAdapter.ViewHolder> {

    OnClickPostListener listener;
    private OnItemClickListener mOnItemClickListener = new OnItemClickListener() {
        @Override
        public void onListItemClick(View anchor, int position) {
            Post post = getItem(position);

            if (listener != null && post != null) {
                listener.onClickPost(post);
            }
        }
    };

    CallsAdapter(Context context, OnClickPostListener listener) {
        super(context);
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mInflater.inflate(R.layout.row_calls, parent, false), mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Post item = getItem(position);
        if (item != null) {
            holder.bindView(item);
        }
    }

    interface OnClickPostListener {
        void onClickPost(Post card);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        TextView mTitle;
        @BindView(R.id.body)
        TextView mBody;

        private OnItemClickListener listener;

        public ViewHolder(View itemView, OnItemClickListener listener) {
            super(itemView);
            this.listener = listener;
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.row_calls)
        void onBankSupportClickItem(View v) {
            if (listener != null) {
                listener.onListItemClick(v, getAdapterPosition());
            }
        }

        void bindView(Post post) {
            mTitle.setText(post.getTitle());
            mBody.setText(post.getBody());
        }
    }
}