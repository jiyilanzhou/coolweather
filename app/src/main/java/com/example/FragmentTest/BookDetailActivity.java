package com.example.FragmentTest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.hoperun.myapplication.R;

public class BookDetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        if (savedInstanceState == null){
            BookDetailFragment fragment = new BookDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(BookDetailFragment.ITEM_ID,getIntent()
                    .getIntExtra(BookDetailFragment.ITEM_ID,0));
            fragment.setArguments(bundle);
            getFragmentManager().beginTransaction()
                    .add(R.id.rl_book_detail,fragment).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_book_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            Intent intent = new Intent(BookDetailActivity.this,SeniorFragmentTest.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
