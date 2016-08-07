package com.example.mayank.fragment_activity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

/**
 * Created by mayank on 14-07-2016.
 */
public class Radiogroupfragment extends Fragment {
    OnColorChangelistener onColorChangelistener;
    RadioGroup radioGroup;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view;
        view = inflater.inflate(R.layout.fragment, container, false);
        RadioGroup radioGroup =(RadioGroup )view.findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.Red:
                        onColorChangelistener.colorchanged("Red");
                        break;
                    case R.id.Blue:
                        onColorChangelistener.colorchanged("Blue");
                        break;
                    case R.id.Green:
                        onColorChangelistener.colorchanged("Green");
                        break;
                }
            }
        });
        return view;
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            onColorChangelistener=(OnColorChangelistener)activity;
        }
        catch (Exception ex){}
    }

    public interface OnColorChangelistener{
        public void colorchanged(String name);

    }
}


