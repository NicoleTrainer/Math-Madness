package com.TechInfinityStudios.mathmadness;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class QuestionsActivity extends AppCompatActivity {

    TextView questionText, scoreText;
    EditText answerText;
    Button submitButton;
    MathLogic mathLogic;
    String question;
    int answer;
    String type;
    Random random = new Random();
    int score = 0;
    SharedPreferences sharedPreferences;
    ArrayAdapter <String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        Intent intent = getIntent();
        type = intent.getStringExtra("type");

        mathLogic = new MathLogic();
        questionText = findViewById(R.id.textView);
        answerText = findViewById(R.id.editText);
        submitButton = findViewById(R.id.button);
        scoreText = findViewById(R.id.score);

        newQuestion();

        submitButton.setOnClickListener(view -> {
            if(!answerText.getText().toString().isEmpty()) {

                int userAnswer = Integer.parseInt(String.valueOf(answerText.getText()));
                if (userAnswer == answer) {
                    score++;
                    answerText.setText("");
                    scoreText.setText("Score: " + score);
                    newQuestion();
                }
                else {
                    Intent newIntent = new Intent(this, EndActivity.class);
                    newIntent.putExtra("score", String.valueOf(score));
                    newIntent.putExtra("type", type);
                    updateHighScore(score);
                    startActivity(newIntent);
                }

            }
            else {
                answerText.setError("Please Enter a Answer!");
            }



       });
    }

    private void updateHighScore(int score) {
        sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE);
        String highScores = sharedPreferences.getString(type, "");
        if (highScores.isEmpty()) {
            highScores = score + ",";;
        }
        else {
            highScores += score + ",";
            String[] scoreArray = highScores.split(",");

            for (int i = 0; i < scoreArray.length - 1; i++) {
                for (int j = 0; j < scoreArray.length - 1 - i; j++) {
                    if (Integer.parseInt(scoreArray[j]) < Integer.parseInt(scoreArray[j + 1])) {
                        int temp = Integer.parseInt(scoreArray[j]);
                        scoreArray[j] = scoreArray[j + 1];
                        scoreArray[j + 1] = String.valueOf(temp);
                    }
                }
            }
            highScores = "";
            int place = 1;
            for (String s : scoreArray) {
                highScores += place + ": " + s + ",";
                place++;
            }
        }

        sharedPreferences.edit().putString(type, highScores).apply();
    }

    private void newQuestion() {

        switch (type) {

            case "add":
                addition();
                break;
            case "sub":
                subtraction();
                break;
            case "mul":
                multiplication();
                break;

            case "rand":
                rand();
                break;
        }
    }

    private void rand() {
        int rand = random.nextInt(3);
        switch (rand) {
            case 0:
                addition();
                break;
            case 1:
                subtraction();
                break;
            case 2:
                multiplication();
                break;

        }
    }


    private void multiplication() {
        question = mathLogic.getMultiplicationQuestion();
        questionText.setText(question);
        answer = mathLogic.getAnswer();

    }


    private void subtraction() {
        question = mathLogic.getSubtractionQuestion();
        questionText.setText(question);
        answer = mathLogic.getAnswer();

    }

    private void addition() {
        question = mathLogic.getAdditionQuestion();
        questionText.setText(question);
        answer = mathLogic.getAnswer();

    }
}
