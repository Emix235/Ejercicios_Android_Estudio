package com.example.proyecto028;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void ejecutar(View v) {
        MediaPlayer mp = new MediaPlayer();
        try {
            //mp.setDataSource("http://www.altacapacidad.com/repositorio/mp3/creatividad_inteligente32.mp3");
            mp.setDataSource("https://altacapacidad.com/wp-content/uploads/2023/09/79_Ep-Completo-Beatriz-Valderrama-EMCC.mp3");
            mp.prepare();
            mp.start();
        } catch (IOException e) {
        }
    }
}