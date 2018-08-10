package com.tuanhk.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tuanhk.R;
import com.tuanhk.data.network.model.Album;

import java.util.List;

/**
 * Created by cpu10225 on 24/11/2017.
 */

public class AlbumAdapter extends BaseAdapter {
    private List<Album> mAlbumList;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public AlbumAdapter(List<Album> albumList, Context context) {
        this.mAlbumList = albumList;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mAlbumList.size();
    }

    @Override
    public Object getItem(int i) {
        return mAlbumList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        AlbumAdapter.ViewHolder holder;
        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.listview_album, null);
            holder = new AlbumAdapter.ViewHolder();
            holder.tvTitleAlbum = view.findViewById(R.id.tvTitleAlbum);
            view.setTag(holder);
        } else {
            holder = (AlbumAdapter.ViewHolder) view.getTag();
        }

        Album album = this.mAlbumList.get(i);
        holder.tvTitleAlbum.setText(album.getTitle());

        return view;
    }

    static class ViewHolder {
        TextView tvTitleAlbum;
    }
}
