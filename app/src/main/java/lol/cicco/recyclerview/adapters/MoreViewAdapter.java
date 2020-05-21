package lol.cicco.recyclerview.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import lol.cicco.recyclerview.R;
import lol.cicco.recyclerview.bean.MoreTypeEntity;

public class MoreViewAdapter extends RecyclerView.Adapter {
    private List<MoreTypeEntity> data;

    private static final int FULL_IMAGE = 1;
    private static final int RIGHT_IMAGE = 2;
    private static final int THREE_IMAGE = 3;

    public MoreViewAdapter(List<MoreTypeEntity> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case FULL_IMAGE:
                return new FullImageHolder(View.inflate(parent.getContext(), R.layout.item_full_image, null));
            case RIGHT_IMAGE:
                return new RightImageHolder(View.inflate(parent.getContext(), R.layout.item_right_image, null));
            case THREE_IMAGE:
                return new ThreeImageHolder(View.inflate(parent.getContext(), R.layout.item_three_image, null));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof FullImageHolder) {
            ((FullImageHolder) holder).setItem(data.get(position));
        }
        if(holder instanceof RightImageHolder) {
            ((RightImageHolder) holder).setItem(data.get(position));
        }
        if(holder instanceof ThreeImageHolder) {
            ((ThreeImageHolder) holder).setItem(data.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).type;
    }

    private static class FullImageHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        FullImageHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.morePicItem);
        }

        void setItem(MoreTypeEntity moreTypeEntity) {
            this.imageView.setImageResource(moreTypeEntity.pic);
        }
    }

    private static class RightImageHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;

        RightImageHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.rightItemImageView);
            textView = itemView.findViewById(R.id.rightItemTextView);
        }

        void setItem(MoreTypeEntity moreTypeEntity) {
            this.imageView.setImageResource(moreTypeEntity.pic);
            this.textView.setText("类型为:" +moreTypeEntity.type);
        }
    }

    private static class ThreeImageHolder extends RecyclerView.ViewHolder {

        private ImageView imageView1;
        private ImageView imageView2;
        private ImageView imageView3;
        ThreeImageHolder(@NonNull View itemView) {
            super(itemView);

            this.imageView1 = itemView.findViewById(R.id.threeImage1);
            this.imageView2 = itemView.findViewById(R.id.threeImage2);
            this.imageView3 = itemView.findViewById(R.id.threeImage3);
        }

        public void setItem(MoreTypeEntity moreTypeEntity) {
            this.imageView1.setImageResource(moreTypeEntity.pic);
            this.imageView2.setImageResource(moreTypeEntity.pic2);
            this.imageView3.setImageResource(moreTypeEntity.pic3);
        }
    }
}
