package com.example.mayank.myactionbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public  void secondshow(View view){
        Intent intent=new Intent(this,MainActivity3.class);
        startActivity(intent);
    }
}
