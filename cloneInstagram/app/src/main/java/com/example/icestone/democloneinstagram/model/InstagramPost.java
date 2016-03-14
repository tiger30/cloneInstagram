package com.example.icestone.democloneinstagram.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by IceStone on 3/14/2016.
 */
public class InstagramPost {
    private InstagramUser user;
    private Likes likes;
    private Images images;
    private Videos videos;
    private Caption caption;
    private long createdTime;

    @SerializedName("comments")
    private CommentsCollection commentsCollection;


    public InstagramUser getUser() {
        return user;
    }

    public String getCaption() {
        return caption != null ? caption.text : "";
    }

    public int getLikeCount() {
        return likes.count;
    }

    public String getImageURL() {
        return images.image.url;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public List<InstagramComment> getComments() {
        return commentsCollection.comments;
    }

    public InstagramVideo getVideo() {
        if (videos != null) {
            return videos.video;
        } else {
            return null;
        }
    }

    // boiler plate classes required for GSON to auto create our model objects

    private class Likes {
        int count;
    }

    private class Caption {
        String text;
    }

    private class CommentsCollection {
        @SerializedName("data")
        List<InstagramComment> comments;
    }

    private class Videos {
        @SerializedName("standard_resolution")
        InstagramVideo video;
    }

    private class Images {
        private class Image {
            String url;
        }

        @SerializedName("standard_resolution")
        Image image;
    }
}
