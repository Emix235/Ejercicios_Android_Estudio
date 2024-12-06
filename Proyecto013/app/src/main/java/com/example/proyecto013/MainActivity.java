package com.example.proyecto013;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.et1);
        SharedPreferences prefe = getSharedPreferences("datos", Context.MODE_PRIVATE);
        et1.setText(prefe.getString("mail",""));
    }
    public void ejecutar(View v) {
        SharedPreferences preferencias = getSharedPreferences("datos",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferencias.edit();
        editor.putString("mail", et1.getText().toString());
        editor.putInt("edad",3);
        editor.putBoolean("activo", true);
        editor.putFloat("altura", 2.3f);
        editor.commit();
        finish();
    }
}