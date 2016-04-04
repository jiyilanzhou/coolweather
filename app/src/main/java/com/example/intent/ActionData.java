package com.example.intent;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ClipDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.hoperun.myapplication.R;

import java.util.Timer;
import java.util.TimerTask;

public class ActionData extends Activity {

    private Button browse,edit,dial;
    Intent intent;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_data);
        browse = (Button) findViewById(R.id.btnBrowse);
        edit = (Button) findViewById(R.id.btnEditPhone);
        dial = (Button) findViewById(R.id.btnDialNumber);
        imageView = (ImageView) findViewById(R.id.imageClip);
        final ClipDrawable drawable = (ClipDrawable) imageView.getDrawable();
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 0x123){
                    drawable.setLevel(drawable.getLevel()+200);
                }
            }
        };
        intent = new Intent();

        browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "http://www.baidu.com";
                Uri uri = Uri.parse(data);
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(uri);
                startActivity(intent);
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setAction(Intent.ACTION_EDIT);
                String data = "content://com.android.contacts/contacts/1";
                intent.setData(Uri.parse(data));
                startActivity(intent);
            }
        });

        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setAction(Intent.ACTION_DIAL);
                String data = "tel:18682003824";
                intent.setData(Uri.parse(data));
                startActivity(intent);
            }
        });

        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = 0x123;
                handler.sendMessage(message);
                if (drawable.getLevel() >= 10000){
                    timer.cancel();
                }
            }
        },0,300);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_action_data, menu);
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
