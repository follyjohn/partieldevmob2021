package edu.iai.partiel.models;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Score {
    private int id;
    private String score;
    private String date;

    public Score(int id, String score, String date) {
        this.id = id;
        this.score = score;
        this.date = date;
    }

    public Score() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDate() {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date current_date = new Date();
        this.date = formatter.format(current_date);
    }
}
