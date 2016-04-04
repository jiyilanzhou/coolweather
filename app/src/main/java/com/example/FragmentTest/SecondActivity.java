package com.example.FragmentTest;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/8/12.
 */
public class SecondActivity extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        TextView tv = new TextView(this);
        tv.setText("对话框风格的Activity");
        setContentView(tv);
    }
}
