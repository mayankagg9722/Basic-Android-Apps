package com.example.mayank.threadnot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void click(View view) throws InterruptedException {
        long ftime=System.currentTimeMillis()+10000;
        synchronized (this){
            while(System.currentTimeMillis()<ftime){
                wait(ftime-System.currentTimeMillis());
            }
        }
        TextView textView=(TextView)findViewById(R.id.Mytext);
        textView.setText("Mission Completed");
    }
}
