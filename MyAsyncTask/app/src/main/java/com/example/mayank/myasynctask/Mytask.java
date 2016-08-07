package com.example.mayank.myasynctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by mayank on 23-07-2016.
 */
public class Mytask extends AsyncTask<Void,Integer,String> {
    Context context;
    TextView textView;
    Button button;
    ProgressDialog progressDialog;

    public Mytask(Context context,TextView textView,Button button) {
        this.button = button;
        this.context = context;
        this.textView = textView;
    }

    @Override
    protected String doInBackground(Void... voids) {
        int i=0;
        synchronized (this){
            while(i<10) {
                try {
                    wait(1500);
                    i++;
                    publishProgress(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return "Download compleated..";
    }

    @Override
    protected void onPostExecute(String aVoid) {
        textView.setText(aVoid);
        button.setEnabled(true);
        progressDialog.hide();
    }

    @Override
    protected void onPreExecute() {
        progressDialog=new ProgressDialog(context);
        progressDialog.setTitle("Download In Progress..");
        progressDialog.setMax(10);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();

        button.setEnabled(false);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int progress=values[0];
        progressDialog.setProgress(progress);
        textView.setText("Downloading in progress..");
    }

}
