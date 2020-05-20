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

public class GridViewAdapter extends RecyclerView.Adapter<GridViewAdapter.InnerHolder> {
    private List<ItemEntity> items;
    public GridViewAdapter(List<ItemEntity> items){
        this.items = items;
    }


    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_grid_activity, null);
        return new InnerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        holder.setData(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.gridItemImageView);
            textView = itemView.findViewById(R.id.gridItemTextView);
        }

        public void setData(ItemEntity itemEntity) {
            imageView.setImageResource(itemEntity.icon);
            textView.setText(itemEntity.title);
        }
    }
}
