package com.example.icestone.democloneinstagram.view;

import android.content.Context;
import android.text.Html;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.icestone.democloneinstagram.R;
import com.example.icestone.democloneinstagram.model.InstagramComment;
import com.example.icestone.democloneinstagram.model.InstagramPost;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by IceStone on 3/14/2016.
 */
public class InstagramPostsAdapter extends ArrayAdapter<InstagramPost> {

    // implement the ViewHolder pattern
    static class ViewHolder {
        @Bind(R.id.text_caption) TextView caption;

        @Bind(R.id.image_post) ImageView imageView;

        @Bind(R.id.circle_image_profile) ImageView profilePicture;

        @Bind(R.id.text_username) TextView userNameTextView;

        @Bind(R.id.text_likes) TextView likesCountTextView;

        @Bind(R.id.text_timestamp) TextView timeStampTextView;

        @Bind(R.id.image_heart) ImageView likeHeartImageView;

        @Bind(R.id.text_firstcomment) TextView firstComment;

        @Bind(R.id.text_secondcomment) TextView secondComment;

        int imageWidth;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    public InstagramPostsAdapter(Context context, List<InstagramPost> instagramPhotos) {
        super(context, R.layout.item_photo, instagramPhotos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        InstagramPost post = getItem(position);

        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_photo, parent, false);
            viewHolder = new ViewHolder(convertView);
            viewHolder.imageWidth = DeviceDimensionsHelper.getDisplayWidth(getContext()); // avoid re-calculating
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            prepareViewForReUse(viewHolder);
        }

        setupUserName(post.getUser().getUserName(), viewHolder.userNameTextView);
        setupTimeStamp(post.getCreatedTime(), viewHolder.timeStampTextView);
        setupLikesCount(post.getLikeCount(), viewHolder.likesCountTextView);
        setupCommentsForPost(post.getComments(), viewHolder);
        setCommentText(post.getUser().getUserName(), post.getCaption(), viewHolder.caption);

        // To Do - can't this be sized correctly in the XML without using Picasso
        // to resize this drawable?
        Picasso.with(getContext())
                .load(R.drawable.like_heart)
                .resize(20, 0)
                .into(viewHolder.likeHeartImageView);

        Picasso.with(getContext())
                .load(post.getImageURL())
                .placeholder(R.drawable.photo_placeholder)
                .resize(viewHolder.imageWidth, 0)
                .into(viewHolder.imageView);

        Picasso.with(getContext())
                .load(post.getUser().profilePicture())
                .resize(50, 50)
                .into(viewHolder.profilePicture);

        return convertView;
    }

    /**
     * Prepare a cached view for reuse by clearing out appropriate fields
     * @param viewHolder
     */
    private void prepareViewForReUse(ViewHolder viewHolder) {
        viewHolder.imageView.setImageResource(0); // clear cached data
        viewHolder.secondComment.setText("");
        viewHolder.firstComment.setText("");
        viewHolder.caption.setText("");
    }

    private void setupUserName(final String userName, TextView userNameTextView) {
        userNameTextView.setText(userName);
    }

    private void setCommentText(final String userName, final String comment, TextView textView) {
        // To Do - make this smarter - tokenizing all words beginning with '@' or '#'
        int pos = comment.indexOf("#");
        String htmlCaption = getContext().
                getResources().
                getString(R.string.htmlFormattedComment,
                        userName,
                        (pos > 0) ? comment.substring(0, pos) : comment,
                        (pos > 0) ? comment.substring(pos) : "");
        textView.setText(Html.fromHtml(htmlCaption));
    }

    private void setupLikesCount(final int numberOfLikes, TextView likesCountTextView) {
        String numberOfLikesString = getContext().getResources().getQuantityString(R.plurals.numberOfLikes, numberOfLikes, numberOfLikes);
        likesCountTextView.setText(numberOfLikesString);
    }

    private void setupCommentsForPost(final List<InstagramComment> comments, final ViewHolder viewHolder) {
        if (comments.size() > 1) {
            setCommentText(comments.get(comments.size() - 1).getUser().getUserName(), comments.get(comments.size() - 1).getText(), viewHolder.secondComment);
        }

        if (comments.size() > 2) {
            setCommentText(comments.get(comments.size() - 2).getUser().getUserName(), comments.get(comments.size() - 2).getText(), viewHolder.firstComment);
        }
    }

    private void setupTimeStamp(final long postCreatedTime, final TextView timeStampTextView) {
        // convert the time stamp into a short relative date like 4h or 2 days
        CharSequence formattedDate = DateUtils.getRelativeTimeSpanString(postCreatedTime* DateUtils.SECOND_IN_MILLIS,
                System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS, DateUtils.FORMAT_ABBREV_ALL);
        timeStampTextView.setText(formattedDate);
    }
}
