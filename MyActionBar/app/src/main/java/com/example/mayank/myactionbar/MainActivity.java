package com.example.mayank.myactionbar;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.mipmap.ic_launcher);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);
        actionBar.setBackgroundDrawable(getDrawable(R.drawable.images));
    }


    public  void firstshow(View view){
        Intent intent=new Intent(this,MainActivity2.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.battery:
                Toast.makeText(MainActivity.this, "you clicked on battery", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.search:
                Toast.makeText(this, "You clicked on search button", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

}
