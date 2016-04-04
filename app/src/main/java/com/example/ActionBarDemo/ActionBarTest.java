package com.example.ActionBarDemo;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.MenuDemo.ActionBar_TabNav;
import com.example.hoperun.myapplication.R;

public class ActionBarTest extends Activity {

    ActionBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_test);
        Button show = (Button) findViewById(R.id.showBar);
        Button hide = (Button) findViewById(R.id.hideBar);
        bar = getActionBar();
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bar.show();
            }
        });
        hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bar.hide();
            }
        });
        Button button = (Button) findViewById(R.id.btnBar1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActionBarTest.this, ActionHomeTest.class));
            }
        });
        Button button1 = (Button) findViewById(R.id.btnBar2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActionBarTest.this, ActionBar_swipeNav.class));
            }
        });
        Button button2 = (Button) findViewById(R.id.btnBar3);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActionBarTest.this, ActionBar_DropDown.class));
            }
        });
        Button button3 = (Button) findViewById(R.id.btnBar4);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActionBarTest.this, HandlerTest.class));
            }
        });
        Button button4 = (Button) findViewById(R.id.btnBar5);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActionBarTest.this, AsyncTaskTest.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_action_bar_test, menu);
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
