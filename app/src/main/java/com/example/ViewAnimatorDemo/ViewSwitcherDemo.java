package com.example.ViewAnimatorDemo;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.example.hoperun.myapplication.R;

import java.util.ArrayList;

public class ViewSwitcherDemo extends Activity {

    public static final int NUMBER_PER_SCREEN = 12;

    //代表应用程序的内部类
    public static class DataItem {
        //应用程序的名称
        public String dataName;
        //应用程序图标
        public Drawable drawable;
    }

    //保存系统所有应用程序的List集合
    private ArrayList<DataItem> items = new ArrayList<DataItem>();

    //记录当前正在显示第几屏的程序
    int screenNo = -1;

    //保存程序所占的总屏数
    private int screenCount;

    ViewSwitcher viewSwitcher;
    //创建LayoutInflater对象
    LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_switcher_demo);
        inflater = LayoutInflater.from(this);

        for (int i = 0; i < 40; i++) {

            String label = " " + i;
            Drawable drawable = getResources().getDrawable(R.drawable.ic_launcher);

            DataItem item = new DataItem();
            item.dataName = label;
            item.drawable = drawable;
            items.add(item);
        }

        screenCount = items.size() % NUMBER_PER_SCREEN == 0 ? items.size() / NUMBER_PER_SCREEN : items.size() / NUMBER_PER_SCREEN + 1;
        Log.d("TAG", "screenCount=" + screenCount);
        viewSwitcher = (ViewSwitcher) findViewById(R.id.viewSwitcher);
        viewSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            //实际上就是返回一个GirdView组件
            @Override
            public View makeView() {

                return inflater.inflate(R.layout.slidelistview, null);
            }
        });
        next(null);
    }

    public void next(View view) {
        if (screenNo < screenCount - 1) {
            screenNo++;
            //显示过程设置动画
            viewSwitcher.setInAnimation(this, R.anim.slide_in_right);
            //隐藏过程设置动画
            viewSwitcher.setOutAnimation(this, R.anim.slide_in_left);
            //控制下一屏要显示的GridView对应的Adapter
            ((GridView) viewSwitcher.getNextView()).setAdapter(adapter);
            viewSwitcher.showNext();
        }
    }

    public void prev(View view) {
        if (screenNo > 0) {
            screenNo--;
            viewSwitcher.setInAnimation(this, R.anim.slide_in_left);
            viewSwitcher.setOutAnimation(this, R.anim.slide_in_right);
            ((GridView) viewSwitcher.getNextView()).setAdapter(adapter);
            viewSwitcher.showPrevious();
        }
    }

    //该BaseAdapter负责为每屏显示的GridView提供列表项
    private BaseAdapter adapter = new BaseAdapter() {
        @Override
        public int getCount() {
            if (screenNo == screenCount - 1 && items.size() % NUMBER_PER_SCREEN != 0) {
                return items.size() % NUMBER_PER_SCREEN;
            }
            return NUMBER_PER_SCREEN;
        }

        @Override
        public DataItem getItem(int position) {

            return items.get(screenNo * NUMBER_PER_SCREEN + position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (convertView == null) {
                view = inflater.inflate(R.layout.lableicon, null);
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            imageView.setImageDrawable(getItem(position).drawable);
            TextView textView = (TextView) findViewById(R.id.textView1);
            Log.d("TAG","position="+position+"--screenNo="+screenNo);
            Log.d("TAG","getItem(position).dataName"+getItem(position).dataName);
//            if (null != getItem(position).dataName)
//                textView.setText(getItem(position).dataName);
            return view;
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_switcher_demo, menu);
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
