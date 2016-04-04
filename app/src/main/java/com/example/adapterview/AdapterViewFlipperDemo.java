package com.example.adapterview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.hoperun.myapplication.R;

public class AdapterViewFlipperDemo extends Activity {

    int[] imageIds = new int[]{
            R.drawable.shuangzi, R.drawable.shuangyu, R.drawable.chunv,
            R.drawable.tiancheng, R.drawable.tianxie, R.drawable.sheshou,
            R.drawable.juxie, R.drawable.shuiping, R.drawable.shizi,
            R.drawable.baiyang, R.drawable.jinniu, R.drawable.mojie
    };
    private AdapterViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_view_flipper_demo);
        flipper = (AdapterViewFlipper) findViewById(R.id.flipper);

        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return imageIds.length;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageView = new ImageView(AdapterViewFlipperDemo.this);
                imageView.setImageResource(imageIds[position]);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));

                return imageView;
            }
        };
        flipper.setAdapter(adapter);
    }

    public void prev(View source) {
        flipper.showPrevious();
        flipper.stopFlipping();
    }

    public void next(View source) {
        flipper.showNext();
        flipper.stopFlipping();
    }

    public void auto(View source) {
        flipper.startFlipping();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_adapter_view_flipper_demo, menu);
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
