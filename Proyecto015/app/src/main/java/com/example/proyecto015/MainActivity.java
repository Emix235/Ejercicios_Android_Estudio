package com.example.proyecto015;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "MyChannel";
    private static final String PREFERENCE_KEY = "Score";
    private int randomNumber;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotificationChannel();

        // Generar número aleatorio al iniciar la aplicación
        generateRandomNumber();

        // Obtener el puntaje guardado desde SharedPreferences
        score = getScoreFromPreferences();

        // Configurar la interfaz de usuario
        configureUI();
    }
    private void generateRandomNumber() {
        Random random = new Random();
        randomNumber = random.nextInt(50) + 1;
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "My Channel";
            String description = "Channel for notifications";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private void configureUI() {
        final EditText guessEditText = findViewById(R.id.guessEditText);
        Button submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!guessEditText.getText().toString().isEmpty()) {
                    int userGuess = Integer.parseInt(guessEditText.getText().toString());
                    checkGuess(userGuess);
                } else {
                    Toast.makeText(MainActivity.this, "Ingrese un número", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void checkGuess(int userGuess) {
        if (userGuess == randomNumber) {
            // Adivinó el número
            score++;
            saveScoreToPreferences(score);
            showNotification("¡Felicidades!", "Número correcto. Puntaje: " + score);
            generateRandomNumber();  // Generar un nuevo número para el siguiente intento
        } else if (userGuess < randomNumber) {
            // Número demasiado bajo
            showNotification("Intenta de nuevo", "El número es mayor");
        } else {
            // Número demasiado alto
            showNotification("Intenta de nuevo", "El número es menor");
        }
    }

    private void showNotification(String title, String message) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        //notificationManager.notify(1, builder.build());
    }

    private int getScoreFromPreferences() {
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        return sharedPreferences.getInt(PREFERENCE_KEY, 0);
    }

    private void saveScoreToPreferences(int score) {
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(PREFERENCE_KEY, score);
        editor.apply();
    }
}