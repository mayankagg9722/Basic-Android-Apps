package com.example.mayank.myservice;

import android.app.Service;
import android.bluetooth.BluetoothClass;
import android.content.Intent;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;

public class MyService extends Service {


    public class Mythread implements Runnable {
        int serviceid;
        public Mythread(int service_id) {
            this.serviceid=service_id;
        }
        @Override
        public void run() {
            long i = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < i) {
                synchronized (this) {
                    try {
                        wait(i - System.currentTimeMillis());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            stopSelf(serviceid);
        }
    }
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show();
        Mythread mythread=new Mythread(startId);
        Thread thread=new Thread(mythread);
        thread.start();
        return START_STICKY;
    }


    @Override
    public void onDestroy() {
        Toast.makeText(this,"Service Stopped",Toast.LENGTH_SHORT).show();
    }
}