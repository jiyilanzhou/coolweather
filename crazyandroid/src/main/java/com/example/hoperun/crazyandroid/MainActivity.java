package com.example.hoperun.crazyandroid;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ListView showView;
    String[] statusName;
    ArrayList<String> statusValues = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TelephonyManager manager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        statusName = getResources().getStringArray(R.array.statusNames);
        String[] simState = getResources().getStringArray(R.array.simState);
        String[] phoneType = getResources().getStringArray(R.array.phoneType);

        statusValues.add(null != manager.getDeviceId() ?
                manager.getDeviceId() :"未知");
        /*null != manager.getDeviceId() ?
                manager.getDeviceId() :*/
//        statusValues.add("未知");
        //获取系统平台的版本
        /*manager.getDeviceSoftwareVersion() != null ?
                manager.getDeviceSoftwareVersion() :*/
        statusValues.add(manager.getDeviceSoftwareVersion() != null ?
                manager.getDeviceSoftwareVersion() : "未知版本");
        //获取网络运营商代号manager.getNetworkOperator()
        statusValues.add(manager.getNetworkOperator());
        //获取运营商代号
        statusValues.add(manager.getNetworkOperatorName());
        //获取手机网络类型
        statusValues.add(phoneType[manager.getPhoneType()]);
        //获取设备所在位置
        /*manager.getCellLocation() != null ?
                manager.getCellLocation().toString() : "未知"*/
        statusValues.add(manager.getCellLocation() != null ?
                manager.getCellLocation().toString() : "未知");
        //获取SIM卡国别manager.getSimCountryIso()   manager.getSimSerialNumber()
        statusValues.add(manager.getSimCountryIso());
        statusValues.add(manager.getSimSerialNumber());
//        simState[manager.getSimState()]
        statusValues.add(simState[manager.getSimState()]);
        showView = (ListView) findViewById(R.id.listShow);
        ArrayList<Map<String,String>> status = new ArrayList<Map<String,String>>();
        for (int i = 0; i < statusValues.size(); i++){
            HashMap<String,String> item = new HashMap<String,String>();
            item.put("name",statusName[i]);
            item.put("value",statusValues.get(i));
            status.add(item);
        }

        SimpleAdapter adapter = new SimpleAdapter(this,status,R.layout.telephonyline,
                new String[]{"name","value"},new int[]{R.id.txtTelephonyName,
            R.id.txtTelephonyValue});
        showView.setAdapter(adapter);
        Button button = (Button) findViewById(R.id.btnTelephonyMonitor);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MonitorPhone.class));
            }
        });
    }

}
