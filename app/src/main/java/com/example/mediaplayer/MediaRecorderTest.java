package com.example.mediaplayer;

import android.app.Activity;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.hoperun.myapplication.R;

import java.io.File;
import java.io.IOException;

public class MediaRecorderTest extends Activity implements View.OnClickListener {

    Button record, stop;
    //系统的音频文件
    File soundFile;
    MediaRecorder recorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_recorder_test);

        record = (Button) findViewById(R.id.recorderStart);
        stop = (Button) findViewById(R.id.recorderStop);

        record.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.recorderStart:
                Log.d("getExternalStorageState", Environment.getExternalStorageState());
                if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
                    Toast.makeText(MediaRecorderTest.this, "SD卡不存在，请插入SD卡", Toast.LENGTH_SHORT).show();
                try {
                    soundFile = new File(Environment.getExternalStorageDirectory()
                            .getCanonicalFile() + "/sound.amr");
                    Log.d("getCanonicalFile()", String.valueOf(Environment.getExternalStorageDirectory()
                            .getCanonicalFile()));
                    Log.d("getAbsolutePath()", Environment.getExternalStorageDirectory().getAbsolutePath());
                    recorder = new MediaRecorder();
                    recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                    //设置录制的声音的输出格式
                    recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                    //设置声音的编码格式
                    recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                    recorder.setOutputFile(soundFile.getAbsolutePath());
                    recorder.prepare();
                    recorder.start();
                    Toast.makeText(MediaRecorderTest.this,"保存成功",Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.recorderStop:
                if (soundFile != null && soundFile.exists()) {
                    recorder.stop();
                    recorder.release();
                    recorder = null;
                    Toast.makeText(MediaRecorderTest.this,"保存成功",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (soundFile != null && soundFile.exists()) {
            recorder.stop();
            recorder.release();
            recorder = null;
        }
    }
}
