package com.example.intent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.hoperun.myapplication.R;

public class DataTypeOverride extends Activity {

    Button overrideType, overrideData, and;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_type_override);
        overrideType = (Button) findViewById(R.id.btnIntentData);
        overrideData = (Button) findViewById(R.id.btnIntentType);
        and = (Button) findViewById(R.id.btnIntentAnd);
        Button button = (Button) findViewById(R.id.btnIntent1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DataTypeOverride.this, SchemeActivity.class));
            }
        });
        Button button1 = (Button) findViewById(R.id.btnIntent2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DataTypeOverride.this, SchemeHostPortActivity.class));
            }
        });
        Button button2 = (Button) findViewById(R.id.btnIntent3);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DataTypeOverride.this, SchemeHostPathActivity.class));
            }
        });
        Button button3 = (Button) findViewById(R.id.btnIntent4);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DataTypeOverride.this, SchemeHostPortPathActivity.class));
            }
        });
        Button button4 = (Button) findViewById(R.id.btnIntent5);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DataTypeOverride.this, SchemeHostPortPathType.class));
            }
        });
        Button button5 = (Button) findViewById(R.id.btnIntent6);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DataTypeOverride.this, ActionData.class));
            }
        });
        Button button6 = (Button) findViewById(R.id.btnIntent7);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DataTypeOverride.this, AnimationDrawable.class));
            }
        });
        overrideData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setData(Uri.parse("lee://www.fkjava.org:8888/mypath"));
                intent.setType("abc/xyz");
                Toast.makeText(DataTypeOverride.this, intent.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        overrideType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("abc/xyz");
                intent.setData(Uri.parse("lee://www.fkjava.org:8888/test"));
                Toast.makeText(DataTypeOverride.this, intent.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        and.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setDataAndType(Uri.parse("lee://www.fkjava.org:8888/test"), "abc/xyz");
                Toast.makeText(DataTypeOverride.this, intent.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_data_type_override, menu);
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
