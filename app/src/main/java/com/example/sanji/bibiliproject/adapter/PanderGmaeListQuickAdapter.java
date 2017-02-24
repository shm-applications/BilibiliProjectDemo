package com.example.sanji.bibiliproject.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.sanji.bibiliproject.R;
import com.example.sanji.bibiliproject.bean.PanderGameListBean;
import com.example.sanji.bibiliproject.utils.NumberUtil;

import java.util.List;

import retrofit2.Callback;

/**
 * Created by sanji on 2017/2/21.
 */

public class PanderGmaeListQuickAdapter extends BaseItemDraggableAdapter<PanderGameListBean.DataBean.ItemsBean, BaseViewHolder> {


    public PanderGmaeListQuickAdapter(int layoutResId, List<PanderGameListBean.DataBean.ItemsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, PanderGameListBean.DataBean.ItemsBean item) {
        holder.setText(R.id.pander_game_list_tv, item.getName());
        Glide.with(mContext).load(item.getPictures().getImg())
                .crossFade()//淡入
                .diskCacheStrategy(DiskCacheStrategy.RESULT)//缓存
                .placeholder(R.drawable.ic_next_video_placeholder)//站位
                .error(R.drawable.img_tips_error_banner_tv)//错误
                .into((ImageView) holder.getView(R.id.pander_game_list_img));
        holder.setText(R.id.pander_game_list_tv_name, item.getUserinfo().getNickName());
        holder.setText(R.id.pander_game_list_tv_count, NumberUtil.getNumWan(Integer.valueOf(item.getPerson_num())));
        holder.addOnClickListener(R.id.item_pander_game_list);
    }


}
