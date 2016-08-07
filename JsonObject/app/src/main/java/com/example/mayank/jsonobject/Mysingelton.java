package com.example.mayank.jsonobject;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by mayank on 25-07-2016.
 */
public class Mysingelton {

    private static Mysingelton mInstance;
    private static Context ctx;
    private RequestQueue requestQueue;

    private Mysingelton(Context ctx) {
        this.ctx = ctx;
        this.requestQueue = getrequestqueue();


    }
    public RequestQueue getrequestqueue()
    {
        if(requestQueue==null)
            requestQueue= Volley.newRequestQueue(ctx.getApplicationContext());
        return  requestQueue;
    }

  public static synchronized Mysingelton getmInstance(Context ctx){
      if(mInstance==null)
          mInstance=new Mysingelton(ctx.getApplicationContext());
      return mInstance;
  }
    public <T> void addtorequestqueue(Request <T> request){
        requestQueue.add(request);
    }



}

