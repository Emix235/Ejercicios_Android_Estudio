package com.example.proyecto022;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView iv1;
    private Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv1=(ImageView)findViewById(R.id.imageView);
        b1=(Button)findViewById(R.id.button);
    }
    public void ocultar(View v) {
        b1.setVisibility(View.INVISIBLE);
        iv1.setVisibility(View.VISIBLE);
        changeColor();
    }
    private void changeColor(){
        // Cambia el color del ImageView a un color aleatorio
           String randomColor = "#FF3366";
        iv1.setBackgroundColor(Color.parseColor(randomColor));
    }

}