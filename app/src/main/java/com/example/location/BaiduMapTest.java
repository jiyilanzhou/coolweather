package com.example.location;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.map.LocationData;
import com.baidu.mapapi.map.MapController;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationOverlay;
import com.baidu.mapapi.map.PopupClickListener;
import com.baidu.mapapi.map.PopupOverlay;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.example.hoperun.myapplication.R;

import java.util.List;

public class BaiduMapTest extends Activity {

    private BMapManager manager;
    private MapView mapView;
    private LocationManager locationManager;
    private String provider;
    public static final String TAG = "BaiduMapTest";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        manager = new BMapManager(this);
        manager.init("Ka9WG8G92zNdmb7XGTTtGLoi1TA62O3L", null);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_baidu_map_test);
        mapView = (MapView) findViewById(R.id.map_view);
        mapView.setBuiltInZoomControls(true);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        List<String> providerList = locationManager.getProviders(true);
        if (providerList.contains(LocationManager.NETWORK_PROVIDER)){
            provider = LocationManager.NETWORK_PROVIDER;
        }else if (providerList.contains(LocationManager.GPS_PROVIDER)){
            provider = LocationManager.GPS_PROVIDER;
        }else {
            Toast.makeText(this, "no location provider to use", Toast.LENGTH_SHORT).show();
        }
        for (String provider :locationManager.getAllProviders()){
            Log.d(TAG,"provider="+provider);
        }
        Location location = locationManager.getLastKnownLocation(provider);
        Log.d(TAG,"location"+location);
        if (location != null){
            navigateTo(location);
        }
    }

    private void navigateTo(Location location) {
        MapController controller = mapView.getController();
        controller.setZoom(16);
        GeoPoint point = new GeoPoint((int)(location.getLatitude()*1E6),(int)(location.getLongitude()*1E6));
        controller.setCenter(point);
        MyLocationOverlay myLocationOverlay = new MyLocationOverlay(mapView);
        LocationData locationData = new LocationData();
        locationData.latitude = location.getLatitude();
        locationData.longitude = location.getLongitude();
        myLocationOverlay.setData(locationData);
        mapView.getOverlays().add(myLocationOverlay);
        mapView.refresh();

        /*PopupOverlay pop = new PopupOverlay(mapView, new PopupClickListener() {
            @Override
            public void onClickedPopup(int i) {
                Toast.makeText(BaiduMapTest.this,"you clicked button "+i,Toast.LENGTH_SHORT).show();
            }
        });
        Bitmap[] bitmaps = new Bitmap[3];
        bitmaps[0] = BitmapFactory.decodeResource(getResources(), R.mipmap.left);
        bitmaps[1] = BitmapFactory.decodeResource(getResources(),R.mipmap.middle);
        bitmaps[2] = BitmapFactory.decodeResource(getResources(),R.mipmap.right);
        pop.showPopup(bitmaps, point, 18);*/

        PopupOverlay pop = new PopupOverlay(mapView, new PopupClickListener() {
            @Override
            public void onClickedPopup(int index) {
                // 相应图片的点击事件
                Toast.makeText(BaiduMapTest.this,
                        "You clicked button " + index, Toast.LENGTH_SHORT)
                        .show();
            }
        });
        // 创建一个长度为3的Bitmap数组
        Bitmap[] bitmaps = new Bitmap[3];
        try {
            // 将三张图片读取到内存中
            bitmaps[0] = BitmapFactory.decodeResource(getResources(),
                    R.drawable.left);
            bitmaps[1] = BitmapFactory.decodeResource(getResources(),
                    R.drawable.middle);
            bitmaps[2] = BitmapFactory.decodeResource(getResources(),
                    R.drawable.right);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        pop.showPopup(bitmaps, point, 18);
        pop.showPopup(bitmaps[0],point,1);
    }

    @Override
    protected void onResume() {
        mapView.onResume();
        if (manager != null){
            manager.start();
        }
        super.onResume();
    }

    @Override
    protected void onPause() {
        mapView.onPause();
        if (manager != null){
            manager.stop();
        }
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        mapView.destroy();
        if (manager != null){
            manager.destroy();
            manager = null;
        }
        super.onDestroy();
    }
}
