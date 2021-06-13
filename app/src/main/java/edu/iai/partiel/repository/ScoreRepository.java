package edu.iai.partiel.repository;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import edu.iai.partiel.models.Score;


public class ScoreRepository {
    public boolean save(SQLiteDatabase database, Score score) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("score", score.getScore());
        contentValues.put("date", score.getDate());
        long nbLignes = database.insert("score", null, contentValues);
        Log.e("info", nbLignes+"");
        return (nbLignes > 0);
    }

    public List<Score> findAll(SQLiteDatabase database) {
        Cursor cursor = database.rawQuery("SELECT * FROM score", null);
        List<Score> maListe = new ArrayList<>();
        Score score;
        while (cursor.moveToNext()) {
            score = new Score();
            score.setScore(cursor.getString(1));
            score.setDate(cursor.getString(2));
            maListe.add(score);
        }
        return maListe;
    }


    public void save(SQLiteDatabase database) {
    }
}