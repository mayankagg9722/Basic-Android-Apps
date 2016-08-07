package com.example.mayank.myexpandablelist;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by mayank on 24-07-2016.
 */
public class Mylist extends BaseExpandableListAdapter {
    private List<String> head_title;
    private HashMap<String,List<String>> child_title;
    private Context context;

    public Mylist(Context context, List<String> head_title, HashMap<String, List<String>> child_title) {
        this.context = context;
        this.head_title = head_title;
        this.child_title = child_title;
    }

    @Override
    public int getGroupCount() {
        return head_title.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return child_title.get(head_title.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return head_title.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return child_title.get(head_title.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String title=(String)this.getGroup(i);
        if(view==null){
            LayoutInflater layoutInflater=(LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=layoutInflater.inflate(R.layout.parent_layout,null);
        }
        TextView textView=(TextView)view.findViewById(R.id.head_item);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setText(title);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        String title=(String)this.getChild(i,i1);
        if(view==null){
            LayoutInflater layoutInflater=(LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=layoutInflater.inflate(R.layout.child_layout,null);
        }
        TextView textView=(TextView)view.findViewById(R.id.child_item);
        textView.setText(title);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
