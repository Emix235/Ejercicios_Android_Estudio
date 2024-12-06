package com.example.proyecto15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText ent1;
    private TextView tv1;
    private int numeroA;
    private int puntaje =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ent1 = (EditText) findViewById(R.id.ent1);
        tv1 = (TextView) findViewById(R.id.tv1);
        numeroA=(int)(Math.random()*50);

    }

    public void valorar(View v){
        String Aevaluar = ent1.getText().toString();
        int valor=Integer.parseInt(Aevaluar);

        if (valor==numeroA) {
            Toast notificacion=Toast.makeText(this,"Muy bien ganaste un punto :D",Toast.LENGTH_LONG);
            notificacion.show();
            tv1.setText("Puntaje: "+(puntaje=puntaje+1));
            numeroA=(int)(Math.random()*50);
        }else if (valor > numeroA){
            Toast notificacion=Toast.makeText(this,"El numero ingresado es Mayor :(",Toast.LENGTH_LONG);
            notificacion.show();
        }else {
            Toast notificacion=Toast.makeText(this,"El numero ingresado es Menor :(",Toast.LENGTH_LONG);
            notificacion.show();
        }

    }
}