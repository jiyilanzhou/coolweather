package com.example.FragmentTest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.hoperun.myapplication.R;

public class FragmentActivity extends Activity {

    Button startActivity, addFragment, backFragment, replaceFragment, finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        startActivity = (Button) findViewById(R.id.startActivity);
        addFragment = (Button) findViewById(R.id.addFragment);
        backFragment = (Button) findViewById(R.id.backFragment);
        replaceFragment = (Button) findViewById(R.id.replaceFragment);
        finish = (Button) findViewById(R.id.finish);

        startActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FragmentActivity.this,SecondActivity.class));
            }
        });
        addFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LifecycleFragment fragment = new LifecycleFragment();
                getFragmentManager().beginTransaction()
                        .replace(R.id.llContainer,fragment).commit();
            }
        });

        backFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondFragment fragment = new SecondFragment();
                getFragmentManager().beginTransaction()
                        .replace(R.id.llContainer, fragment)
                        .addToBackStack("aa").commit();
            }
        });

        replaceFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondFragment fragment = new SecondFragment();
                getFragmentManager().beginTransaction()
                        .replace(R.id.llContainer, fragment)
                        .commit();
            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentActivity.this.finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_, menu);
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
