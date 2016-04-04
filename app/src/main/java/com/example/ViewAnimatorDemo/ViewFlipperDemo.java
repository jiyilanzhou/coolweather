package com.example.ViewAnimatorDemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

import com.example.hoperun.myapplication.R;

public class ViewFlipperDemo extends Activity {

    private ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flipper_demo);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        Button btn1 = (Button) findViewById(R.id.btnPrev);
        Button btn2 = (Button) findViewById(R.id.btnAuto);
        Button btn3 = (Button) findViewById(R.id.btnNext);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.setInAnimation(ViewFlipperDemo.this,R.anim.slide_in_right);
                viewFlipper.setOutAnimation(ViewFlipperDemo.this,R.anim.slide_in_left);
                //显示上一个组件
                viewFlipper.showPrevious();
                //停止自动播放
                viewFlipper.stopFlipping();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.setInAnimation(ViewFlipperDemo.this,android.R.anim.slide_in_left);
                viewFlipper.setOutAnimation(ViewFlipperDemo.this,android.R.anim.slide_out_right);
                viewFlipper.showNext();
                viewFlipper.stopFlipping();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.setInAnimation(ViewFlipperDemo.this,android.R.anim.slide_in_left);
                viewFlipper.setOutAnimation(ViewFlipperDemo.this,android.R.anim.slide_out_right);
                //开始自动播放
                viewFlipper.startFlipping();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_flipper_demo, menu);
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
