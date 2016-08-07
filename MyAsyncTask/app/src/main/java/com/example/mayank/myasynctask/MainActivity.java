package com.example.mayank.myasynctask;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.textView);
        button=(Button)findViewById(R.id.button);
    }
    public void download(View view){
        Mytask mytask=new Mytask(MainActivity.this,textView,button);
        mytask.execute();
    }
    public void reset(View view){
        button.setEnabled(true);
        textView.setText("Click the button to Download...");
    }
}
