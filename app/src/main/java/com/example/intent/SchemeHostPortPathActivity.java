package com.example.intent;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hoperun.myapplication.R;

import java.io.IOException;

public class SchemeHostPortPathActivity extends Activity {

    MediaPlayer mediaPlayer1 = null;
    MediaPlayer mediaPlayer2 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheme_host_port_path_acitivity);
        Button button = (Button) findViewById(R.id.btnSchemeHostPortPath);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String uri = "lee://www.fkjava.org:8888/mypath";
                intent.setData(Uri.parse(uri));
                TextView view = (TextView) findViewById(R.id.txtSchemeHostPortPath);
                view.setText(uri+getIntent().getData());
                Log.d(this.toString(), uri);
                startActivity(intent);
            }
        });

        mediaPlayer1 = MediaPlayer.create(this,R.raw.bomb);
        //获取该应用的AssetManager
        AssetManager manager = getAssets();

        try {
            AssetFileDescriptor adf = manager.openFd("shot.mp3");
            mediaPlayer2 = new MediaPlayer();
            mediaPlayer2.setDataSource(adf.getFileDescriptor());
            mediaPlayer2.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Button playRaw = (Button) findViewById(R.id.btnPlayRaw);
        Button playAsset = (Button) findViewById(R.id.btnPlayAssets);


        playRaw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer1.start();
            }
        });

        playAsset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer2.start();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scheme_host_port_path_acitivity, menu);
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
