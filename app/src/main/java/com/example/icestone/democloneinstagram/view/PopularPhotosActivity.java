package com.example.icestone.democloneinstagram.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.example.icestone.democloneinstagram.R;
import com.example.icestone.democloneinstagram.model.InstagramPost;
import com.example.icestone.democloneinstagram.model.InstagramPostsResponse;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import cz.msebera.android.httpclient.Header;

public class PopularPhotosActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private static final String INSTAGRAM_CLIENTID = "e05c462ebd86446ea48a5af73769b602";
    private static final String INSTAGRAM_POPULAR_PHOTO_URL = "https://api.instagram.com/v1/media/popular/?client_id=";

    @Bind(R.id.list_posts)
    ListView listViewPosts;
    @Bind(R.id.swiperefresh_container)
    SwipeRefreshLayout swipeRefreshLayout;

    private List<InstagramPost> mPosts;
    private InstagramPostsAdapter mPostsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_photos);
        ButterKnife.bind(this);

        mPosts = new ArrayList<>();
        mPostsAdapter = new InstagramPostsAdapter(this, mPosts);
        listViewPosts.setAdapter(mPostsAdapter);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setNestedScrollingEnabled(true);

        // send out an api request to popular mPosts
        // On cold launch our refresh animation wont' fire unless it's done
        // outside of onCreate...
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                fetchPopularPosts();
            }
        });

    }

    @Override
    public void onRefresh() {
        fetchPopularPosts();
    }

    public void fetchPopularPosts() {
        swipeRefreshLayout.setRefreshing(true);
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(PopularPhotosActivity.INSTAGRAM_POPULAR_PHOTO_URL + PopularPhotosActivity.INSTAGRAM_CLIENTID, null, new TextHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, String response) {
                Log.i("DEBUG", response.toString());
                mPosts.clear();
                mPosts.addAll(InstagramPostsResponse.parseJSON(response).posts);
                mPostsAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                // Do something useful
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @OnItemClick(R.id.list_posts)
    public void onLoadVideo(int position) {
        InstagramPost post = mPostsAdapter.getItem(position);
        if (post.getVideo() != null) {
            Intent intent = FullScreenVideoActivity.getStartIntent(this, post.getVideo().getUrl());
            startActivity(intent);
        }
    }
}