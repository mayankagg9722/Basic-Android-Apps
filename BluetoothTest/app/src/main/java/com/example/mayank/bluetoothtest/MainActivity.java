package com.example.mayank.bluetoothtest;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    BluetoothAdapter bluetoothAdapter;
    ListView listView;
    ArrayAdapter arrayAdapter;
    ArrayList listarray;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("error","1");
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        bluetoothAdapter.startDiscovery();
        listView = (ListView) findViewById(R.id.listView);
        if (bluetoothAdapter == null) {
            Toast.makeText(this, "Device not support bluetooth", Toast.LENGTH_LONG).show();
        }
    }

    public void on(View view) {
        if (!bluetoothAdapter.isEnabled()) {
            Toast.makeText(this, "Bluetooth Turn On", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(bluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivity(intent);
        } else
            Toast.makeText(this, "Already Turned On", Toast.LENGTH_LONG).show();
    }

    public void off(View view) {
        if (bluetoothAdapter.isEnabled()) {
            bluetoothAdapter.disable();
            Toast.makeText(this, "Bluetooth Turn Off", Toast.LENGTH_LONG).show();
        } else
            Toast.makeText(this, "Already Turned Off", Toast.LENGTH_LONG).show();
    }

    public void onvisible(View view) {
        Intent visibility = new Intent(bluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        visibility.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
        startActivity(visibility);
        Toast.makeText(this, "Bluetooth Visibility Turn On", Toast.LENGTH_LONG).show();
    }

    public void showpaired(View view) {
        //getting paired bluetooth device
        Set<BluetoothDevice> list = bluetoothAdapter.getBondedDevices();
        listarray = new ArrayList();
        if (list.size() > 0) {
            for (BluetoothDevice device : list)
                listarray.add(device.getName().toString() + ": " + device.getAddress().toString());
            arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listarray);
            listView.setAdapter(arrayAdapter);
        } else
            Toast.makeText(getApplicationContext(), "No Paired device", Toast.LENGTH_LONG).show();
    }

 public void shownew(View view) {
        BroadcastReceiver broadReciever = new BroadcastReceiver() {
         @Override
         public void onReceive(Context context, Intent intent) {
             String action = intent.getAction();
             if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                 BluetoothDevice device1 = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                 arrayAdapter.add(device1.getName());
                 listView.setAdapter(arrayAdapter);
                 arrayAdapter.notifyDataSetChanged();
             }
         }
     };
        bluetoothAdapter.startDiscovery();
        IntentFilter intentFilter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(broadReciever, intentFilter);
}


    @Override
    protected void onDestroy() {
        bluetoothAdapter.cancelDiscovery();
        super.onDestroy();
    }
}
