package com.chanchuan.demo;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author : Chanchuan
 * Date       : 2020/12/3/003    下午 1:43
 */
public class GankAdapter extends RecyclerView.Adapter<GankAdapter.ViewHolder> {
    Context mContext;
    List<GankBean.DataBean> mData;

    public GankAdapter(Context pContext, List<GankBean.DataBean> pData) {
        mContext = pContext;
        mData = pData;
    }

    @NonNull
    @Override
    public GankAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_gank, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GankAdapter.ViewHolder holder, int position) {
        GankBean.DataBean dataBean = mData.get(position);
        Uri uri = Uri.parse(dataBean.getUrl());
        holder.ivImage.setImageURI(uri);
//        Glide.with(mContext).load(dataBean.getUrl()).into(holder.mImageView);
//        ViewGroup.LayoutParams layoutParams = holder.ivImage.getLayoutParams();
//        layoutParams.height = layoutParams.height + new Random().nextInt(1000) + 800;
//        holder.ivImage.setLayoutParams(layoutParams);
        Animation animation = android.view.animation.AnimationUtils.loadAnimation(mContext, R.anim.recyclerview_anim);
        holder.itemView.setAnimation(animation);
        holder.ivImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnClick != null) {
                    mOnClick.itemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_image)
        SimpleDraweeView ivImage;
//        @BindView(R.id.image)
//        ImageView mImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnClick {
        void itemClick(int position);
    }

    OnClick mOnClick;

    public void setOnClick(OnClick pOnClick) {
        mOnClick = pOnClick;
    }
}
