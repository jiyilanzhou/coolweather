package com.example.location;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hoperun.myapplication.R;

import java.util.List;

public class LocationTest extends Activity {

    private TextView positionText;
    private LocationManager locationManager;
    private String provider;
    public static final String TAG = "LocationTest";
    private Button btn_map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_test);
        positionText = (TextView) findViewById(R.id.position_text);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        List<String> providerList = locationManager.getProviders(true);
        for (String provider : providerList){
            Log.d(TAG,"provider = "+provider);
        }
        if (providerList.contains(LocationManager.GPS_PROVIDER)){
            provider = LocationManager.GPS_PROVIDER;
        }else if (providerList.contains(LocationManager.NETWORK_PROVIDER)){
            provider = LocationManager.NETWORK_PROVIDER;
        }else {
            Toast.makeText(this,"no location provider to use",Toast.LENGTH_SHORT).show();
        }
        Log.d(TAG," provider="+provider);
        Location location = locationManager.getLastKnownLocation(provider);
        if (location != null){
            showLocation(location);
        }
        locationManager.requestLocationUpdates(provider,5000,1,locationListener);
        findViewById(R.id.btn_map).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LocationTest.this,BaiduMapTest.class));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (locationManager != null){
                locationManager.removeUpdates(locationListener);
        }
    }

    private void showLocation(Location location) {
        String currentPosition = "latitude is "+location.getLatitude()+"\n"+
                "longitude is "+location.getLongitude() +"\n"+
                "altitude is "+location.getAltitude();
        positionText.setText(currentPosition);
    }

    LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            Log.d(TAG,"onLocationChanged location "+location);
            showLocation(location);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            Log.d(TAG,"onStatusChanged provider"+provider);
        }

        @Override
        public void onProviderEnabled(String provider) {
            Log.d(TAG,"onProviderEnabled provider"+provider);
        }

        @Override
        public void onProviderDisabled(String provider) {
            Log.d(TAG,"onProviderDisabled provider"+provider);
        }
    };
}
