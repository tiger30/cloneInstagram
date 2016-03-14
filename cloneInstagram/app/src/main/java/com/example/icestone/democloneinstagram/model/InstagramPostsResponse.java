package com.example.icestone.democloneinstagram.model;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IceStone on 3/14/2016.
 */
public class InstagramPostsResponse {
    @SerializedName("data")
    public List<InstagramPost> posts;

    public InstagramPostsResponse() {
        posts = new ArrayList<>();
    }

    public static InstagramPostsResponse parseJSON(String response) {
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        InstagramPostsResponse instagramPostsResponse = gson.fromJson(response, InstagramPostsResponse.class);
        return instagramPostsResponse;
    }
}
