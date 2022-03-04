package com.example.employeevolleykotlin

import android.app.Application
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley


class MyApplication : Application() {
    private var requestQueue: RequestQueue? = null
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    @JvmName("getRequestQueue1")
    fun getRequestQueue(): RequestQueue {
        return requestQueue ?: Volley.newRequestQueue(applicationContext)
    }

    fun <T> addToRequestQueue(request: Request<T>) {
        request.tag = TAG
        getRequestQueue().add(request)
    }

    companion object {
        var TAG = MyApplication::class.java.simpleName
        var instance: MyApplication? = null
    }
}