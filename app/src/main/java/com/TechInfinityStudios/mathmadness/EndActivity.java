package com.TechInfinityStudios.mathmadness;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EndActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        Intent intent = getIntent();
        String score = intent.getStringExtra("score");
        String type = intent.getStringExtra("type");

        TextView textView = findViewById(R.id.scoreText);
        Button mainButton = findViewById(R.id.mainMenuButton);
        Button replayButton = findViewById(R.id.retryButton);
        textView.setText("Score :" + score);

        mainButton.setOnClickListener(v -> {
            Intent newIntent = new Intent(EndActivity.this, MainActivity.class);
            startActivity(newIntent);
        });
        replayButton.setOnClickListener(v -> {
            Intent newIntent = new Intent(EndActivity.this, QuestionsActivity.class);
            newIntent.putExtra("type", type);
            startActivity(newIntent);
        });
    }
}
