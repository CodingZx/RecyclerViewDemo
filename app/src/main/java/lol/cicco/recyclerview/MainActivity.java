package lol.cicco.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.LinkedList;
import java.util.List;

import lol.cicco.recyclerview.adapters.GridViewAdapter;
import lol.cicco.recyclerview.adapters.ListViewAdapter;
import lol.cicco.recyclerview.adapters.StaggerViewAdapter;
import lol.cicco.recyclerview.bean.ItemEntity;

import static androidx.recyclerview.widget.RecyclerView.HORIZONTAL;
import static androidx.recyclerview.widget.RecyclerView.VERTICAL;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;

    private List<ItemEntity> dataList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.recyclerView = findViewById(R.id.recyclerView);
        final SwipeRefreshLayout swipeRefreshLayout = findViewById(R.id.refreshLayout);

        initData();
        showList(VERTICAL, false);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // 下拉刷新
                ItemEntity itemEntity = new ItemEntity();
                itemEntity.title = "我是新添加的数据";
                itemEntity.icon = R.mipmap.add;
                dataList.add(0, itemEntity);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 1000);
            }
        });

    }


    private void initData() {
        for (int i = 0; i < 10; i++) {
            for (int z = 0; z < Datas.icons.length; z++) {
                ItemEntity itemEntity = new ItemEntity();
                itemEntity.icon = Datas.icons[z];
                itemEntity.title = "我是第-" + (z+1)+"-条";
                dataList.add(itemEntity);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            // ListView效果
            case R.id.listViewItemVerticalStander: // 垂直标准
                showList(VERTICAL, false);
                break;
            case R.id.listViewItemVerticalReverse: // 垂直反向
                showList(VERTICAL, true);
                break;
            case R.id.listViewItemHorizontalStander: // 水平标准
                showList(HORIZONTAL, false);
                break;
            case R.id.listViewItemHorizontalReverse: // 水平反向
                showList(HORIZONTAL, true);
                break;

            // GridView效果
            case R.id.gridViewItemVerticalStander: // 垂直标准
                showGrid(VERTICAL, false);
                break;
            case R.id.gridViewItemVerticalReverse:// 垂直反向
                showGrid(VERTICAL, true);
                break;
            case R.id.gridViewItemHorizontalStander:// 水平标准
                showGrid(HORIZONTAL, false);
                break;
            case R.id.gridViewItemHorizontalReverse:// 水平反向
                showGrid(HORIZONTAL, true);
                break;

            // 瀑布流效果
            case R.id.staggerViewItemVerticalStander:// 垂直标准
                showStagger(VERTICAL, false);
                break;
            case R.id.staggerViewItemVerticalReverse:// 垂直反向
                showStagger(VERTICAL, true);
                break;
            case R.id.staggerViewItemHorizontalStander:// 水平标准
                showStagger(HORIZONTAL, false);
                break;
            case R.id.staggerViewItemHorizontalReverse:// 水平反向
                showStagger(HORIZONTAL, true);
                break;
                
            case R.id.allModuleView:
                showAllModule();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showAllModule() {
        Intent intent = new Intent(this, MoreItemActivity.class);
        startActivity(intent);
    }

    private void showStagger(int orientation, boolean reverseLayout) {
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, orientation);
        layoutManager.setReverseLayout(reverseLayout); // 正向还是反向
        recyclerView.setLayoutManager(layoutManager);

        adapter = new StaggerViewAdapter(dataList);
        recyclerView.setAdapter(adapter);
    }

    private void showGrid(int orientation, boolean reverseLayout) {
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        layoutManager.setOrientation(orientation); // 垂直还是水平
        layoutManager.setReverseLayout(reverseLayout); // 正向还是反向
        recyclerView.setLayoutManager(layoutManager);
        // 绑定适配器
        adapter = new GridViewAdapter(dataList);
        recyclerView.setAdapter(adapter);
    }

    private void showList(int orientation, boolean reverseLayout) {
        // 设置样式
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(orientation); // 垂直还是水平
        layoutManager.setReverseLayout(reverseLayout); // 正向还是反向
        recyclerView.setLayoutManager(layoutManager);

        // 绑定适配器
        adapter = new ListViewAdapter(dataList);
        recyclerView.setAdapter(adapter);
    }

}
