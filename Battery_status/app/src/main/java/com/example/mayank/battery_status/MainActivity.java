package com.example.mayank.battery_status;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText batterystatus;
    EditText chargingsource,temprature,voltage,chargingstatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BroadcastReceiver battery=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int chargePlug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED,-1);
                int charge=intent.getIntExtra(BatteryManager.EXTRA_STATUS,-1);
                boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
                boolean acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;
                int level=intent.getIntExtra(BatteryManager.EXTRA_LEVEL,-1);
                int temp=intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE,-1);
                int volt=intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE,-1);
                boolean charging=charge==BatteryManager.BATTERY_STATUS_CHARGING;
                String text=String.valueOf(level);
                String tempr=String.valueOf(temp);
                String volta=String.valueOf(volt);
                batterystatus=(EditText)findViewById(R.id.editText);
                chargingsource=(EditText)findViewById(R.id.source);
                temprature=(EditText)findViewById(R.id.temprature);
                voltage=(EditText)findViewById(R.id.voltage);
                chargingstatus=(EditText)findViewById(R.id.status);

                temprature.setText(tempr);
                batterystatus.setText(text);
                voltage.setText(volta);


                if(usbCharge)
                    chargingsource.setText("USB");

                else if(acCharge)
                    chargingsource.setText("AC");
                else
                    chargingsource.setText("Not Available");


                if (charging){
                    chargingstatus.setText("Charging");}
                else
                    chargingstatus.setText("Not charging");

            }
        };
        IntentFilter intentFilter=new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(battery,intentFilter);

    }


}
