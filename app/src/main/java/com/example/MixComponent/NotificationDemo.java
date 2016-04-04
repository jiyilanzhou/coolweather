package com.example.MixComponent;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.hoperun.myapplication.R;

public class NotificationDemo extends Activity {

    static final int NOTIFICATION_ID = 0x123;
    NotificationManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_demo);
        Button send = (Button) findViewById(R.id.send);
        Button cancel = (Button) findViewById(R.id.cancel);

        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotificationDemo.this, CalendarViewDemo.class);
                PendingIntent pi = PendingIntent.getActivity(NotificationDemo.this, 0, intent, 0);
                Notification notification = new Notification.Builder(NotificationDemo.this)
                        .setAutoCancel(true).setTicker("在状态栏里面显示")
                        .setSmallIcon(R.drawable.nongyu).setContentTitle("一条新通知")
                        .setContentText("恭喜您，您加薪了，工资增加20%")
                        .setDefaults(Notification.DEFAULT_SOUND)
                        .setSound(Uri.parse("android.resource://com.example.MixComponent/" + R.raw.msg))
                        .setWhen(System.currentTimeMillis()).setContentIntent(pi).build();
                manager.notify(NOTIFICATION_ID, notification);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.cancel(NOTIFICATION_ID);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_notification_demo, menu);
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
