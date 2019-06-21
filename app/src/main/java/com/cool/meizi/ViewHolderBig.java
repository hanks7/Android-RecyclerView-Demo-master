package com.cool.meizi;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolderBig extends RecyclerView.ViewHolder {
    protected ConstraintLayout meiziItem;
    protected ImageView image;
    protected TextView title;
    protected TextView name;
    protected TextView favorites;
    protected TextView comments;

    ViewHolderBig(View itemView) {
        super(itemView);
        meiziItem = itemView.findViewById(R.id.meizi_item_big);
        image = itemView.findViewById(R.id.meizi_item_big_image);
        title = itemView.findViewById(R.id.meizi_item_big_title);
        name = itemView.findViewById(R.id.meizi_item_big_name);
        favorites = itemView.findViewById(R.id.meizi_item_big_favorites);
        comments = itemView.findViewById(R.id.meizi_item_big_comments);
    }
}
