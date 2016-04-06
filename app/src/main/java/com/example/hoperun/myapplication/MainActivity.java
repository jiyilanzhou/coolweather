package com.example.hoperun.myapplication;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ActionBarDemo.ActionBarTest;
import com.example.ActivityAndFragment.PreferenceActivityTest;
import com.example.FragmentTest.FragmentDemo;
import com.example.FragmentTest.FragmentTest;
import com.example.MenuDemo.MenuDemo;
import com.example.MixComponent.CalendarViewDemo;
import com.example.ViewAnimatorDemo.ImageSwitcherDemo;
import com.example.ViewAnimatorDemo.ViewSwitcherDemo;
import com.example.adapterview.AdapterViewDemo;
import com.example.alertdialogdemo.AlertDialogDemo;
import com.example.coolweather.activity.ChooseAreaActivity;
import com.example.database.ContactTest;
import com.example.database.DataBaseActivity;
import com.example.database.NetworkTest;
import com.example.database.SMSTest;
import com.example.intent.DataTypeOverride;
import com.example.location.LocationTest;
import com.example.mediaplayer.SoundPoolTest;
import com.example.progressbardemo.ProgressBarDemo;
import com.example.sensor.SensorTest;

import java.util.Date;


public class MainActivity extends Activity implements View.OnClickListener {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button10;
    private Button button11;
    private Button button12;
    private Button button13;
    private Button button14;
    private Button button15;
    private Button button16;
    private Button button17;
    private Button button18;
    private Button button19;
    private Button button20;
    private Button button21;
    private Button button22;
    private Button button23;
    private Button button24;
    private Button button25;
    private Button button26;
    private Button button27;
    private Button button28;
    private Button button29;
    private Button button30;
    private Button button31;
    private Button button32;
    private Button button33;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.cancel(1);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        button11 = (Button) findViewById(R.id.button11);
        button12 = (Button) findViewById(R.id.button12);
        button13 = (Button) findViewById(R.id.button13);
        button14 = (Button) findViewById(R.id.button14);
        button15 = (Button) findViewById(R.id.button15);
        button16 = (Button) findViewById(R.id.button16);
        button17 = (Button) findViewById(R.id.button17);
        button18 = (Button) findViewById(R.id.button18);
        button19 = (Button) findViewById(R.id.button19);
        button20 = (Button) findViewById(R.id.button20);
        button21 = (Button) findViewById(R.id.button21);
        button22 = (Button) findViewById(R.id.button22);
        button23 = (Button) findViewById(R.id.button23);
        button24 = (Button) findViewById(R.id.button24);
        button25 = (Button) findViewById(R.id.button25);
        button26 = (Button) findViewById(R.id.button26);
        button27 = (Button) findViewById(R.id.button27);
        button28 = (Button) findViewById(R.id.button28);
        button29 = (Button) findViewById(R.id.button29);
        button30 = (Button) findViewById(R.id.button30);
        button31 = (Button) findViewById(R.id.button31);
        button32 = (Button) findViewById(R.id.button32);
        button33 = (Button) findViewById(R.id.button33);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button10.setOnClickListener(this);
        button11.setOnClickListener(this);
        button12.setOnClickListener(this);
        button13.setOnClickListener(this);
        button14.setOnClickListener(this);
        button15.setOnClickListener(this);
        button16.setOnClickListener(this);
        button17.setOnClickListener(this);
        button18.setOnClickListener(this);
        button19.setOnClickListener(this);
        button20.setOnClickListener(this);
        button21.setOnClickListener(this);
        button22.setOnClickListener(this);
        button23.setOnClickListener(this);
        button24.setOnClickListener(this);
        button25.setOnClickListener(this);
        button26.setOnClickListener(this);
        button27.setOnClickListener(this);
        button28.setOnClickListener(this);
        button29.setOnClickListener(this);
        button30.setOnClickListener(this);
        button31.setOnClickListener(this);
        button32.setOnClickListener(this);
        button33.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                startActivity(new Intent(this, CodeViewActivity.class));
                break;
            case R.id.button2:
                startActivity(new Intent(this, MixView.class));
                break;
            case R.id.button3:
                startActivity(new Intent(this, CustomView.class));
                break;
            case R.id.button4:
                startActivity(new Intent(this, FrameLayoutDemo.class));
                break;
            case R.id.button5:
                startActivity(new Intent(this, GridLayoutDemo.class));
                break;
            case R.id.button6:
                startActivity(new Intent(this, TextViewDemo.class));
                break;
            case R.id.button7:
                startActivity(new Intent(this, EditViewDemo.class));
                break;
            case R.id.button8:
                startActivity(new Intent(this, ButtonDemo.class));
                break;
            case R.id.button9:
                startActivity(new Intent(this, CheckBoxDemo.class));
                break;
            case R.id.button10:
                startActivity(new Intent(this, ToggleButtonDemo.class));
                break;
            case R.id.button11:
                startActivity(new Intent(this, ClockDemo.class));
                break;
            case R.id.button12:
                startActivity(new Intent(this, ChronometerDemo.class));
                break;
            case R.id.button13:
                startActivity(new Intent(this, ImageViewDemo.class));
                break;
            case R.id.button14:
                startActivity(new Intent(this, ImageButtonDemo.class));
                break;
            case R.id.button15:
                startActivity(new Intent(this, QuickContactBadgeDemo.class));
                break;
            case R.id.button16:
                startActivity(new Intent(this, AdapterViewDemo.class));
                break;
            case R.id.button17:
                startActivity(new Intent(this, ProgressBarDemo.class));
                break;
            case R.id.button18:
                startActivity(new Intent(this, ImageSwitcherDemo.class));
                break;
            case R.id.button19:
                startActivity(new Intent(this, CalendarViewDemo.class));
                break;
            case R.id.button20:
                startActivity(new Intent(this, AlertDialogDemo.class));
                break;
            case R.id.button21:
                startActivity(new Intent(this, MenuDemo.class));
                break;
            case R.id.button22:
                startActivity(new Intent(this, ActionBarTest.class));
                break;
            case R.id.button23:
                startActivity(new Intent(this, FragmentDemo.class));
                break;
            case R.id.button24:
                startActivity(new Intent(this, DataTypeOverride.class));
                break;
            case R.id.button25:
                startActivity(new Intent(this, SoundPoolTest.class));
                break;
            case R.id.button26:
                startActivity(new Intent(this, DataBaseActivity.class));
                break;
            case R.id.button27:
                startActivity(new Intent(this, ContactTest.class));
                break;
            case R.id.button28:
                startActivity(new Intent(this, SMSTest.class));
                break;
            case R.id.button29:
                startActivity(new Intent(this, NetworkTest.class));
                break;
            case R.id.button30:
                startActivity(new Intent(this, LocationTest.class));
                break;
            case R.id.button31:
                startActivity(new Intent(this, SensorTest.class));
                break;
            case R.id.button32:
                startActivity(new Intent(this, ChooseAreaActivity.class));
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
