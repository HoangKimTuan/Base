package com.tuanhk.ui.main;

/**
 * Created by cpu10225 on 17/11/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import com.tuanhk.data.network.model.Post;
import com.tuanhk.R;

/**
 * Created by cpu10225 on 14/11/2017.
 */

public class PostAdapter extends BaseAdapter {
    private List<Post> mPostList;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public PostAdapter(List<Post> postList, Context context) {
        this.mPostList = postList;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mPostList.size();
    }

    @Override
    public Object getItem(int i) {
        return mPostList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.listview_post, null);
            holder = new ViewHolder();
            holder.tvNamePost = view.findViewById(R.id.tvNamePost);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Post post = this.mPostList.get(i);
        holder.tvNamePost.setText(post.getTitle());

        return view;
    }

    static class ViewHolder {
        TextView tvNamePost;
    }
}

