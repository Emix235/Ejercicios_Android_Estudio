package com.example.proyecto035;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout layout1 = (RelativeLayout) findViewById(R.id.layout1);
        Lienzo fondo = new Lienzo(this);
        layout1.addView(fondo);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    class Lienzo extends View {

        public Lienzo(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            canvas.drawRGB(255, 255, 255);
            int ancho = canvas.getWidth();
            int alto = canvas.getHeight();

            Paint pincel1 = new Paint();
            pincel1.setARGB(255, 255, 0, 0);
            canvas.drawLine(70, 0, 70, alto, pincel1);
            canvas.drawLine(73, 0, 73, alto, pincel1);
            pincel1.setARGB(255, 0, 0, 0);
            int cantLineas = alto / 30 - 2;
            for (int fila = 0; fila < cantLineas; fila++) {
                canvas.drawLine(0, fila * 30 + 60, ancho, fila * 30 + 60,
                        pincel1);
            }
        }
    }
}