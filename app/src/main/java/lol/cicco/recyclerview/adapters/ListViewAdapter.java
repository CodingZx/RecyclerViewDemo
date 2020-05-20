package lol.cicco.recyclerview.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import lol.cicco.recyclerview.R;
import lol.cicco.recyclerview.bean.ItemEntity;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.InnerHolder> {

    private List<ItemEntity> items;
    public ListViewAdapter(List<ItemEntity> items){
        this.items = items;
    }

    /**
     * 用于创建条目View
     */
    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_list_activity, null);
        return new InnerHolder(view);
    }

    /**
     * 用于绑定Holder
     */
    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        holder.setData(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    // Holder实现类
    public class InnerHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.itemImageView);
            textView = itemView.findViewById(R.id.itemTextView);
        }

        public void setData(ItemEntity itemEntity) {
            imageView.setImageResource(itemEntity.icon);
            textView.setText(itemEntity.title);
        }
    }

}
