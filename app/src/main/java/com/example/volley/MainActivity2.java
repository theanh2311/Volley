package com.example.volley;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.invoke.LambdaConversionException;

public class MainActivity2 extends AppCompatActivity {
Button btnInsert,btnDelete,btnUpdate;
EditText edt_pid,edt_name,edt_price,edt_des;
TextView tvkq2;
Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnInsert = findViewById(R.id.btn_insert);
        btnDelete = findViewById(R.id.btn_delete);
        btnUpdate = findViewById(R.id.btn_update);
        edt_pid = findViewById(R.id.edt_pid);
        edt_name = findViewById(R.id.edt_name);
        edt_price = findViewById(R.id.edt_price);
        edt_des = findViewById(R.id.edt_des);
        tvkq2 = findViewById(R.id.tv_kq2);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertVolley();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateVolley();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteVolley();
            }
        });
    }


    public void insertVolley(){
        new Function2().insert_volley_POST(context,tvkq2,edt_name,edt_price,edt_des);
    }
    public void deleteVolley(){
        new Function2().delete_volley_POST(context,tvkq2,edt_pid);
    }
    public void updateVolley(){
        new Function2().update_volley_POST(context,tvkq2,edt_pid,edt_name,edt_price,edt_des);
    }
}