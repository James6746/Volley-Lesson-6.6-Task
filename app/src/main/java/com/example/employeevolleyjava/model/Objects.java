package com.example.employeevolleyjava.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Objects {

    @SerializedName(value = "status")
    private String status;

    @SerializedName(value = "data")
    private ArrayList<Employee> employees;

    @SerializedName(value = "message")
    private String message;

    public String getStatus() {
        return status;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Objects{" +
                "status='" + status + '\'' +
                ", employees=" + employees +
                ", message='" + message + '\'' +
                '}';
    }
}
