package com.example.ActionBarDemo;

import java.util.Locale;

import android.app.Activity;
import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.MenuDemo.DummyFragment;
import com.example.hoperun.myapplication.R;

public class ActionBar_swipeNav extends FragmentActivity implements ActionBar.TabListener {

    ViewPager viewPager;
    ActionBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_swipe_nav);
        bar = getActionBar();
        viewPager = (ViewPager) findViewById(R.id.pager);
        //创建一个FragmentPagerAdapter对象，该对象负责为ViewPager提供多个Fragment
        FragmentPagerAdapter pagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                Fragment fragment = new CustomFragment();
                Bundle bundle = new Bundle();
                bundle.putInt(CustomFragment.ARG_CUSTOM_NUMBER, i + 1);
                fragment.setArguments(bundle);

                return fragment;
            }

            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return "第一页"+position;
                    case 1:
                        return "第二页"+position;
                    case 2:
                        return "第三页"+position;
                }
                return null;
            }
        };
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        //遍历pageAdapter对象所包含的全部Fragment
        //每个Fragment对应创建一个tab便签
        for (int i = 0; i < pagerAdapter.getCount(); i++){
            bar.addTab(bar.newTab().setText(pagerAdapter.getPageTitle(i)).setTabListener(this));
        }
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                bar.setSelectedNavigationItem(position);
            }
        });
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
