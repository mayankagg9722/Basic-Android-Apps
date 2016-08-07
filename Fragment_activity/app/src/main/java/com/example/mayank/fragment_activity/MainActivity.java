package com.example.mayank.fragment_activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements Radiogroupfragment.OnColorChangelistener{
    RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout=(RelativeLayout)findViewById(R.id.mainlayout);
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        Radiogroupfragment radiogroupfragment=new Radiogroupfragment();
        fragmentTransaction.add(R.id.Container,radiogroupfragment);
        fragmentTransaction.commit();
    }

    @Override
    public void colorchanged(String name) {
        if(name.equals("Red"))
            relativeLayout.setBackgroundColor(Color.RED);
        else if(name.equals("Blue"))
            relativeLayout.setBackgroundColor(Color.BLUE);
        else if (name.equals("Green"))
            relativeLayout.setBackgroundColor(Color.GREEN);
    }
}
