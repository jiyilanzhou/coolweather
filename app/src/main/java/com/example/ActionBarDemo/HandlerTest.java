package com.example.ActionBarDemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hoperun.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class HandlerTest extends Activity {

    static final String UPPER_NUMBER = "upper";
    EditText etNUm;
    CalThread calThread;
    Button cal;

    class CalThread extends Thread {

        public Handler handler;

        @Override
        public void run() {
            super.run();
            Looper.prepare();
            handler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    if (msg.what == 0x123) {
                        int upper = msg.getData().getInt(UPPER_NUMBER);
                        List<Integer> nums = new ArrayList<Integer>();
                        outer:
                        for (int i = 2; i <= upper; i++) {
                            for (int j = 2; j <= Math.sqrt(i); j++) {
                                if (i != 2 && i % j == 0)
                                    continue outer;
                            }
                             
                        }
                        Toast.makeText(HandlerTest.this, nums.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            };
            Looper.loop();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_test);
        etNUm = (EditText) findViewById(R.id.inputNumber);
        calThread = new CalThread();
        calThread.start();
        cal = (Button) findViewById(R.id.btnCall);
        cal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Message msg = new Message();
                msg.what = 0x123;
                Bundle bundle = new Bundle();
                bundle.putInt(UPPER_NUMBER, Integer.parseInt(etNUm.getText().toString()));
                msg.setData(bundle);
                calThread.handler.sendMessage(msg);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_handler_test, menu);
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
