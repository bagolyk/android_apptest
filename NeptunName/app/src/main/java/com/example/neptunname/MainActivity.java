package com.example.neptunname;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    NeptunChanger change = new NeptunChanger();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button neptunButton = findViewById(R.id.neptunButton);
        Button asciiButton = findViewById(R.id.asciiButton);
        TextView resultView = findViewById(R.id.myTextView);
        EditText inputText = findViewById(R.id.myEditText);

        neptunButton.setOnClickListener(v -> {
            String answer = change.neptunIdchanger(inputText.getText().toString());
            resultView.setText("You're result: " + answer);
        });

        asciiButton.setOnClickListener(v -> {
            int answer=change.asciiSum(inputText.getText().toString());
            resultView.setText("You're result: " + answer);
        });
    }
}