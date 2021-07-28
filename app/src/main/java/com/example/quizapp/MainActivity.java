package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView question;
    Button trueButton;
    Button falseButton;
    int score;
    Button nextButton;


    String message;

    Question q1, q2, q3, q4, q5, currentQ;
    Question [] questions;
    int currentQindex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question = (TextView)findViewById(R.id.Question);
        trueButton = (Button) findViewById(R.id.TrueButton);
        falseButton = (Button) findViewById(R.id.FalseButton);
        nextButton = (Button) findViewById(R.id.NextButton);
        score = 0;
        currentQindex = 0;
        q1 = new Question("LA is a state", false);
        q2 = new Question("Maryland is a state" , true);
        q3 = new Question("Miami is a state", false);
        q4 = new Question("Maine is a state", true);
        q5 = new Question("Las Vegas is a state", false);
        questions = new Question[]{q1,q2,q3,q4,q5};
        currentQ = questions[0];

        trueButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                String text;
                if (currentQ.isCorrectAnswer() == true){
                    text = "Nice Job!";
                }
                else {
                    text = "Sorry, try Again!";
                }

                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text;
                if (currentQ.isCorrectAnswer() == false){
                    text = "Nice Job!";
                }
                else {
                    text = "Sorry, try Again!";
                }


                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScoreActivity.class);
                intent.putExtra("scoreLBL", score);
                startActivity(intent);
            }
        });


    }
}