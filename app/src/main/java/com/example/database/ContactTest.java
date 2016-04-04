package com.example.database;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.hoperun.myapplication.MainActivity;
import com.example.hoperun.myapplication.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ContactTest extends Activity {

    private ListView contactView;
    ArrayAdapter<String> adapter;
    List<String> contactsList = new ArrayList<>();
    private Button sendNotice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_test);
        contactView = (ListView) findViewById(R.id.contact_view);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contactsList);
        contactView.setAdapter(adapter);
        sendNotice = (Button) findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.send_notice:
                        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                        Notification notification = new Notification(R.drawable.ok,"This is a flash ", System.currentTimeMillis());
                        Intent intent = new Intent(ContactTest.this, MainActivity.class);
//                        notification.icon = R.drawable.nongyu;
                        Uri soundUri = Uri.fromFile(new File("/storage/sdcard0/Ringtones/hangouts_message.ogg"));
                        notification.sound = soundUri;

                        notification.ledARGB = Color.RED;
                        notification.ledOnMS = 1000;
                        notification.ledOffMS = 1000;
                        notification.flags = Notification.FLAG_SHOW_LIGHTS;
                        notification.defaults = Notification.DEFAULT_ALL;
                        PendingIntent pi = PendingIntent.getActivity(ContactTest.this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
                        notification.setLatestEventInfo(ContactTest.this,"This is a title","this is a content text",pi);
                        manager.notify(1,notification);
                }
            }
        });
        readContacts();
    }

    private void readContacts() {
        Cursor cursor = null;

        cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null,null,null,null);
        if (cursor.moveToFirst()){
            while (cursor.moveToNext()){
                String displayName = cursor.getString(cursor
                        .getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String number = cursor.getString(cursor.getColumnIndex(ContactsContract
                        .CommonDataKinds.Phone.NUMBER));
                contactsList.add(displayName+"/"+number);
            }
        }
        if (cursor != null)
            cursor.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contact_test, menu);
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
