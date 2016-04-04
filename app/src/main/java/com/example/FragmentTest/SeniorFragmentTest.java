 package com.example.FragmentTest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;

import com.example.hoperun.myapplication.R;

public class SeniorFragmentTest extends Activity implements BookListFragment.Callbacks{

    //定义一个旗标，用于标识应用是否支持大屏幕
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_fragment_test);
        if (findViewById(R.id.book_detail_container) != null){
            mTwoPane = true;
            ((BookListFragment)getFragmentManager().findFragmentById(R.id.book_list))
                    .setActivateOnItemClick(true);
        }
    }


    @Override
    public void onItemSelected(Integer id) {
        if(mTwoPane){
            Bundle bundle = new Bundle();
            bundle.putInt(BookDetailFragment.ITEM_ID,id);
            BookDetailFragment fragment = new BookDetailFragment();
            fragment.setArguments(bundle);
            getFragmentManager().beginTransaction()
                    .replace(R.id.book_detail_container,fragment).commit();
        }else {
            Intent intent = new Intent(this,BookDetailActivity.class);
            intent.putExtra(BookDetailFragment.ITEM_ID,id);
            startActivity(intent);
        }
    }
}
