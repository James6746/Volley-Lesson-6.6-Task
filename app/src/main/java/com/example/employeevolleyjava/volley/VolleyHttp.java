package com.example.employeevolleyjava.volley;

import android.util.Log;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.employeevolleyjava.MyApplication;
import com.example.employeevolleyjava.model.Employee;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class VolleyHttp {

    public static String TAG = VolleyHttp.class.getSimpleName();
    public static boolean IS_TESTER = true;
    public static String SERVER_DEVELOPMENT = "http://dummy.restapiexample.com/api/v1/";
    public static String SERVER_PRODUCTION = "http://dummy.restapiexample.com/api/v1/";

    /**
     * Request Api`s
     */

    public static String API_LIST_POST = "employees";
    public static String API_SINGLE_POST = "employee/";//id
    public static String API_CREATE_POST = "create";
    public static String API_UPDATE_POST = "update/";//id
    public static String API_DELETE_POST = "delete/";//id


    public static String server(String url) {
        if (IS_TESTER)
            return SERVER_DEVELOPMENT + url;
        return SERVER_PRODUCTION + url;
    }

    public static HashMap<String, String> headers() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-type", "application/json; charset=UTF-8");
        return headers;
    }

    /*
     *  Request Method`s
     */

    public static void get(String api, HashMap<String, String> params, VolleyHandler volleyHandler) {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, server(api),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, response);
                        volleyHandler.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, error.toString());
                        volleyHandler.onError(error.toString());
                    }

                }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };
        MyApplication.instance.addToRequestQueue(stringRequest);
    }

    public static void post(String api, HashMap<String, Object> body, VolleyHandler volleyHandler) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, server(api),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, response);
                        volleyHandler.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, error.toString());
                        volleyHandler.onError(error.toString());
                    }

                }) {
            @Override
            public Map<String, String> getHeaders() {
                return headers();
            }

            @Override
            public byte[] getBody() {
                return new JSONObject(body).toString().getBytes();
            }
        };
        MyApplication.instance.addToRequestQueue(stringRequest);
    }

    public static void put(String api, HashMap<String, Object> body, VolleyHandler volleyHandler) {
        StringRequest stringRequest = new StringRequest(Request.Method.PUT, server(api),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, response);
                        volleyHandler.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, error.toString());
                        volleyHandler.onError(error.toString());
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() {
                return headers();
            }

            @Override
            public byte[] getBody() {
                return new JSONObject(body).toString().getBytes();
            }
        };
        MyApplication.instance.addToRequestQueue(stringRequest);
    }

    public static void del(String url, VolleyHandler volleyHandler) {
        StringRequest stringRequest = new StringRequest(Request.Method.DELETE, server(url),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, response);
                        volleyHandler.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, error.toString());
                        volleyHandler.onError(error.toString());
                    }
                }) {
        };
        MyApplication.instance.addToRequestQueue(stringRequest);
    }


    public static HashMap<String, String> paramsEmpty() {
        return new HashMap<>();
    }

    public static HashMap<String, Object> paramsCreate(Employee employee) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", employee.getId());
        params.put("age", employee.getEmployee_age());
        params.put("name", employee.getEmployee_name());
        params.put("salary", employee.getEmployee_salary());
        params.put("image", employee.getProfile_image());
        return params;
    }

    public static HashMap<String, Object> paramsUpdate(Employee employee) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", employee.getId());
        params.put("age", employee.getEmployee_age());
        params.put("name", employee.getEmployee_name());
        params.put("salary", employee.getEmployee_salary());
        params.put("image", employee.getProfile_image());
        return params;
    }
}
