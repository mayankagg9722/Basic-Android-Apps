package com.example.mayank.withthread;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            TextView textView=(TextView)findViewById(R.id.Mytext);
            textView.setText("Mission Completed");
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click(View view) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                long ftime=System.currentTimeMillis()+10000;
                synchronized (this){
                    while(System.currentTimeMillis()<ftime){
                        try {
                            wait(ftime-System.currentTimeMillis());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    handler.sendEmptyMessage(0);
                }
            }
        };
       Thread thread=new Thread(runnable);
        thread.start();

    }
}
