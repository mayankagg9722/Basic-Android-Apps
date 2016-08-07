package com.example.mayank.two_fragments_welcome;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by mayank on 15-07-2016.
 */
public class Fragment_one extends Fragment {
    Button button;
    TextView textView;
    Onclick onclick;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view;
        view=inflater.inflate(R.layout.fragment_one,container,false);
        button=(Button)view.findViewById(R.id.button);
        textView=(TextView)view.findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclick.clicked(textView.getText().toString());
            }
        });
        return view;
    }

    public interface Onclick{
        public void clicked(String name);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            onclick=(Onclick)activity;
        }catch (Exception ex){}
    }
}
