package com.example.FragmentTest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.hoperun.myapplication.R;

public class FragmentTest extends Activity implements BookListFragment.Callbacks{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);
    }

    @Override
    public void onItemSelected(Integer id) {
        Bundle bundle = new Bundle();
        bundle.putInt(BookDetailFragment.ITEM_ID,id);
        //创建BookDetailFragment对象
        BookDetailFragment fragment = new BookDetailFragment();
        fragment.setArguments(bundle);
        //使用fragment替换book_detail_container容器当前显示的Fragment
        getFragmentManager().beginTransaction()
                .replace(R.id.book_detail_container,fragment).commit();
    }
}
