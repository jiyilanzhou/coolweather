package com.example.progressbardemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.hoperun.myapplication.R;

public class ProgressBarDemo extends Activity implements View.OnClickListener {

    private int[] data = new int[100];
    int hasData = 0;
    int status = 0;
    ProgressBar bar1,bar2;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what == 0x111){
                bar1.setProgress(status);
                bar2.setProgress(status);
            }
            super.handleMessage(msg);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar_demo);

        bar1 = (ProgressBar) findViewById(R.id.bar);
        bar2 = (ProgressBar) findViewById(R.id.bar2);
        Button btn1 = (Button) findViewById(R.id.btnProgress1);
        Button btn2 = (Button) findViewById(R.id.btnProgress2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        new Thread(){
            @Override
            public void run() {
                super.run();
                while(status < 100){
                    status = doWork();
                    handler.sendEmptyMessage(0x111);
                }
            }
        }.start();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnProgress1:
                startActivity(new Intent(this, ProgeressBarTitleDemo.class));
                break;
            case R.id.btnProgress2:
                startActivity(new Intent(this, SeekBarDemo.class));
                break;
        }
    }
    private int doWork() {
        data[hasData++] = ((int) (Math.random()*100));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return hasData;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_progress_bar_demo, menu);
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
