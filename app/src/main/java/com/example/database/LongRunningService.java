package com.example.database;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class LongRunningService extends Service {

    private DownloadBinder mBinder = new DownloadBinder();
    public static final String TAG = "LongRunningService";
    class DownloadBinder extends Binder{
        public void startDownload(){
            Log.d(TAG,"startDownload");
        }
        public int getProgress(){
            Log.d(TAG,"getProgress");
            return 0;
        }
    }
    public LongRunningService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mBinder;
    }
}
