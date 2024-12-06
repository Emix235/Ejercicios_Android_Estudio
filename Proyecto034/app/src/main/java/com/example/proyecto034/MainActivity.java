package com.example.proyecto034;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
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
    class Lienzo extends View {
        public Lienzo(Context context) {
            super(context);
        }
        protected void onDraw(Canvas canvas) {
            canvas.drawRGB(255, 255, 0);
            int ancho = canvas.getWidth();
            Paint pincel1 = new Paint();
            pincel1.setARGB(255, 255, 0, 0);
            canvas.drawLine(0, 30, ancho, 30, pincel1);
            pincel1.setStrokeWidth(4);
            canvas.drawLine(0, 60, ancho, 60, pincel1);
        }
    }
}