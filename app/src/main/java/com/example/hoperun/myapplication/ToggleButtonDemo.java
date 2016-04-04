package com.example.hoperun.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.ToggleButton;


public class ToggleButtonDemo extends Activity {

    ToggleButton toggle;
    Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button_demo);

        toggle = (ToggleButton) findViewById(R.id.toggle);
        aSwitch = (Switch) findViewById(R.id.switcher);

        final LinearLayout test = (LinearLayout) findViewById(R.id.test);
        CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    test.setOrientation(LinearLayout.VERTICAL);
                    toggle.setChecked(true);
                    aSwitch.setChecked(true);
                }
                else {
                    test.setOrientation(LinearLayout.HORIZONTAL);
                    toggle.setChecked(false);
                    aSwitch.setChecked(false);
                }
            }
        };

        toggle.setOnCheckedChangeListener(listener);
        aSwitch.setOnCheckedChangeListener(listener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_toggle_button_demo, menu);
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
