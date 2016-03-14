package com.example.icestone.democloneinstagram.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by IceStone on 3/14/2016.
 */
public class InstagramComment {
    @SerializedName("from") private InstagramUser user;
    private String text;

    public String getText() {
        return text;
    }

    public InstagramUser getUser() {
        return user;
    }
}
