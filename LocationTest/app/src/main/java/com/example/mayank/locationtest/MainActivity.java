package com.example.mayank.locationtest;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static final int LOCATION_REQ_CODE = 100;
    TextView textView,textaddress;
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textview);
        textaddress=(TextView)findViewById(R.id.textaddress);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED ) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},LOCATION_REQ_CODE);
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0,0,locationListener);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0, locationListener);
    }

    LocationListener locationListener=new LocationListener() {

        @Override
        public void onLocationChanged(Location location) {

            Geocoder geocoder=new Geocoder(getApplicationContext(), Locale.getDefault());
            String result =
                    "\naltitude = " + location.getAltitude() +
                    "\nlatitude = " + location.getLatitude() +
                    "\nlongitude = " + location.getLongitude();
            textView.setText(result);

            try {
                List<Address> addresses=geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                Address address=addresses.get(0);
                //List<String> addresslist=new ArrayList<String>();
                //for(int i=0;i<address.getMaxAddressLineIndex();i++)
                  //  addresslist.add(address.getAddressLine(0));
              //  String useradd=address.getAdminArea()+"\n"+address.getLocality()+"\n"+address.getPostalCode()+"\n"+
                //        address.getCountryName()+"\n"+"\n"+address.getSubAdminArea()+"\n"+address.getSubLocality()+"\n";
                String useradd="";
                for(int i=0;i<address.getMaxAddressLineIndex();i++)
                    useradd=useradd+address.getAddressLine(i).toString()+"\n";
                useradd=useradd+(address.getCountryName().toString());
                textaddress.setText(useradd.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }

    };

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == LOCATION_REQ_CODE){
            if(permissions[0] == Manifest.permission.ACCESS_FINE_LOCATION)  {
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED)  {
                    //noinspection MissingPermission
                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0,0,locationListener);
                }
            }
        }
    }
}
