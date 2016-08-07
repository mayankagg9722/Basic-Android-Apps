package com.example.mayank.checkbox;

import android.preference.CheckBoxPreference;
import android.support.annotation.CheckResult;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ArrayList<String> list=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)(findViewById(R.id.textView3));
        textView.setEnabled(false);
    }
    public void checkclick(View view) {
        boolean ch=((CheckBox)view).isChecked();
        switch (view.getId())
        {
            case R.id.checkBox:
                if(ch){
                    list.add("Apple");
                }
                else{
                    list.remove("Apple");
                }
                break;
            case R.id.checkBox2:
                if(ch){
                    list.add("Orange");
                }
                else{
                    list.remove("Orange");
                }
                break;
            case R.id.checkBox3:
                if(ch){
                    list.add("Mango");
                }
                else{
                    list.remove("Mango");
                }
                break;
            case R.id.checkBox4:
                if(ch){
                    list.add("Banana");
                }
                else{
                    list.remove("Banana");
                }
                break;

        }
    }
    public void buttonclick(View view){
        String finallist="";
        for(String i:list)
        {
            finallist=finallist+i+"\n";
        }
        textView.setText(finallist);
        textView.setEnabled(true);

    }
}
