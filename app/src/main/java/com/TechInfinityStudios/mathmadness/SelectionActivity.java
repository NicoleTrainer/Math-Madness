package com.TechInfinityStudios.mathmadness;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SelectionActivity extends AppCompatActivity {
    String type = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        Button addButton = findViewById(R.id.add);
        Button subButton = findViewById(R.id.sub);
        Button multiplyButton = findViewById(R.id.multiply);
        Button divideButton = findViewById(R.id.divide);
        Button randButton = findViewById(R.id.rand);

        Intent intent = new Intent(this, QuestionsActivity.class);
        addButton.setOnClickListener(view -> {
            type = "add";
            intent.putExtra("type", type);
            startActivity(intent);
        });

        subButton.setOnClickListener(view -> {
            type = "sub";
            intent.putExtra("type", type);
            startActivity(intent);
        });

        multiplyButton.setOnClickListener(view -> {
            type = "mul";
            intent.putExtra("type", type);
            startActivity(intent);
        });

        divideButton.setOnClickListener(view -> {
            type = "div";
            intent.putExtra("type", type);
            startActivity(intent);
        });
        randButton.setOnClickListener(view -> {
            type = "rand";
            intent.putExtra("type", type);
            startActivity(intent);
        });
    }
}