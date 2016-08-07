package com.example.mayank.swipeview;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class SwipeFragment extends android.support.v4.app.Fragment {

TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view=inflater.inflate(R.layout.fragment_swipe,container,false);
        textView=(TextView)view.findViewById(R.id.textView);
        Bundle bundle=getArguments();
        textView.setText("This is "+Integer.toString(bundle.getInt("count"))+" swipe screen..");
        return view;

    }


}
