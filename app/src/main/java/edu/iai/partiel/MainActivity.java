package edu.iai.partiel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_accueil, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_enregistrer:
                Intent to_enregistrer;
                to_enregistrer = new Intent(this, Enregistrer.class);
                startActivity(to_enregistrer);
                return true;
            case R.id.menu_jouer:
                Intent to_jouer;
                to_jouer = new Intent(this, Jouer.class);
                startActivity(to_jouer);
                return true;
            case R.id.menu_score:
                Intent to_score;
                to_score = new Intent(this, ScoreList.class);
                startActivity(to_score);
                return true;
            default:
                return false;
        }
    }
}