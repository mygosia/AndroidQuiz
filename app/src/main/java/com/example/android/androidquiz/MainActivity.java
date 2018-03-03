package com.example.android.androidquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    public void checkAnswer(View view) {


        //Checking user name
        EditText name = findViewById(R.id.userName);
        String userName = name.getText().toString();


        //Checking 1 answer
        EditText latinName = findViewById(R.id.latinName);
        String latinNameStr = latinName.getText().toString();


        /// Checking 2n answer
        RadioButton answerSecond = findViewById(R.id.ans2);
        boolean anw2nd = answerSecond.isChecked();

        //Checking 3rd answer
        CheckBox capybaraCheckBox = findViewById(R.id.capybara);
        boolean cabybaraIsChecked = capybaraCheckBox.isChecked();

        CheckBox maraCheckBox = findViewById(R.id.mara);
        boolean maraIsChecked = maraCheckBox.isChecked();

        CheckBox hareCheckBox = findViewById(R.id.hare);
        boolean hareIsChecked = hareCheckBox.isChecked();

        CheckBox rabbitCheckBox = findViewById(R.id.rabbit);
        boolean rabbitIsChecked = rabbitCheckBox.isChecked();

        ///Checking 4th answer
        RadioButton answerFourth = findViewById(R.id.teeth);
        boolean ans4rd = answerFourth.isChecked();

        //Checking 5th answer
        RadioButton answerFith = findViewById(R.id.horse);
        boolean ans5th = answerFith .isChecked();


        int allScore = allPoints( latinNameStr,  anw2nd, hareIsChecked, rabbitIsChecked, cabybaraIsChecked,  maraIsChecked,  ans4rd,  ans5th);

        //Displaying toast
        String percentScore = Integer.toString(allScore * 100 / 5);
        Toast.makeText(getApplicationContext(), percentScore + "%", Toast.LENGTH_SHORT).show();

        //Displaying score
        displayScore(userName,allScore);
    }

    //Adding points
    public int allPoints (String latinNameStr, boolean anw2nd, boolean hareIsChecked, boolean rabbitIsChecked,  boolean cabybaraIsChecked, boolean maraIsChecked, boolean ans4rd, boolean ans5th ) {
        int score = 0;
        if (latinNameStr.equals("Cavia porcellus")) {
            score++;
        }
        if (anw2nd) {
            score++;
        }
        if (hareIsChecked) {
           score = score;
        } else if (rabbitIsChecked) {
           score = score;
        }
            else  if (cabybaraIsChecked & maraIsChecked) {
            score++;
        }
        if (ans4rd) {
            score++;
        }
        if (ans5th) {
            score++;
        }
        return score;

    }


// //Displaing score
    public void displayScore (String userName, int allScore) {
        TextView scoreTextView = findViewById(R.id.scoreTextView);
        String stringAnsw = getResources().getString(R.string.stringAnsw);
        String stringAnsw2 = getResources().getString(R.string.stringAnsw2);

        scoreTextView.setText(userName + stringAnsw + allScore + stringAnsw2);

        TextView percentageScore = findViewById(R.id.percentage);
        percentageScore.setText(allScore * 100 / 5 + "%");
    }


}

