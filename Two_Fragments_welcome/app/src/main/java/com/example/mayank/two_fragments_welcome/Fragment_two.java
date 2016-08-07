package com.example.mayank.two_fragments_welcome;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by mayank on 15-07-2016.
 */
public class Fragment_two extends Fragment {
    TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        view=inflater.inflate(R.layout.fragment_two,container,false);
        textView=(TextView)view.findViewById(R.id.textView3);
        textView.setVisibility(View.INVISIBLE);
        return view;
    }
    public void updateinfo(String name){
        textView.setText("Helllo "+name);
        textView.setVisibility(View.VISIBLE);
    }

}
