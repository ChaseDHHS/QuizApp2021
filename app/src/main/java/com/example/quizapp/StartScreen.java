package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartScreen extends AppCompatActivity {
    Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        startButton = (Button) findViewById(R.id.StartButton);


        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityStartScreen();
            }
        });
    }
    private void openActivityStartScreen() {
        Intent intent = new Intent(StartScreen.this, MainActivity.class);
        startActivity(intent);
    }
}