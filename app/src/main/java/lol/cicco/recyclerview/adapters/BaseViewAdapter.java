package lol.cicco.recyclerview.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import lol.cicco.recyclerview.bean.ItemEntity;

public abstract class BaseViewAdapter extends RecyclerView.Adapter<BaseViewAdapter.InnerHolder> {
    private final List<ItemEntity> items;
    BaseViewAdapter(List<ItemEntity> items){
        this.items = items;
    }

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = getLayoutView(parent);
        return new InnerHolder(view, getImageViewId(), getTextViewId());
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        holder.setData(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    protected abstract View getLayoutView(ViewGroup viewGroup);

    protected abstract int getImageViewId();

    protected abstract int getTextViewId();

    static class InnerHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;

        InnerHolder(@NonNull View itemView, int imageViewId, int textViewId) {
            super(itemView);

            imageView = itemView.findViewById(imageViewId);
            textView = itemView.findViewById(textViewId);
        }

        void setData(ItemEntity itemEntity) {
            imageView.setImageResource(itemEntity.icon);
            textView.setText(itemEntity.title);
        }
    }
}
