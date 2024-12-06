package com.example.proyecto027;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void ejecutar(View v) {
        Uri datos = Uri.parse(Environment.getExternalStorageDirectory()
                .getPath() + "/gato.mp3");
        MediaPlayer mp = MediaPlayer.create(this, datos);
        mp.start();
    }



}