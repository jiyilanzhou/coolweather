package com.example.adapterview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import com.example.hoperun.myapplication.R;

public class AutoCompleteTextDemo extends Activity {

    AutoCompleteTextView actv;
    MultiAutoCompleteTextView mauto;
    String[] books = new String[]{
            "疯狂Java讲义", "疯狂Ajax",
            "疯狂XML讲义", "疯狂WorkFlow讲义"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text_demo);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, books);
        actv = (AutoCompleteTextView) findViewById(R.id.auto);
        actv.setAdapter(adapter);
        mauto = (MultiAutoCompleteTextView) findViewById(R.id.mauto);
        mauto.setAdapter(adapter);
        mauto.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_auto_complete_text_demo, menu);
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
