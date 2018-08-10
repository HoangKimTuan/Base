package com.tuanhk.ui.main;

import com.tuanhk.data.network.model.Album;
import com.tuanhk.data.network.model.Post;
import com.tuanhk.ui.base.BaseMvpView;

import java.util.List;

/**
 * Created by cpu10225 on 17/11/2017.
 */

public interface MainMvpView extends BaseMvpView {
    void showError(String message);
    void showComplete();
    void showPost(List<Post> posts);
    void showAlbum(List<Album> albums);
}
