package com.example.database;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hoperun.myapplication.R;

public class SMSTest extends Activity {

    private TextView sender;
    private TextView content;
    private IntentFilter intentFilter;
    private MessageReceiver messageReceiver;
    private EditText to;
    private EditText msgInput;
    private Button send;
    private  SendStatusReceiver sendStatusReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smstest);
        sender = (TextView) findViewById(R.id.send);
        content = (TextView) findViewById(R.id.content);
        to = (EditText) findViewById(R.id.to);
        msgInput = (EditText) findViewById(R.id.msg_input);
        send = (Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager smsManager = SmsManager.getDefault();
                Intent sendIntent = new Intent("SENT_SMS_ACTION");
                PendingIntent pi = PendingIntent.getBroadcast(SMSTest.this,0,sendIntent,0);
                smsManager.sendTextMessage(to.getText().toString(),null,
                        msgInput.getText().toString(),pi,null);
            }
        });
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
        intentFilter.addAction("SENT_SMS_ACTION");
//        intentFilter.setPriority(100);
        messageReceiver = new MessageReceiver();
        sendStatusReceiver = new SendStatusReceiver();
//        registerReceiver(messageReceiver, intentFilter);
        registerReceiver(sendStatusReceiver,intentFilter);
    }

    class MessageReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getExtras();
            Object[] pdus = (Object[]) bundle.get("pdus");
            SmsMessage[] messages = new SmsMessage[pdus.length];
            for (int i = 0; i < messages.length; i++) {
                messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
            }
            String address = messages[0].getOriginatingAddress();
            String fullMessage = "";
            for (SmsMessage message : messages) {
                fullMessage += message.getMessageBody();
            }
            if (null != address)
//                sender.setText(address);
            content.setText(fullMessage);
            abortBroadcast();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        unregisterReceiver(messageReceiver);
        unregisterReceiver(sendStatusReceiver);
    }

    class SendStatusReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            if (getResultCode() == RESULT_OK){
                Toast.makeText(context,"send Succeeded",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context,"send Failed",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
