package com.example.mayank.mysharedpref;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    SeekBar seekBar;
    RadioGroup radioGroup;

    String text;
    String color;
    float value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        radioGroup = (RadioGroup) findViewById(R.id.rgroup);

        SharedPreferences sharedPreferences = getSharedPreferences("saveinfo", Context.MODE_PRIVATE);

        text = sharedPreferences.getString("message", "");

        editText.setText(text);

        color = sharedPreferences.getString("color", "");

        value = sharedPreferences.getFloat("size",25);

        if (value==25) {
            seekBar.setProgress(0);
        }
        else {
            seekBar.setProgress((int) value);
        }

        editText.setTextSize(TypedValue.COMPLEX_UNIT_PX, value);


        if (color.equals("RED"))
            editText.setTextColor(Color.parseColor("#ff0000"));
        else if (color.equals("GREEN"))
            editText.setTextColor(Color.parseColor("#33cc33"));
        else if (color.equals("BLUE"))
            editText.setTextColor(Color.parseColor("#0000ff"));
        else
            editText.setTextColor(Color.parseColor("#000000"));

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                editText.setTextSize(TypedValue.COMPLEX_UNIT_PX, i);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                value = seekBar.getProgress();

            }
        });
    }
    public void colorchange(View view){
        switch(view.getId()) {
            case R.id.red:
                color="RED";
                editText.setTextColor(Color.parseColor("#ff0000"));
                break;
            case R.id.blue:
                color="BLUE";
                editText.setTextColor(Color.parseColor("#0000ff"));
                break;
            case R.id.green:
                color="GREEN";
                editText.setTextColor(Color.parseColor("#33cc33"));
                break;
        }
    }
    public void saving(View view){
        SharedPreferences sharedPreferences=getSharedPreferences("saveinfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("message",editText.getText().toString());
        editor.putString("color",color);
        editor.putFloat("size",value);
        editor.commit();
    }
    public void clearing(View view){
        SharedPreferences sharedPreferences=getSharedPreferences("saveinfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }
}
