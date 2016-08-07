package com.example.mayank.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by mayank on 14-07-2016.
 */
public class Fragment_one extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        ListView listView;
        ArrayAdapter<String> adapter;
        String name[];
        view=inflater.inflate(R.layout.fragment_layout_one,container,false);
        listView=(ListView) view.findViewById(R.id.listView);
        name=getResources().getStringArray(R.array.name);
        adapter=new ArrayAdapter<String>(getActivity(),R.layout.list_view,R.id.textview,name);
        listView.setAdapter(adapter);
        return view;
    }
}
