package com.example.hoperun.crazyandroid;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MonitorPhone extends AppCompatActivity {

    TelephonyManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor_phone);
        manager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        PhoneStateListener listener = new PhoneStateListener(){
            @Override
            public void onCallStateChanged(int state, String incomingNumber) {
                super.onCallStateChanged(state, incomingNumber);
                switch (state){
                    case TelephonyManager.CALL_STATE_IDLE:
                        break;
                    case TelephonyManager.CALL_STATE_OFFHOOK:
                        break;
                    case TelephonyManager.CALL_STATE_RINGING:
                        OutputStream os = null;
                        try {
                            os = openFileOutput("phoneList",MODE_APPEND);

                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        PrintStream ps = new PrintStream(os);
                        ps.println(new Date() + "来电：" + incomingNumber);
                        Log.d("onCallStateChanged"
                                ,new SimpleDateFormat("yyyy年MM月dd日 HH小时mm分ss秒")
                                .format(new Date()) + "来电：" + incomingNumber);
                        ps.close();
                        break;
                }
            }
        };
        //监听电话通话状态的改变
        manager.listen(listener,PhoneStateListener.LISTEN_CALL_STATE);
    }

}
