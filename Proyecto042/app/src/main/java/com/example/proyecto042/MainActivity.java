package com.example.proyecto042;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
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
        RelativeLayout layout1 = (RelativeLayout) findViewById(R.id.layout1);
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
            int ancho = canvas.getWidth();
            int alto = canvas.getHeight();
            Bitmap bmp = BitmapFactory.decodeResource(getResources(),
                    R.mipmap.imagen1);
            canvas.drawBitmap(bmp,(ancho-250)/2, (alto-200)/2,null);
        }
    }

}