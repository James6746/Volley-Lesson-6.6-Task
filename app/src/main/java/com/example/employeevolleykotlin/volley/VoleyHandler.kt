package com.example.employeevolleykotlin.volley

interface VolleyHandler {
    fun onSuccess(response: String?)
    fun onError(error: String?)
}
