package com.example.mediaplayer;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageButton;

import com.example.hoperun.myapplication.R;

import java.io.IOException;

public class SurfaceViewPlayVideo extends Activity implements View.OnClickListener {

    SurfaceView surfaceView;
    ImageButton play, pause, stop;
    MediaPlayer player;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface_view_play_video);
        play = (ImageButton) findViewById(R.id.mediaPlay);
        pause = (ImageButton) findViewById(R.id.mediaPause);
        stop = (ImageButton) findViewById(R.id.mediaStop);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);

        //创建MediaPlayer
        player = new MediaPlayer();
        surfaceView = (SurfaceView) findViewById(R.id.mediaSurfaceView);
        surfaceView.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        //设置播放时打开屏幕
        surfaceView.getHolder().setKeepScreenOn(true);
        surfaceView.getHolder().addCallback(new SurfaceListener());


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mediaPlay:
                play();
                break;
            case R.id.mediaPause:
                if (player.isPlaying())
                    player.pause();
                else
                    player.start();
                break;
            case R.id.mediaStop:
                if (player.isPlaying())
                    player.stop();
                break;
        }
    }

    private void play() {
        player.reset();
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            player.setDataSource("/mnt/sdcard/qilixiang.mp4");
            player.setDisplay(surfaceView.getHolder());
            player.prepare();
            player.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class SurfaceListener implements SurfaceHolder.Callback {
        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            //position 指定位置播放
            if (position > 0) {
                play();
                player.seekTo(position);
                position = 0;
            }
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (player.isPlaying()){
            position = player.getCurrentPosition();
            player.stop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (player.isPlaying())
            player.stop();
        player.release();
    }
}
