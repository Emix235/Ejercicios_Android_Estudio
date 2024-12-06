package com.example.proyecto045;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText num1EditText, num2EditText;
    private RadioButton sumRadioButton, subtractRadioButton;
    private Button resolveButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1EditText = findViewById(R.id.et1);
        num2EditText = findViewById(R.id.et2);
        sumRadioButton = findViewById(R.id.rb1);
        subtractRadioButton = findViewById(R.id.rb2);
        resolveButton = findViewById(R.id.button);
        resultTextView = findViewById(R.id.result);

        resolveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAndDisplayResult();
            }
        });
    }

    private void calculateAndDisplayResult(){
        double num1 = Double.parseDouble(num1EditText.getText().toString());
        double num2 = Double.parseDouble(num2EditText.getText().toString());

        double result;
        if (sumRadioButton.isChecked()) {
            result = num1 + num2;
        } else if (subtractRadioButton.isChecked()) {
            result = num1 - num2;
        } else {
            result = 0; // No radio button selected, handle accordingly
        }
        resultTextView.setText("Result: " + result);
    }
}