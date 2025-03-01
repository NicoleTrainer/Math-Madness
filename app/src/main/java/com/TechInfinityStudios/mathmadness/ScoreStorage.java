package com.TechInfinityStudios.mathmadness;

import android.content.Context;
import android.content.SharedPreferences;

public class ScoreStorage {

    private String sharedPrefFile = "com.TechInifinityStudios.android.scoresharedprefs";
    SharedPreferences prefs;

    public ScoreStorage(Context context) {
        prefs = context.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE);
    }

    public void addScore(int score) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("score", score);
        editor.commit();
    }


}
