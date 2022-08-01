package com.example.volley;

import android.content.Context;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonIOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Function {
    //doc data dang chuoi
    public  void getStringVolley(Context context, TextView textView){
        //B1. Tao request
        RequestQueue queue = Volley.newRequestQueue(context);
        //B2. url
        String url = "https://www.google.com/";
        //B3. Truyen tham so
        //StringRequest(phuongThuc,Url,thanhcong,thatbai)
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //lay ve 1000 ky thu
                        textView.setText("Kq: "+response.substring(0,1000));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText(error.getMessage());
            }
        });
        queue.add(stringRequest);
    }
    //doc du lieu dang mang cac doi tuong
String strJson = "";
    public void getJsonArray_of_objects(Context context,TextView text){
        strJson = "";
        //b1 tao request
        RequestQueue queue = Volley.newRequestQueue(context);
        //b2url
        String url = "https://batdongsanabc.000webhostapp.com/mob403lab3/array_json_new.json";
        //b3 goi request(goi mang cua doi tuong)
        //goi mang truoc,goi doi tuong sau
        //JsonArrayRequest(url,thanh cong,that bai)
        JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                //den day ta lay dc mang
                //chuyen mang sang doi tuong
                for(int i=0;i<response.length();i++){
                    try {
                        JSONObject person = response.getJSONObject(i);
                        String name = person.getString("name");
                        String email = person.getString("email");
                        JSONObject phone = person.getJSONObject("phone");
                        String mobile = phone.getString("mobile");
                        String home = phone.getString("home");
                        //chuyen ket qua thanh chuoi
                        strJson += "Name: "+name+"\n\n";
                        strJson += "email: "+email+"\n\n";
                        strJson += "mobile: "+mobile+"\n\n";
                        strJson += "home: "+home+"\n\n";
                    }catch ( JSONException e){
                        e.printStackTrace();
                    }
                }
                text.setText(strJson);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                text.setText(error.getMessage());
            }
        });
        queue.add(request);

    }
}
