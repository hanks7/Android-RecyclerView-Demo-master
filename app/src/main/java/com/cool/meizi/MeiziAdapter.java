package com.cool.meizi;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

public class MeiziAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Meizi> meizis;

    MeiziAdapter(Context context, List<Meizi> meizis) {
        this.context = context;
        this.meizis = meizis;
    }

    /**
     * @param position 根据 位置判断是那种布局,这里返回的是布局的id, 可以随意指定int值的.
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        return position % 3 == 0 ? R.layout.meizi_item_big : R.layout.meizi_item_small;
    }

    //在这里判断是哪个布局
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == R.layout.meizi_item_big) {
            return new ViewHolderBig(
                    inflater.inflate(R.layout.meizi_item_big, parent, false)
            );
        } else {
            return new ViewHolderSmall(
                    inflater.inflate(R.layout.meizi_item_small, parent, false)
            );
        }
    }

    //在这里赋值
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final Meizi meizi = meizis.get(position);

        if (position % 3 == 0) {
            ViewHolderBig holderBig = (ViewHolderBig) holder;

            Glide
                    .with(context)
                    .load(meizi.getImageUrl())
                    .into(holderBig.image);

            holderBig.title.setText(meizi.getTitle());
            holderBig.name.setText(meizi.getName());
            holderBig.favorites.setText(String.valueOf(meizi.getFavorites()));
            holderBig.comments.setText(String.valueOf(meizi.getComments()));

            holderBig.meiziItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startMeiziActivity(meizi);
                }
            });

        } else {
            ViewHolderSmall holderSmall = (ViewHolderSmall) holder;

            Glide
                    .with(context)
                    .load(meizi.getImageUrl())
                    .into(holderSmall.image);

            holderSmall.title.setText(meizi.getTitle());
            holderSmall.name.setText(meizi.getName());
            holderSmall.favorites.setText(String.valueOf(meizi.getFavorites()));
            holderSmall.comments.setText(String.valueOf(meizi.getComments()));

            holderSmall.meiziItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startMeiziActivity(meizi);
                }
            });
        }
    }

    //跳转界面
    private void startMeiziActivity(Meizi meizi) {
        Intent intent = new Intent(context, MeiziDetialActivity.class);
        intent.putExtra(MeiziDetialActivity.IMAGE_URL, meizi.getImageUrl());
        intent.putExtra(MeiziDetialActivity.TITLE, meizi.getTitle());
        intent.putExtra(MeiziDetialActivity.NAME, meizi.getName());
        intent.putExtra(MeiziDetialActivity.FAVORITES, meizi.getFavorites());
        intent.putExtra(MeiziDetialActivity.COMMENTS, meizi.getComments());
        context.startActivity(intent);
    }

    /**
     * item总共条数
     * @return
     */
    @Override
    public int getItemCount() {
        return meizis.size();
    }


}


