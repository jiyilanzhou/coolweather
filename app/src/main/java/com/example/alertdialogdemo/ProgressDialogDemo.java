package com.example.alertdialogdemo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.hoperun.myapplication.R;

public class ProgressDialogDemo extends Activity {

    final static int MAX_PROGRESS = 100;
    private int[] data = new int[100];

    int progressStatus = 0;
    int hasData = 0;
    ProgressDialog pd1, pd2;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0x123) {
                pd2.setProgress(progressStatus);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_dialog_demo);
        Button showSpinner = (Button) findViewById(R.id.showSpinner);
        Button showIndeterminate = (Button) findViewById(R.id.showIndeterminate);
        Button showProgress = (Button) findViewById(R.id.showProgress);

        showSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog.show(ProgressDialogDemo.this, "任务执行中", "任务正在执行，请稍等一下",
                        false, true);
            }
        });

        showIndeterminate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd1 = new ProgressDialog(ProgressDialogDemo.this);
                pd1.setTitle("任务正在执行");
                pd1.setMessage("任务正在执行，敬请稍等。。。。");
                pd1.setCancelable(false);
                pd1.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                pd1.setIndeterminate(true);
                pd1.show();
            }
        });

        showProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd2 = new ProgressDialog(ProgressDialogDemo.this);
                pd2.setMax(MAX_PROGRESS);
                pd2.setTitle("任务完成的百分比");
                pd2.setMessage("耗时任务完成的百分比");
                pd2.setCancelable(true);
                pd2.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                pd2.setIndeterminate(false);
                pd2.show();
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        while (progressStatus < MAX_PROGRESS) {
                            progressStatus = doWork();
                            handler.sendEmptyMessage(0x123);
                        }
                        if (progressStatus == 100)
                            pd2.dismiss();
                    }
                }.start();
            }
        });
    }

    private int doWork() {
        data[hasData++] = (int) (Math.random() * 100);
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
        getMenuInflater().inflate(R.menu.menu_progress_dialog_demo, menu);
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
