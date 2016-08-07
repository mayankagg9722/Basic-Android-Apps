package com.example.mayank.softwares;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    String[] sno={"1.","2.","3.","4.","5.","6.","7.","8."};

    String[] name={"Firefox", "Thunderbird", "OpenOffice", "Gaim", "Juice", "RSSOwl", "KeePass", "Bit torrent"};

    int[]images={R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_4,
            R.drawable.img_5,R.drawable.img_6,R.drawable.img_7,R.drawable.img_8};

    SoftwareDataHandler softwareDataHandler;
    SoftwareAdapter softwareAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listview);
        softwareAdapter=new SoftwareAdapter(getApplicationContext(),R.layout.rowlayout);
        int i=0;
        for(String s:sno)
        {
            softwareDataHandler=new SoftwareDataHandler(s,name[i],images[i]);
            softwareAdapter.add(softwareDataHandler);
            i++;
        }
        listView.setAdapter(softwareAdapter);
    }
}
