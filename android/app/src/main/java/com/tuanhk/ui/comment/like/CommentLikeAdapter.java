package com.tuanhk.ui.comment.like;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tuanhk.R;
import com.tuanhk.data.db.model.Comment;
import com.tuanhk.ui.comment.CommentAdapter;

import java.util.List;

/**
 * Created by cpu10225 on 21/11/2017.
 */

public class CommentLikeAdapter extends BaseAdapter {
    private List<Comment> mCommentLikeList;
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private CommentLikeItemListener mCommentLikeItemListener;

    public CommentLikeAdapter(List<Comment> commentLikeList, Context context, CommentLikeItemListener mCommentLikeItemListener) {
        this.mCommentLikeList = commentLikeList;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.mCommentLikeItemListener = mCommentLikeItemListener;
    }

    @Override
    public int getCount() {
        return mCommentLikeList.size();
    }

    @Override
    public Object getItem(int i) {
        return mCommentLikeList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        final Comment comment = this.mCommentLikeList.get(i);
        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.listview_comment_like, null);
            holder = new ViewHolder();
            holder.tvNameCommentLike = view.findViewById(R.id.tvNameCommentLike);
            holder.tvEmailCommentLike = view.findViewById(R.id.tvEmailCommentLike);
            holder.tvBodyCommentLike = view.findViewById(R.id.tvBodyCommentLike);
            view.findViewById(R.id.btnRemoveCommentLike).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mCommentLikeItemListener.onRemoveClick(comment.getId(), i);
                }
            });
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.tvNameCommentLike.setText(comment.getName());
        holder.tvEmailCommentLike.setText(comment.getEmail());
        holder.tvBodyCommentLike.setText(comment.getBody());

        return view;
    }

    static class ViewHolder {
        TextView tvNameCommentLike, tvEmailCommentLike, tvBodyCommentLike;
    }

    public interface CommentLikeItemListener {
        void onRemoveClick(Long id, int index);
    }
}
