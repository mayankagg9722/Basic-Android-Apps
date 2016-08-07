package com.example.mayank.myexpandablelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ExpandableListView expandableListView;
    String headings[]={"Action Movies","Horror Movies","Romantic Movies"};
    String child1[]={"Dark Knight","Civil War","Iron Man"};
    String child2[]={"Insidious","Grudge","Conjuring"};
    String child3[]={"Love Actually","Silver Linings Playbook","Shades of Grey"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandableListView=(ExpandableListView)findViewById(R.id.exandablelist);
        List<String> headitem=new ArrayList<String>();
        HashMap<String,List<String>> childitems=new HashMap<String, List<String>>();
        List<String> l1=new ArrayList<String>();
        List<String> l2=new ArrayList<String>();
        List<String> l3=new ArrayList<String>();
        for(String i:headings){
                headitem.add(i);
        }
        for(String i:child1){
            l1.add(i);
        }
        for(String i:child2){
            l2.add(i);
        }
        for(String i:child3){
            l3.add(i);
        }
        childitems.put(headitem.get(0),l1);
        childitems.put(headitem.get(1),l1);
        childitems.put(headitem.get(2),l1);
        Mylist adapter=new Mylist(getApplicationContext(),headitem,childitems);
        expandableListView.setAdapter(adapter);
    }


}
