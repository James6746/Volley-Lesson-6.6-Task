package com.example.employeevolleykotlin.volley

import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.example.employeevolleykotlin.MyApplication
import com.example.employeevolleykotlin.model.Employee
import org.json.JSONObject

object VolleyHttp {
    var TAG = VolleyHttp::class.java.simpleName
    var IS_TESTER = true
    var SERVER_DEVELOPMENT = "http://dummy.restapiexample.com/api/v1/"
    var SERVER_PRODUCTION = "http://dummy.restapiexample.com/api/v1/"

    /**
     * Request Api`s
     */
    var API_LIST_POST = "employees"
    var API_SINGLE_POST = "employee/" //id
    var API_CREATE_POST = "create"
    var API_UPDATE_POST = "update/" //id
    var API_DELETE_POST = "delete/" //id
    fun server(url: String): String {
        return if (IS_TESTER) SERVER_DEVELOPMENT + url else SERVER_PRODUCTION + url
    }

    fun headers(): HashMap<String, String> {
        val headers = HashMap<String, String>()
        headers["Content-type"] = "application/json; charset=UTF-8"
        return headers
    }

    /*
     *  Request Method`s
     */
    operator fun get(api: String, params: HashMap<String, String>?, volleyHandler: VolleyHandler) {
        val stringRequest: StringRequest = object : StringRequest(
            Request.Method.GET, server(api),
            Response.Listener<String?> { response ->
                Log.d(TAG, response!!)
                volleyHandler.onSuccess(response)
            },
            Response.ErrorListener { error ->
                Log.d(TAG, error.toString())
                volleyHandler.onError(error.toString())
            }) {

            override fun getParams(): HashMap<String, String>? {
                return params
            }
        }
        MyApplication.instance!!.addToRequestQueue(stringRequest)
    }

    fun post(api: String, body: HashMap<String, Any>, volleyHandler: VolleyHandler) {
        val stringRequest: StringRequest = object : StringRequest(Request.Method.POST, server(api),
            Response.Listener<String?> { response ->
                Log.d(TAG, response!!)
                volleyHandler.onSuccess(response)
            },
            Response.ErrorListener { error ->
                Log.d(TAG, error.toString())
                volleyHandler.onError(error.toString())
            }) {

            override fun getHeaders(): MutableMap<String, String> {
                return headers()
            }

            override fun getBody(): ByteArray {
                return JSONObject(body as Map<*, *>).toString().toByteArray()
            }
        }
        MyApplication.instance!!.addToRequestQueue(stringRequest)
    }

    fun put(api: String, body: HashMap<String, Any>, volleyHandler: VolleyHandler) {
        val stringRequest: StringRequest = object : StringRequest(Request.Method.PUT, server(api),
            Response.Listener<String?> { response ->
                Log.d(TAG, response!!)
                volleyHandler.onSuccess(response)
            },
            Response.ErrorListener { error ->
                Log.d(TAG, error.toString())
                volleyHandler.onError(error.toString())
            }) {
            override fun getHeaders(): MutableMap<String, String> {
                return headers()
            }

            override fun getBody(): ByteArray {
                return JSONObject(body as Map<*, *>).toString().toByteArray()
            }
        }
        MyApplication.instance!!.addToRequestQueue(stringRequest)
    }

    fun del(url: String, volleyHandler: VolleyHandler) {
        val stringRequest: StringRequest =
            object : StringRequest(Request.Method.DELETE, server(url),
                Response.Listener<String?> { response ->
                    Log.d(TAG, response!!)
                    volleyHandler.onSuccess(response)
                },
                Response.ErrorListener { error ->
                    Log.d(TAG, error.toString())
                    volleyHandler.onError(error.toString())
                }) {}
        MyApplication.instance!!.addToRequestQueue(stringRequest)
    }

    fun paramsEmpty(): HashMap<String, String> {
        return HashMap()
    }

    fun paramsCreate(employee: Employee): HashMap<String, Any> {
        val params = HashMap<String, Any>()
        params["id"] = employee.id
        params["age"] = employee.employee_age
        params["name"] = employee.employee_name
        params["salary"] = employee.employee_salary
        params["image"] = employee.profile_image
        return params
    }

    fun paramsUpdate(employee: Employee): HashMap<String, Any> {
        val params = HashMap<String, Any>()
        params["id"] = employee.id
        params["age"] = employee.employee_age
        params["name"] = employee.employee_name
        params["salary"] = employee.employee_salary
        params["image"] = employee.profile_image
        return params
    }
}