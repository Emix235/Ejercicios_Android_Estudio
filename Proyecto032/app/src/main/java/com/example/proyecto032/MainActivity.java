package com.example.proyecto032;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener{
    TextView tv1;
    MediaRecorder recorder;
    MediaPlayer player;
    File archivo;
    Button b1, b2, b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) this.findViewById(R.id.textView);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
    }
    public void grabar(View v) {
        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        File path = new File(Environment.getExternalStorageDirectory()
                .getPath());
        try {
            archivo = File.createTempFile("temporal", ".3gp", path);
        } catch (IOException e) {
        }
        recorder.setOutputFile(archivo.getAbsolutePath());
        try {
            recorder.prepare();
        } catch (IOException e) {
        }
        recorder.start();
        tv1.setText("Grabando");
        b1.setEnabled(false);
        b2.setEnabled(true);
    }
    public void detener(View v) {
        recorder.stop();
        recorder.release();
        player = new MediaPlayer();
        player.setOnCompletionListener(this);
        try {
            player.setDataSource(archivo.getAbsolutePath());
        } catch (IOException e) {
        }
        try {
            player.prepare();
        } catch (IOException e) {
        }
        b1.setEnabled(true);
        b2.setEnabled(false);
        b3.setEnabled(true);
        tv1.setText("Listo para reproducir");
    }
    public void reproducir(View v) {
        player.start();
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        tv1.setText("Reproduciendo");
    }
    public void onCompletion(MediaPlayer mp) {
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        tv1.setText("Listo");
    }
}