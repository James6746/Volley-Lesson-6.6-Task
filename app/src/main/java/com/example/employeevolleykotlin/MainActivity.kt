package com.example.employeevolleykotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.employeevolleykotlin.model.Employee
import com.example.employeevolleykotlin.volley.VolleyHandler
import com.example.employeevolleykotlin.volley.VolleyHttp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        workWithVolley()
    }

    private fun workWithVolley() {
        val employee = Employee(256, "Jamshid", 3000, 21, "")

        VolleyHttp.post(
            VolleyHttp.API_CREATE_POST,
            VolleyHttp.paramsCreate(employee),
            object : VolleyHandler {
                override fun onSuccess(response: String?) {
                    Log.d("@@@James", "post " + response!!)
                }

                override fun onError(error: String?) {}
            })

        VolleyHttp.get(
            VolleyHttp.API_LIST_POST,
            VolleyHttp.paramsEmpty(),
            object : VolleyHandler {
                override fun onSuccess(response: String?) {
                    Log.d("@@@James", "get " + response!!)
                }

                override fun onError(error: String?) {
                    Log.d("@@@JamesError", "get " + error!!)
                }
            })

        val employee2 = Employee(256, "James", 3000, 21, "13")
        VolleyHttp.put(
            VolleyHttp.API_UPDATE_POST + employee.id,
            VolleyHttp.paramsUpdate(employee2),
            object : VolleyHandler {
                override fun onSuccess(response: String?) {
                    Log.d("@@@James", "put " + response!!)
                }

                override fun onError(error: String?) {
                    Log.d("@@@JamesError", "put " + error!!)
                }
            })

        VolleyHttp.del(VolleyHttp.API_DELETE_POST + employee2.id, object : VolleyHandler {
            override fun onSuccess(response: String?) {
                Log.d("@@@James", "del " + response!!)
            }

            override fun onError(error: String?) {
                Log.d("@@@James", "del " + error!!)
            }
        })
    }
}