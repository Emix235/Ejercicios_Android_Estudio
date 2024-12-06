package com.example.proyecto012_r;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUrl;
    private Button btnNavigate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextUrl = findViewById(R.id.editTextUrl);
        btnNavigate = findViewById(R.id.btnNavigate);

        btnNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToWebView();
            }
        });

    }
    private void navigateToWebView() {
        String url = editTextUrl.getText().toString();

        Intent intent = new Intent(this, WEB.class);
        intent.putExtra("url", url);
        startActivity(intent);
    }

}