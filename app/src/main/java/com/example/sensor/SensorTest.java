package com.example.sensor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hoperun.myapplication.R;

public class SensorTest extends Activity {

    private SensorManager sensorManager;
    private TextView lightLevel;
    private Button accelerometer;
    private boolean isAccelerometer = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_test);
        lightLevel = (TextView) findViewById(R.id.light_level);
        sensorManager = getSensorManager();
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensorManager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        accelerometer = (Button) findViewById(R.id.btn_accelerometer);
        accelerometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isAccelerometer = true;
                Sensor sensor1 = getSensorManager().getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
                Toast.makeText(SensorTest.this, "注册加速度传感器", Toast.LENGTH_SHORT).show();
                getSensorManager().registerListener(listener1, sensor1,
                        SensorManager.SENSOR_DELAY_NORMAL);
            }
        });
        findViewById(R.id.btn_compass).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SensorTest.this,CompassTest.class));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (sensorManager != null) {
            sensorManager.unregisterListener(listener);
            if (isAccelerometer) {
                sensorManager.unregisterListener(listener1);
            }
        }
    }

    private SensorEventListener listener1 = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float xValue = Math.abs(event.values[0]);
            float yValue = Math.abs(event.values[1]);
            float zValue = Math.abs(event.values[2]);
            if (Math.sqrt(xValue * xValue + yValue * yValue + zValue * zValue) > 15) {
                Toast.makeText(SensorTest.this, "摇一摇", Toast.LENGTH_SHORT).show();
            }

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    private SensorEventListener listener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float value = event.values[0];
            lightLevel.setText("Current light level is " + value + " lx");
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    private SensorManager getSensorManager() {
        if (sensorManager == null) {
            sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
            return sensorManager;
        } else {
            return sensorManager;
        }
    }
}
