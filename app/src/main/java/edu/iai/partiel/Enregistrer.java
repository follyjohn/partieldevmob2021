package edu.iai.partiel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.backup.SharedPreferencesBackupHelper;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class Enregistrer extends AppCompatActivity {
    EditText editNomJoueur;
    EditText editPseudoJoueur;

    String NOM = "nom_joueur";
    String PSEUDO = "pseudo_joueur";

    Button btnEnregistrer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enregistrer);

        editNomJoueur = findViewById(R.id.edit_nom_joueur);
        editPseudoJoueur = findViewById(R.id.edit_pseudo_joueur);

        btnEnregistrer = findViewById(R.id.btn_enregistrer_joueur);

        btnEnregistrer.setOnClickListener(v -> enregistrerJoueur(v));

        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        if(! (sharedPreferences.getString(NOM,"").equals("")&&sharedPreferences.getString(PSEUDO,"").equals(""))){
            editPseudoJoueur.setText(String.valueOf(sharedPreferences.getString(PSEUDO,"")));
            editNomJoueur.setText(String.valueOf(sharedPreferences.getString(NOM,"")));
            editNomJoueur.setEnabled(false);
            editPseudoJoueur.setEnabled(false);
            btnEnregistrer.setEnabled(false);
        }

    }

    private void enregistrerJoueur(View v) {
        String nom = String.valueOf(editNomJoueur.getText());
        String pseudo = String.valueOf(editPseudoJoueur.getText());

        if(nom.equals("") || pseudo.equals("")){
            Snackbar.make(v, "Veuillez remplir les champs !", Snackbar.LENGTH_LONG);
        }else{
            SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(NOM, nom);
            editor.putString(PSEUDO, pseudo);
            editor.apply();
            editNomJoueur.setEnabled(false);
            editPseudoJoueur.setEnabled(false);
            btnEnregistrer.setEnabled(false);

        }
    }
}