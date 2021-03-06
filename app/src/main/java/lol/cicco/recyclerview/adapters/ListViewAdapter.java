package lol.cicco.recyclerview.adapters;

import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import lol.cicco.recyclerview.R;
import lol.cicco.recyclerview.bean.ItemEntity;

public class ListViewAdapter extends BaseViewAdapter {

    public ListViewAdapter(List<ItemEntity> items){
        super(items);
    }

    @Override
    protected View getLayoutView(ViewGroup viewGroup) {
        return View.inflate(viewGroup.getContext(), R.layout.item_list_activity, null);
    }

    @Override
    protected int getImageViewId() {
        return R.id.listItemImageView;
    }

    @Override
    protected int getTextViewId() {
        return R.id.listItemTextView;
    }

}
