package com.example.ActionBarDemo;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hoperun.myapplication.R;

public class ActionHomeTest extends Activity {

    private TextView txt;
    ActionBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_home_test);
        txt = (TextView) findViewById(R.id.txtBar);
        bar = getActionBar();
        //显示应用程序图标
//        bar.setDisplayShowHomeEnabled(true);
        //将应用程序图标设置为可点击的按钮
//        bar.setHomeButtonEnabled(true);
        //将应用程序图标设置为可点击的按钮，并在图标上添加向左的箭头
        bar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu_res_test, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (item.isCheckable())
            item.setChecked(true);

        //noinspection SimplifiableIfStatement
        switch (id) {
            case android.R.id.home:
                Intent intent = new Intent(this,ActionBarTest.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            break;
            case R.id.font_10:
                txt.setTextSize(20 * 2);
                break;
            case R.id.font_12:
                txt.setTextSize(12 * 2);
                break;
            case R.id.font_14:
                txt.setTextSize(14 * 2);
                break;
            case R.id.font_16:
                txt.setTextSize(16 * 2);
                break;
            case R.id.font_18:
                txt.setTextSize(18 * 2);
                break;
            case R.id.red_font:
                txt.setTextColor(Color.RED);
                break;
            case R.id.green_font:
                txt.setTextColor(Color.GREEN);
                break;
            case R.id.blue_font:
                txt.setTextColor(Color.BLUE);
                break;
            case R.id.plain_item:
                Toast.makeText(this, "您点击了普通菜单", Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }
}
