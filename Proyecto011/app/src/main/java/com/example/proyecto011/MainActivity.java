package com.example.proyecto011;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        password=(EditText)findViewById(R.id.pass);
    }
    public void BIENV(View view) {
        String c="abc123";
        String v= password.getText().toString();
        if (v.equals(c)) {
            Toast notificacion=Toast.makeText(this,"Exacto, Contraseña CORRECTA",Toast.LENGTH_LONG);
            notificacion.show();
            Intent i = new Intent(this, bienvenida.class );
            new CountDownTimer(1500, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    // Este método se llama en cada tick (cada segundo en este caso)
                }

                @Override
                public void onFinish() {
                    // Este método se llama cuando el temporizador llega a cero
                    // Realiza la acción que deseas después del retardo
                    startActivity(i);
                }
            }.start();
        }
        else {
            Toast notificacion=Toast.makeText(this,"¡Contraseña ERRONEA!",Toast.LENGTH_LONG);
            notificacion.show();
        }
    }
}