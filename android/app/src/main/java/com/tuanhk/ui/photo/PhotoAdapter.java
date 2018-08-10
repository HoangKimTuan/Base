package com.tuanhk.ui.photo;

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
import com.tuanhk.data.network.model.Photo;

import java.util.List;

/**
 * Created by cpu10225 on 24/11/2017.
 */

public class PhotoAdapter extends BaseAdapter {
    private List<Photo> mPhotoList;
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private PhotoItemListener mPhotoItemListener;

    public PhotoAdapter(List<Photo> photoList, Context context, PhotoItemListener mPhotoItemListener) {
        this.mPhotoList = photoList;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.mPhotoItemListener = mPhotoItemListener;
    }

    @Override
    public int getCount() {
        return mPhotoList.size();
    }

    @Override
    public Object getItem(int i) {
        return mPhotoList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        Photo photo = this.mPhotoList.get(i);
        final PhotoDb photoDb = new PhotoDb(null, photo.getTitle(), photo.getUrl());
        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.listview_photo, null);
            holder = new ViewHolder();
            holder.tvTitle = view.findViewById(R.id.tvTitle);
            holder.ivPhoto = view.findViewById(R.id.ivPhoto);
            view.findViewById(R.id.btnAddPhoto).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mPhotoItemListener.onAddClick(photoDb);
                }
            });
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.tvTitle.setText(photo.getTitle());
        Glide.with(this.mContext)
                .load(photo.getUrl())
                .into(holder.ivPhoto);

        return view;
    }

    static class ViewHolder {
        TextView tvTitle;
        ImageView ivPhoto;
    }

    public interface PhotoItemListener {
        void onAddClick(PhotoDb photoDb);
    }
}
