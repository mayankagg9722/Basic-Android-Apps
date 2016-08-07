package com.example.mayank.two_fragments_welcome;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragment_one.Onclick {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public void clicked(String name) {
        Fragment_two fragment_two = (Fragment_two) getFragmentManager().findFragmentById(R.id.fragment2);
        fragment_two.updateinfo(name);
    }
}