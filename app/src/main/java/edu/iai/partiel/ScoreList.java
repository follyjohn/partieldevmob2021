package edu.iai.partiel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import edu.iai.partiel.adapter.ScoreAdapter;
import edu.iai.partiel.models.Score;
import edu.iai.partiel.repository.ScoreRepository;

public class ScoreList extends AppCompatActivity {
    DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_score_list);
        Log.i("INFO", "toto");
        dbHelper = new DbHelper(this);
        ScoreRepository scoreRepository = new ScoreRepository();

        ListView listView = findViewById(R.id.score_list);
        List<Score> scores = new ArrayList<>();

        scores.addAll(scoreRepository.findAll(dbHelper.getDatabase()));
        ScoreAdapter scoreAdapter = new ScoreAdapter(scores,this);
        listView.setAdapter(scoreAdapter);
        scoreAdapter.notifyDataSetChanged();
    }
}