package com.example.intent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hoperun.myapplication.R;

public class SchemeHostPortActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sheme_host_port);
        Button button = (Button) findViewById(R.id.btnSchemeHostPort);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String uri = "lee://www.fkjava.org:8888/test";
                intent.setData(Uri.parse(uri));
                TextView view = (TextView) findViewById(R.id.txtSchemeHostPort);
                view.setText(uri+getIntent().getData());
                Log.d(this.toString(), uri);
                startActivity(intent);
            }
        });
    }

}
