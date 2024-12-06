package com.example.proyecto012;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class Actividad2 extends AppCompatActivity {
    private WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);
        web=findViewById(R.id.web1);
        Bundle bundle = getIntent().getExtras();
        String url = bundle.getString("url");
        // Cargar la URL en el WebView
        web.loadUrl(url);
    }
    public void finalizar(View v) {
        finish();
    }
}