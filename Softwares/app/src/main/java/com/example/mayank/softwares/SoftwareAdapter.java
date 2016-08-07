package com.example.mayank.softwares;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayank on 02-07-2016.
 */
public class SoftwareAdapter extends ArrayAdapter {
    List list=new ArrayList();
    public SoftwareAdapter(Context context, int resource) {
        super(context, resource);
    }

    public static class Handler{
        TextView sno;
        TextView name;
        ImageView img;
    }
    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount()
    {
        return this.list.size();
    }

    @Override
    public Object getItem(int position)
    {
        return this.list.get(position);

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row=convertView;
        Handler handler=new Handler();
            LayoutInflater  inflater=(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.rowlayout,parent,false);
            handler.sno=(TextView) row.findViewById(R.id.textView);
            handler.name=(TextView) row.findViewById(R.id.textView2);
            handler.img=(ImageView)row.findViewById(R.id.img);
            row.setTag(handler);
        SoftwareDataHandler softwareDataHandler;
        softwareDataHandler=(SoftwareDataHandler)this.getItem(position);
        handler.sno.setText(softwareDataHandler.getSno());
        handler.name.setText(softwareDataHandler.getName());
        handler.img.setImageResource(softwareDataHandler.getImage());
        return row;
    }
}
