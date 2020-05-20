package lol.cicco.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                break;
            case R.id.listViewItemVerticalReverse: // 垂直反向
                break;
            case R.id.listViewItemHorizontalStander: // 水平标准
                break;
            case R.id.listViewItemHorizontalReverse: // 水平反向
                break;

            // GridView效果
            case R.id.gridViewItemVerticalStander: // 垂直标准
                break;
            case R.id.gridViewItemVerticalReverse:// 垂直反向
                break;
            case R.id.gridViewItemHorizontalStander:// 水平标准
                break;
            case R.id.gridViewItemHorizontalReverse:// 水平反向
                break;

            // 瀑布流效果
            case R.id.staggerViewItemVerticalStander:// 垂直标准
                break;
            case R.id.staggerViewItemVerticalReverse:// 垂直反向
                break;
            case R.id.staggerViewItemHorizontalStander:// 水平标准
                break;
            case R.id.staggerViewItemHorizontalReverse:// 水平反向
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
