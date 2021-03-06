package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
    ImageView imageIC;//added for images
    int[] images = {R.drawable.baltimore, R.drawable.las_vegas, R.drawable.los_angelas, R.drawable.maine, R.drawable.miami };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //added for images
        imageIC = (ImageView) findViewById(R.id.picture);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question = (TextView)findViewById(R.id.Question);
        trueButton = (Button) findViewById(R.id.TrueButton);
        falseButton = (Button) findViewById(R.id.FalseButton);
        nextButton = (Button) findViewById(R.id.NextButton);
        score = 0;
        currentQindex = 0;
        q1 = new Question(getString(R.string.q1), false);
        q2 = new Question(getString(R.string.q2) , true);
        q3 = new Question(getString(R.string.q3), false);
        q4 = new Question(getString(R.string.q4), true);
        q5 = new Question(getString(R.string.q5), false);
        questions = new Question[]{q1,q2,q3,q4,q5};
        currentQ = questions[0];
        imageIC.setImageResource(images[currentQindex]);

        trueButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                String text;
                if (currentQ.isCorrectAnswer() == true){
                    text = getString(R.string.right_message);
                    score +=1;
                }
                else {
                    text = getString(R.string.wrong_message);
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
                    text = getString(R.string.right_message);
                }
                else {
                    text = getString(R.string.wrong_message);
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

                if (currentQindex < 4)
                {
                    currentQindex +=1;
                    currentQ = questions[currentQindex];
                    question.setText(currentQ.getQuestionText());

                    imageIC.setImageResource(images[currentQindex]);

                }

                else{

                    Intent intent = new Intent(MainActivity.this, ScoreActivity.class);
                    intent.putExtra("scoreLBL", score);
                    startActivity(intent);

                }
            }
        });



    }


}