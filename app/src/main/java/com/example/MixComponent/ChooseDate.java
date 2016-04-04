package com.example.MixComponent;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.hoperun.myapplication.R;

import java.util.Calendar;

public class ChooseDate extends Activity {

    private int year;
    private int mouth;
    private int day;
    private int hour;
    private int minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_date);
        DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
        TimePicker picker = (TimePicker) findViewById(R.id.timePicker);
        //获取当前的年 月 日 小时  分钟
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        mouth = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        hour = c.get(Calendar.HOUR);
        minute = c.get(Calendar.MINUTE);
        //初始化DatePicker组件
        datePicker.init(year, mouth, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Log.d("TAG","您的购买日期为datePicker：" + year + "年" + (monthOfYear + 1) +
                        "月" + dayOfMonth + "日" + hour + "时" + minute + "分");
                ChooseDate.this.year = year;
                ChooseDate.this.mouth = monthOfYear;
                ChooseDate.this.day = dayOfMonth;
                showDate(year, monthOfYear, dayOfMonth, hour, minute);
            }
        });

        picker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                ChooseDate.this.hour = hourOfDay;
                ChooseDate.this.minute = minute;
                showDate(year, mouth, day, hourOfDay, minute);
                Log.d("TAG", "您的购买日期为timePicker：" + year + "年" + (mouth + 1) +
                        "月" + day + "日" + hourOfDay + "时" + minute + "分");
            }
        });
    }

    private void showDate(int year, int month, int day,
                          int hour, int minute) {
        EditText editText = (EditText) findViewById(R.id.showTimer);
        editText.setText("您的购买日期为：" + year + "年" + (mouth + 1) +
                "月" + day + "日" + hour + "时" + minute + "分");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_choose_date, menu);
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
