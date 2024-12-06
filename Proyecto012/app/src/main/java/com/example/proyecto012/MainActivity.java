package com.example.proyecto012;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText et1;
    private Button btnNavigate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.et);
        btnNavigate = findViewById(R.id.btn);
        btnNavigate.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                navigateToWebView();
            }
        });
    }
    private void navigateToWebView() {
        String url = et1.getText().toString();

        Intent intent = new Intent(this, Actividad2.class);
        intent.putExtra("url", url);
        startActivity(intent);
    }
}