package com.example.ActionBarDemo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hoperun.myapplication.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class AsyncTaskTest extends Activity {

    private TextView show;
    private Button download;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_test);
        show = (TextView) findViewById(R.id.showTxt);
        download = (Button) findViewById(R.id.btnDownload);
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownTask task = new DownTask(AsyncTaskTest.this);
                try {
                    task.execute(new URL("http://www.crazyit.org/ethos.php"));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    class DownTask extends AsyncTask<URL, Integer, String> {

        //可变长的输入参数，与AsyncTask.execute（）对应
        ProgressDialog dialog;
        int hasData = 0;
        Context context;

        public DownTask(Context ctx) {
            context = ctx;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(context);
            dialog.setTitle("任务正在执行中");
            dialog.setMessage("任务正在执行中---，敬请等待");
            //设置对话框不能用取消按钮关闭
            dialog.setMax(202);
            dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            dialog.setIndeterminate(false);
            dialog.show();
        }

        @Override
        protected String doInBackground(URL... params) {

            StringBuilder sb = new StringBuilder();
            try {
                URLConnection connection = params[0].openConnection();
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                    hasData++;
                    publishProgress(hasData);
                }
                return sb.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            show.setText("已经读取了[" + values[0] + "]行！");
            dialog.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            show.setText(s);
            dialog.dismiss();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_async_task_test, menu);
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
