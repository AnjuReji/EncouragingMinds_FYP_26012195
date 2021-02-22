package com.example.encouragingminds;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends QuizBaseActivity {

    TextView txtHighScore;
    TextView txtTotalQuizQues,txtCorrectQues,txtWrongQues;

    Button btStartQuiz;
    Button btMainMenu;

    private int highScore;
    public static final String SHARED_PREFERENCE = "shared_preference";
    public static final String SHARED_PREFERENCE_HIGH_SCORE = "shared_preference_high_score";

    private long backPressedTime;

    String currentCategoryValue ="";
    int levelsId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        btMainMenu = findViewById(R.id.result_bt_mainmenu);
        btStartQuiz = findViewById(R.id.result_bt_playAgain);
        txtHighScore = findViewById(R.id.result_text_High_Score);
        txtTotalQuizQues = findViewById(R.id.result_total_Ques);
        txtCorrectQues = findViewById(R.id.result_Correct_Ques);
        txtWrongQues = findViewById(R.id.result_Wrong_Ques);


        btMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ResultActivity.this,CategoryActivity.class);
                startActivity(intent);

            }
        });

        btStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(ResultActivity.this,QuizActivity.class);
                intent.putExtra("Category", currentCategoryValue);
                intent.putExtra("Level", levelsId);
                startActivity(intent);
            }
        });


        loadHighScore();

        Intent intent = getIntent();

        int score = intent.getIntExtra("UserScore",0);
        int totalQuestion = intent.getIntExtra("TotalQuestion",0);
        int correctQues = intent.getIntExtra("CorrectQues",0);
        int wrongQues = intent.getIntExtra("WrongQues",0);

        currentCategoryValue = intent.getStringExtra("Category");
        levelsId = intent.getIntExtra("Level", 0);

        txtTotalQuizQues.setText("Total Questions: " + String.valueOf(totalQuestion));
        txtCorrectQues.setText("Correct: " + String.valueOf(correctQues));
        txtWrongQues.setText("Wrong: " + String.valueOf(wrongQues));

        if (score > highScore){

            updateHighScore(score);
        }


    }

    private void updateHighScore(int newHighScore) {

        highScore = newHighScore;
        txtHighScore.setText("High Score: " + String.valueOf(highScore));

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCE,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(SHARED_PREFERENCE_HIGH_SCORE,highScore);
        editor.apply();


    }

    private void loadHighScore() {

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCE,MODE_PRIVATE);
        highScore = sharedPreferences.getInt(SHARED_PREFERENCE_HIGH_SCORE,0);
        txtHighScore.setText("High Score: " + String.valueOf(highScore));

    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()){

            Intent intent = new Intent(ResultActivity.this,PlayActivity.class);
            startActivity(intent);

        }else {
            Toast.makeText(this, "Press Again to Exit", Toast.LENGTH_SHORT).show();

        }
        backPressedTime = System.currentTimeMillis();
    }

    public void sendToLevelAgain(View view) {

        if (currentCategoryValue.equals("Beginner")) {

            Intent intentBeginner = new Intent(ResultActivity.this, BeginnerLevelsActivity.class);
            intentBeginner.putExtra("Category", CategoryConstants.BEGINNER);
            startActivity(intentBeginner);

        } else if (currentCategoryValue.equals("Intermediate")) {

            Intent intentIntermediate = new Intent(ResultActivity.this, IntermediateLevelsActivity.class);
            intentIntermediate.putExtra("Category", CategoryConstants.INTERMEDIATE);
            startActivity(intentIntermediate);

        } else if (currentCategoryValue.equals("Difficult")) {

            Intent intentDifficult = new Intent(ResultActivity.this, DifficultLevelsActivity.class);
            intentDifficult.putExtra("Category", CategoryConstants.DIFFICULT);
            startActivity(intentDifficult);

        }
    }
}