package com.example.alertdialogdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

import com.example.hoperun.myapplication.R;

public class PopupWindowDemo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window_demo);
        View root = getLayoutInflater().inflate(R.layout.popupwindow,null);
        //创建popupWindow对象
        final PopupWindow window = new PopupWindow(root,560,560);
        Button button = (Button) findViewById(R.id.btnPopup);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                window.showAsDropDown(v);
                window.showAtLocation(v, Gravity.CENTER,0,0);
            }
        });
        root.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                window.dismiss();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_popup_window_demo, menu);
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
