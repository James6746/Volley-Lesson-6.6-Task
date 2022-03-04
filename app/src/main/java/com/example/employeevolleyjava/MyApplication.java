package com.example.employeevolleyjava;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MyApplication extends Application {

    public static String TAG = MyApplication.class.getSimpleName();
    public static MyApplication instance = null;

    RequestQueue requestQueue = null;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            return Volley.newRequestQueue(getApplicationContext());
        } else
            return requestQueue;
    }


    public <T> void addToRequestQueue(Request<T> request){
        request.setTag(TAG);
        getRequestQueue().add(request);
    }


}
