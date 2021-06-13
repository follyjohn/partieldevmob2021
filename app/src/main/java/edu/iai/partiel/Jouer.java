package edu.iai.partiel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import edu.iai.partiel.models.Score;
import edu.iai.partiel.repository.ScoreRepository;

public class Jouer extends AppCompatActivity implements View.OnClickListener {
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    DbHelper dbHelper;
    int score;
    String ancienneValeur;
    TextView scoreView;

    int counter;

    ArrayList choice = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jouer);

        counter=0;
        dbHelper = new DbHelper(this);
        scoreView=findViewById(R.id.tviewscore);

        btn1=findViewById(R.id.button_1);
        btn2=findViewById(R.id.button_2);
        btn3=findViewById(R.id.button_3);
        btn4=findViewById(R.id.button_4);
        btn5=findViewById(R.id.button_5);
        btn6=findViewById(R.id.button_6);
        btn7=findViewById(R.id.button_7);
        btn8=findViewById(R.id.button_8);
        btn9=findViewById(R.id.button_9);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

        listeInitializer(choice);
    }

    private void listeInitializer(List<String> choice) {
        choice.addAll(Arrays.asList("X","Y","Z"));
    }

    @Override
    public void onClick(View v) {
        Button btn = (Button) v;
        setButtonText(btn, choice);
        counter++;
        if(counter == 9){
            Score scoreObj = new Score();
            scoreObj.setDate();
            scoreObj.setScore(String.valueOf(score));
            ScoreRepository scoreRepository = new ScoreRepository();
            scoreRepository.save(dbHelper.getDatabase(), scoreObj);
            scoreRepository.save(dbHelper.getDatabase());
            Toast.makeText(this,"Votre score est "+score,Toast.LENGTH_LONG).show();
            finish();
        }

    }

    public String getVal(ArrayList arrayList){
        Random random = new Random();
        int position = random.nextInt(arrayList.size());
        String  val = (String)arrayList.get(position);
        return val;
    }

    public void setButtonText(Button button, ArrayList arrayList){
        button.setText(getVal(arrayList));
        button.setEnabled(false);
        if(ancienneValeur == button.getText().toString())
            score+=1;
        ancienneValeur= button.getText().toString();
        scoreView.setText(String.valueOf(score));
    }

}