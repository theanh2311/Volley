package com.example.volley;

import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Function2 {
    public  void insert_volley_POST(Context context, TextView tvKQ, EditText edtName, EditText edtPrice, EditText edtDescription){
        //tao request
        RequestQueue  queue = Volley.newRequestQueue(context);
        //url
        String url  = "https://emsiat.000webhostapp.com/API_Insert.php";
        //truyen tham so
        //stringRequest(method,url,ThanhCOng,ThatBai)
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                tvKQ.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tvKQ.setText(error.getMessage());
            }
        })
        {
            //truyen tham so
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> myData = new HashMap<>();
                myData.put("name",edtName.getText().toString());
                myData.put("price",edtPrice.getText().toString());
                myData.put("description",edtDescription.getText().toString());
                return myData;
            }
        };
        //b4. xu ly
        queue.add(stringRequest);
    }
    public  void update_volley_POST(Context context, TextView tvKQ, EditText edtpid,EditText edtName, EditText edtPrice, EditText edtDescription){
        //tao request
        RequestQueue  queue = Volley.newRequestQueue(context);
        //url
        String url  = "https://emsiat.000webhostapp.com/API_Update.php";
        //truyen tham so
        //stringRequest(method,url,ThanhCOng,ThatBai)
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                tvKQ.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tvKQ.setText(error.getMessage());
            }
        })
        {
            //truyen tham so
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> myData = new HashMap<>();
                myData.put("pid",edtpid.getText().toString());
                myData.put("name",edtName.getText().toString());
                myData.put("price",edtPrice.getText().toString());
                myData.put("description",edtDescription.getText().toString());
                return myData;
            }
        };
        //b4. xu ly
        queue.add(stringRequest);
    }
    public  void delete_volley_POST(Context context, TextView tvKQ, EditText edtpid){
        //tao request
        RequestQueue  queue = Volley.newRequestQueue(context);
        //url
        String url  = "https://emsiat.000webhostapp.com/API_Delete.php";
        //truyen tham so
        //stringRequest(method,url,ThanhCOng,ThatBai)
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                tvKQ.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tvKQ.setText(error.getMessage());
            }
        })
        {
            //truyen tham so
            @Override
            protected Map<String, String> getParams() {
                Map<String,String> myData = new HashMap<>();
                myData.put("pid",edtpid.getText().toString());
                return myData;
            }
        };
        //b4. xu ly
        queue.add(stringRequest);
    }
}
