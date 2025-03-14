package com.TechInfinityStudios.mathmadness;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class SelectionActivity extends AppCompatActivity {
    String type = " ";
    ImageButton highScoreButton;
    Button addButton, subButton, multiplyButton, randButton;
    ArrayAdapter<String> adapter;
    SharedPreferences sharedPreferences;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE);

         highScoreButton = findViewById(R.id.highScoreButton);
         addButton = findViewById(R.id.add);
         subButton = findViewById(R.id.sub);
         multiplyButton = findViewById(R.id.multiply);
         randButton = findViewById(R.id.rand);

        Intent intent = new Intent(this, QuestionsActivity.class);

        highScoreButton.setOnClickListener(view -> {
                    showHighScoreDialog();
        });


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


        randButton.setOnClickListener(view -> {
            type = "rand";
            intent.putExtra("type", type);
            startActivity(intent);
        });
    }

    private void showHighScoreDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.high_score_dialog);

        if (dialog.getWindow() != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setGravity(Gravity.TOP);
        }

        dialog.show();

        Button addScoreButton = dialog.findViewById(R.id.addScoreButton);
        Button subtractScoreButton = dialog.findViewById(R.id.subtractScoreButton);
        Button multiplyScoreButton = dialog.findViewById(R.id.multiplyScoreButton);
        Button randomScoreButton = dialog.findViewById(R.id.randomScoreButton);
        listView = dialog.findViewById(R.id.listView);
        ImageButton closeButton = dialog.findViewById(R.id.closeButton);

        type = "add";
        showHighScore(type);

        closeButton.setOnClickListener(view1 -> {
            dialog.dismiss();
        });
        addScoreButton.setOnClickListener(view1 -> {
            type = "add";
            showHighScore(type);
        });
        subtractScoreButton.setOnClickListener(view1 -> {
            type = "sub";
            showHighScore(type);
        });
        multiplyScoreButton.setOnClickListener(view1 -> {
            type = "mul";
        });
        randomScoreButton.setOnClickListener(view1 -> {
            type = "rand";
            showHighScore(type);
        });
}

    private void showHighScore(String type) {
        String highScores = sharedPreferences.getString(type, "");
        String[] scores = highScores.split(",");
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, scores);
        listView.setAdapter(adapter);

    }


}