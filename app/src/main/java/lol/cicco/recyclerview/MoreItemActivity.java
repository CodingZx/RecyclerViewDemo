package lol.cicco.recyclerview;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lol.cicco.recyclerview.adapters.MoreViewAdapter;
import lol.cicco.recyclerview.bean.MoreTypeEntity;

public class MoreItemActivity extends AppCompatActivity {

    private static final Random RANDOM = new Random();

    private List<MoreTypeEntity> allItems = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        RecyclerView view = findViewById(R.id.moreRecyclerView);

        initData();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        view.setLayoutManager(layoutManager);

        view.setAdapter(new MoreViewAdapter(allItems));
    }

    private void initData() {
        for (int i = 0; i < Datas.icons.length; i++) {
            MoreTypeEntity moreTypeEntity = new MoreTypeEntity();
            moreTypeEntity.pic = Datas.icons[i];
            moreTypeEntity.type = (i % 3) + 1;
            if(moreTypeEntity.type == 3) {
                moreTypeEntity.pic2 = Datas.icons[nextInt(0,Datas.icons.length)];
                moreTypeEntity.pic3 = Datas.icons[nextInt(0,Datas.icons.length)];
            }
            allItems.add(moreTypeEntity);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public static int nextInt(int startInclusive, int endExclusive) {
        return startInclusive == endExclusive ? startInclusive : startInclusive + RANDOM.nextInt(endExclusive - startInclusive);
    }
}
