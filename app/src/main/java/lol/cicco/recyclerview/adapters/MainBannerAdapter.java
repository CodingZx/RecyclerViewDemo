package lol.cicco.recyclerview.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.youth.banner.adapter.BannerAdapter;

import java.util.List;

import lol.cicco.recyclerview.bean.BannerEntity;

public class MainBannerAdapter extends BannerAdapter<BannerEntity, MainBannerAdapter.InnerViewHolder> {

    public MainBannerAdapter(List<BannerEntity> datas) {
        super(datas);
    }

    @Override
    public InnerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(parent.getContext());
        //注意，必须设置为match_parent，这个是viewpager2强制要求的
        imageView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new InnerViewHolder(imageView);
    }

    @Override
    public void onBindView(InnerViewHolder holder, BannerEntity data, int position, int size) {
        holder.imageView.setImageResource(data.resource);
    }

    public class InnerViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public InnerViewHolder(@NonNull ImageView itemView) {
            super(itemView);
            this.imageView = itemView;
        }
    }
}
