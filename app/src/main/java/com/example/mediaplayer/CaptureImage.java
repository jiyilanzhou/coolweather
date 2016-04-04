package com.example.mediaplayer;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Environment;
import android.view.Display;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.hoperun.myapplication.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CaptureImage extends Activity {

    SurfaceView view;
    SurfaceHolder holder;
    int screenWidth, screenHeight;

    //定义系统所用的照相机
    Camera camera;
    boolean isPreview = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_capture_image);
        WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        //获取屏幕的宽和高
        screenWidth = display.getWidth();
        screenHeight = display.getHeight();
        view = (SurfaceView) findViewById(R.id.surfaceCamera);
        holder = view.getHolder();
        //为surfaceHolder添加一个回调监听器
        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                initCamera();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                if (camera != null) {
                    if (isPreview)
                        camera.stopPreview();
                    camera.release();
                    camera = null;
                }
            }
        });
        //设置该surfaceView自己不维护缓冲
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_CENTER:
            case KeyEvent.KEYCODE_CAMERA:
                if (camera != null && event.getRepeatCount() == 0) {
                    camera.takePicture(null, null, myjpegCallback);
                    return true;
                }
                break;
        }
        return super.onKeyDown(keyCode, event);
    }

    Camera.PictureCallback myjpegCallback = new Camera.PictureCallback() {
        @Override
        public void onPictureTaken(byte[] data, Camera camera) {
            //根据拍照所得的数据创建位图
            final Bitmap bm = BitmapFactory.decodeByteArray(data, 0, data.length);
            //加载 文件对应的布局文件
            View saveDialog = getLayoutInflater().inflate(R.layout.capture_image_save, null);
            ImageView show = (ImageView) saveDialog.findViewById(R.id.cameraShow);
            final EditText editText = (EditText) saveDialog.findViewById(R.id.phone_name);
            show.setImageBitmap(bm);
            new AlertDialog.Builder(CaptureImage.this).setView(saveDialog)
                    .setPositiveButton("保存", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //创建一个位于SD卡上的文件
                            File file = new File(Environment.getExternalStorageDirectory(),editText
                                    .getText().toString()+".jpg");
                            FileOutputStream fos = null;
                            try {
                                fos = new FileOutputStream(file);
                                //把位图输出到指定文件中
                                bm.compress(Bitmap.CompressFormat.JPEG,100,fos);
                                fos.close();
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }).setNegativeButton("取消",null).show();
            //重新浏览
            camera.stopPreview();
            camera.startPreview();
            isPreview = true;
        }
    };

    private void initCamera() {
        if (!isPreview)
            camera = Camera.open();
        if (camera != null && !isPreview) {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setPreviewSize(screenWidth, screenHeight);
            parameters.setPreviewFrameRate(4);
            parameters.setPictureFormat(PixelFormat.JPEG);
            parameters.set("jpeg-quality", 85);
            parameters.setPictureSize(screenWidth, screenHeight);
            camera.setParameters(parameters);
            try {
                camera.setPreviewDisplay(holder);
                camera.startPreview();
                camera.autoFocus(null);
            } catch (IOException e) {
                e.printStackTrace();
            }
            isPreview = true;
        }
    }
}
