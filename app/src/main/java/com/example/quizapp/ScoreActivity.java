package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    TextView scoreTV;
    Intent incomingIntent;
    int score;
    Button emailBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        scoreTV = (TextView) findViewById(R.id.scoreTV);
        incomingIntent = getIntent();
        score = incomingIntent.getIntExtra("scoreLBL", 0);

        scoreTV.setText("score" + score);

        emailBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] addresses = new String[] {"eugene.chase@gmail.com"};
                String subject = "New score on the quiz app";
                composeEmail(addresses, subject);
            }
        });

    }

    private void composeEmail(String[] addresses, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto;"));
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_EMAIL, subject);
        if (intent.resolveActivity(getPackageManager())!= null) {
            startActivity(intent);
        }


    }


}