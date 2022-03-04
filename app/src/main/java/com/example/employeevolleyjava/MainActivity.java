package com.example.employeevolleyjava;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.employeevolleyjava.model.Employee;
import com.example.employeevolleyjava.volley.VolleyHandler;
import com.example.employeevolleyjava.volley.VolleyHttp;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        workWithVolley();
    }

    private void workWithVolley() {

        Employee employee = new Employee(256, "Jamshid", 3000, 21, "");

        VolleyHttp.post(VolleyHttp.API_CREATE_POST, VolleyHttp.paramsCreate(employee), new VolleyHandler() {
            @Override
            public void onSuccess(String response) {
                Log.d("@@@James", response);
            }

            @Override
            public void onError(String error) {

            }
        });

        VolleyHttp.get(VolleyHttp.API_LIST_POST, VolleyHttp.paramsEmpty(), new VolleyHandler() {
            @Override
            public void onSuccess(String response) {
                Log.d("@@@James", response);
            }

            @Override
            public void onError(String error) {
                Log.d("@@@JamesError", error);
            }
        });

        Employee employee2 = new Employee(256, "James", 3000, 21, "");
        VolleyHttp.put(VolleyHttp.API_UPDATE_POST + employee.getId(), VolleyHttp.paramsUpdate(employee2), new VolleyHandler() {
            @Override
            public void onSuccess(String response) {
                Log.d("@@@James", response);
            }

            @Override
            public void onError(String error) {
                Log.d("@@@JamesError", error);
            }
        });


        VolleyHttp.del(VolleyHttp.API_DELETE_POST + employee2.getId(), new VolleyHandler() {
            @Override
            public void onSuccess(String response) {
                Log.d("@@@James", response);
            }

            @Override
            public void onError(String error) {
                Log.d("@@@James", error);
            }
        });
    }
}