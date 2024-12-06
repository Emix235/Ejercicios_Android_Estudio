package com.example.proyecto029;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements MediaPlayer.OnPreparedListener{
        private MediaPlayer mp;
        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        }
        public void ejecutar (View v){
        mp = new MediaPlayer();
        mp.setOnPreparedListener(this);
        try {
            mp.setDataSource("https://altacapacidad.com/wp-content/uploads/2023/09/79_Ep-Completo-Beatriz-Valderrama-EMCC.mp3");
            mp.prepareAsync();
        } catch (IOException e) {
        }
        Toast t = Toast.makeText(this,
                "Espere un momento mientras se carga el mp3",
                Toast.LENGTH_SHORT);
        t.show();
    }
        @Override
        public void onPrepared (MediaPlayer mp){
        mp.start();
    }
    }