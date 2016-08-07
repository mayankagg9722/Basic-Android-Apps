package com.example.mayank.jsonobject;

import android.app.DownloadManager;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView name,email,location;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        name=(TextView)findViewById(R.id.textView);
        email=(TextView)findViewById(R.id.textView2);
        location=(TextView)findViewById(R.id.textView3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, "http://open-event-dev.herokuapp.com/api/v2/events/5"
                        , (String) null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            name.setText(response.getString("name"));
                            email.setText(response.getString("email"));
                            location.setText(response.getString("location_name"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),"There Is Some Error",Toast.LENGTH_LONG).show();
                    }
                });
                Mysingelton.getmInstance(MainActivity.this).addtorequestqueue(jsonObjectRequest);
            }
        });

    }
}
