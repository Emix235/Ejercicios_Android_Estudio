package com.example.proyecto039;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout layout1 =(RelativeLayout)findViewById(R.id.layout1);
        Lienzo fondo = new Lienzo(this);
        layout1.addView(fondo);
        getSupportActionBar().hide();
    }
    class Lienzo extends View {
        public Lienzo(Context context) {
            super(context);
        }
        protected void onDraw(Canvas canvas) {
            canvas.drawRGB(0, 0, 255);

            Paint pincel1 = new Paint();
            pincel1.setARGB(255, 255, 0, 0);
            pincel1.setTextSize(30);
            pincel1.setTypeface(Typeface.SERIF);
            canvas.drawText("Hola Mundo (SERIF)", 0, 70, pincel1);
            pincel1.setTypeface(Typeface.SANS_SERIF);
            canvas.drawText("Hola Mundo (SANS SERIF)", 0, 100, pincel1);
            pincel1.setTypeface(Typeface.MONOSPACE);
            canvas.drawText("Hola Mundo (MONOSPACE)", 0, 140, pincel1);
            Typeface tf = Typeface.create(Typeface.SERIF, Typeface.ITALIC);
            pincel1.setTypeface(tf);
            canvas.drawText("Hola Mundo (SERIF ITALIC)", 0, 180, pincel1);
            tf = Typeface.create(Typeface.SERIF,  Typeface.BOLD);
            //  Typeface.ITALIC |
            pincel1.setTypeface(tf);
            canvas.drawText("Hola Mundo (SERIF ITALIC BOLD)", 0, 220, pincel1);
        }
    }
}