package com.example.mediaplayer;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.hoperun.myapplication.R;

import java.util.HashMap;

public class SoundPoolTest extends Activity implements View.OnClickListener {

    Button bomb, shot, arrow;
    //定义一个SoundPool
    SoundPool soundPool;
    HashMap<Integer, Integer> soundMap = new HashMap<Integer, Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_pool_test);
        bomb = (Button) findViewById(R.id.btnPoolBomb);
        shot = (Button) findViewById(R.id.btnPoolShot);
        arrow = (Button) findViewById(R.id.btnPoolArrow);
        //设置最多可容纳10个音频流，音频的品质为5
        soundPool = new SoundPool(10, AudioManager.STREAM_SYSTEM, 5);
        //load方法加载指定音频文件并返回所加载的音频ID
        soundMap.put(1, soundPool.load(this, R.raw.bomb, 1));
        soundMap.put(2, soundPool.load(this, R.raw.shot, 1));
        soundMap.put(3, soundPool.load(this, R.raw.arrow, 1));
        bomb.setOnClickListener(this);
        shot.setOnClickListener(this);
        arrow.setOnClickListener(this);
        Log.d("音乐池ID", soundMap.toString());
        Button button = (Button) findViewById(R.id.btnMedia1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SoundPoolTest.this, VideoViewTest.class));
            }
        });
        Button button1 = (Button) findViewById(R.id.btnMedia2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SoundPoolTest.this, SurfaceViewPlayVideo.class));
            }
        });
        Button button2 = (Button) findViewById(R.id.btnMedia3);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SoundPoolTest.this, MediaRecorderTest.class));
            }
        });
        Button button3 = (Button) findViewById(R.id.btnMedia4);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SoundPoolTest.this, CaptureImage.class));
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPoolBomb:
                soundPool.play(soundMap.get(1), 1, 1, 0, 0, 1);
                break;
            case R.id.btnPoolShot:
                soundPool.play(soundMap.get(2), 1, 1, 0, 0, 1);
                break;
            case R.id.btnPoolArrow:
                soundPool.play(soundMap.get(3), 1, 1, 0, 0, 1);
                break;
        }
    }
}
