package com.example.icestone.democloneinstagram.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by IceStone on 3/14/2016.
 */
public class InstagramPhoto {
    public String getCaption() {
        return caption != null ? caption.text : "";
    }

    public int getLikeCount() {
        return likes.count;
    }

    public String getImageURL() {
        return images.image.url;
    }

    public int getImageHeight() {
        return images.image.height;
    }

    public String getUserName() {
        return user.username;
    }

    // boiler plate classes required for GSON integration
    private class User {
        String username;
    }

    private class Likes {
        int count;
    }

    private class Caption {
        String text;
    }

    private class Images {
        private class Image {
            String url;
            int height;
        }

        @SerializedName("standard_resolution")
        Image image;
    }

    User user;
    Likes likes;
    Images images;
    Caption caption;
}
