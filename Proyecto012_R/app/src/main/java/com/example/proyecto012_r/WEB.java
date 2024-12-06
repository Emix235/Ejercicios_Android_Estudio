package com.example.proyecto012_r;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class WEB extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        webView = findViewById(R.id.webView);

        // Obtener la URL de la actividad anterior
        String url = getIntent().getStringExtra("url");

        // Cargar la URL en el WebView
        webView.loadUrl(url);
    }
    public void finalizar(View v) {
        finish();
    }
}