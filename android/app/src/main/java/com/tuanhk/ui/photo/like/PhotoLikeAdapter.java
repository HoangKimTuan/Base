package com.tuanhk.ui.photo.like;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tuanhk.R;
import com.tuanhk.data.db.model.PhotoDb;

import java.util.List;

/**
 * Created by cpu10225 on 24/11/2017.
 */

public class PhotoLikeAdapter extends BaseAdapter {
    private List<PhotoDb> mPhotoLikeList;
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private PhotoLikeItemListener mPhotoLikeItemListener;

    public PhotoLikeAdapter(List<PhotoDb> photoLikeList, Context context, PhotoLikeItemListener mPhotoLikeItemListener) {
        this.mPhotoLikeList = photoLikeList;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.mPhotoLikeItemListener = mPhotoLikeItemListener;
    }

    @Override
    public int getCount() {
        return mPhotoLikeList.size();
    }

    @Override
    public Object getItem(int i) {
        return mPhotoLikeList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        final PhotoDb photoDb = this.mPhotoLikeList.get(i);
        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.listview_photo_like, null);
            holder = new ViewHolder();
            holder.tvTitlePhotoLike = view.findViewById(R.id.tvTitlePhotoLike);
            holder.ivPhotoLike = view.findViewById(R.id.ivPhotoLike);
            view.findViewById(R.id.btnRemovePhotoLike).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mPhotoLikeItemListener.onRemoveClick(photoDb.getId(), i);
                }
            });
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.tvTitlePhotoLike.setText(photoDb.getTitle());
        Glide.with(this.mContext)
                .load(photoDb.getUrl())
                .into(holder.ivPhotoLike);

        return view;
    }

    static class ViewHolder {
        TextView tvTitlePhotoLike;
        ImageView ivPhotoLike;
    }

    public interface PhotoLikeItemListener {
        void onRemoveClick(Long id, int index);
    }
}
