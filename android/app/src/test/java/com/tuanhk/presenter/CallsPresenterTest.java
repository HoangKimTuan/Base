package com.tuanhk.presenter;

import com.tuanhk.data.api.entity.Post;
import com.tuanhk.data.cache.AppStore;
import com.tuanhk.home.calls.CallsPresenter;
import com.tuanhk.home.calls.ICallsView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;

import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CallsPresenterTest {

    @InjectMocks
    private CallsPresenter mPresenter;

    @Mock
    private AppStore.Repository repository;

    @Mock
    private ICallsView mView;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        Post post = new Post(0, "title", "body");
        List<Post> posts = new ArrayList<>();
        posts.add(post);

        when(repository.getPostList())
                .thenReturn(Observable.just(posts));

        RxJavaPlugins.setIoSchedulerHandler(scheduler -> Schedulers.trampoline());
        RxAndroidPlugins.setMainThreadSchedulerHandler(scheduler -> Schedulers.trampoline());
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(schedulerCallable -> Schedulers.trampoline());
    }

    @Test
    public void testLoadPost() {
        reset(mView);
        mPresenter.loadPost();
    }

    @Test
    public void demo() {
        Assert.assertEquals(mPresenter.a(), 2);
    }
}
