package com.example.MixComponent;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.hoperun.myapplication.R;

public class SearchViewDemo extends Activity {

    private SearchView searchView;
    private ListView listView;
    private final String[] mStrings = {"aaaaa", "bbbbb", "ccccc"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view_demo);
        listView = (ListView) findViewById(R.id.lv);
        searchView = (SearchView) findViewById(R.id.sv);

        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStrings));
        //设置ListView启动过滤
        listView.setTextFilterEnabled(true);

        searchView.setIconifiedByDefault(true);
        //设置SearchView显示搜索按钮
        searchView.setSubmitButtonEnabled(true);
        //设置该SearchView默认显示的提示文本
        searchView.setQueryHint("查找");
        //为SearchView绑定时间监听器
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //单击搜索按钮时激发该方法
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(SearchViewDemo.this, "您的选择是：" + query, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText))
                    listView.clearTextFilter();
                else
                    //使用用户输入的内容对ListView的列表项进行过滤
                    listView.setFilterText(newText);
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search_view_demo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
