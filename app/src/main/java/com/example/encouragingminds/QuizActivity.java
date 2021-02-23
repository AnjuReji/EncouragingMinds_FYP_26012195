package com.example.encouragingminds;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class QuizActivity extends AppCompatActivity {


    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private Button buttonConfirmNext;



    private TextView textViewQuestion;
    private TextView textViewScore;
    private TextView textViewQuestionCount;
    private TextView textViewCountDown;
    private ImageView questionImage;


    private ArrayList<Questions> questionList;
    private int questionCounter;
    private int questionTotalCount;
    private Questions currentQuestions;
    private boolean answered;


    private final Handler handler = new Handler();


    private int correctAns = 0, wrongAns = 0;

    private TimerDialog timerDialog;
    private CorrectDialog correctDialog;
    private WrongDialog wrongDialog;

    private PlayAudioForAnswers playAudioForAnswers;

    int FLAG = 0;

    int score =0;

    private int totalSizeofQuiz=0;

    private static final long COUNTDOWN_IN_MILLIS = 30000;
    private CountDownTimer countDownTimer;
    private long timeleftinMillis;

    private long backPressedTime;

    private String categoryValue="";
    private int levelsID = 0;

    int UNLOCK_BL2 = 0, UNLOCK_BL3 = 0;
    int UNLOCK_IL2 = 0, UNLOCK_IL3 = 0;
    int UNLOCK_DL2 = 0, UNLOCK_DL3 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_quiz);

        setupUI();

        Intent intentCategorywithLevel = getIntent();
        categoryValue = intentCategorywithLevel.getStringExtra("Category");
        levelsID = intentCategorywithLevel.getIntExtra("Level", 0);



        fetchDB();
        Log.i("BUGBUG","onCreate() in QuizActivity");


        timerDialog = new TimerDialog(this);
        correctDialog = new CorrectDialog(this);
        wrongDialog = new WrongDialog(this);
        playAudioForAnswers = new PlayAudioForAnswers(this);
    }



    private void setupUI(){
        textViewQuestion = findViewById(R.id.txtQuestionContainer);
        questionImage = findViewById(R.id.iv_image);

        textViewScore = findViewById(R.id.txtScore);
        textViewQuestionCount = findViewById(R.id.txtTotalQuestion);
        textViewCountDown = findViewById(R.id.txtViewTimer);



        rbGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radio_button1);
        rb2 = findViewById(R.id.radio_button2);
        rb3 = findViewById(R.id.radio_button3);
        rb4 = findViewById(R.id.radio_button4);
        buttonConfirmNext = findViewById(R.id.button);
    }

    public void fetchDB() {

        QuizDbHelper dbHelper = new QuizDbHelper(this);
        questionList = dbHelper.getAllQuestionsWithCategoryAndLevels(levelsID, categoryValue); // calling the method with category
        startQuiz();

    }


    public void startQuiz() {

        questionTotalCount = questionList.size();
        Collections.shuffle(questionList);

        showQuestions();   // calling showQuestion() method



        rbGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {



                switch (checkedId){

                    case R.id.radio_button1:

                        rb1.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.white));
                        rb2.setTextColor(Color.BLACK);
                        rb3.setTextColor(Color.BLACK);
                        rb4.setTextColor(Color.BLACK);



                        rb1.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.when_option_selected));
                        rb2.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.buttons_background));
                        rb3.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.buttons_background));
                        rb4.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.buttons_background));

                        break;
                    case R.id.radio_button2:
                        rb2.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.white));

                        rb1.setTextColor(Color.BLACK);
                        rb3.setTextColor(Color.BLACK);
                        rb4.setTextColor(Color.BLACK);



                        rb2.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.when_option_selected));
                        rb1.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.buttons_background));
                        rb3.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.buttons_background));
                        rb4.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.buttons_background));

                        break;

                    case R.id.radio_button3:
                        rb3.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.white));
                        rb2.setTextColor(Color.BLACK);
                        rb1.setTextColor(Color.BLACK);
                        rb4.setTextColor(Color.BLACK);


                        rb3.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.when_option_selected));
                        rb2.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.buttons_background));
                        rb4.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.buttons_background));
                        rb1.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.buttons_background));

                        break;

                    case R.id.radio_button4:
                        rb4.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.white));
                        rb2.setTextColor(Color.BLACK);
                        rb3.setTextColor(Color.BLACK);
                        rb1.setTextColor(Color.BLACK);



                        rb4.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.when_option_selected));
                        rb2.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.buttons_background));
                        rb3.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.buttons_background));
                        rb1.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.buttons_background));

                        break;
                }

            }
        });

        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!answered) {
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()) {

                        quizOperation();
                    } else {

                        Toast.makeText(QuizActivity.this, "Please Select the Answer ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }


    public void showQuestions() {


        rbGroup.clearCheck();

        rb1.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.buttons_background));
        rb2.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.buttons_background));
        rb3.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.buttons_background));
        rb4.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.buttons_background));

        rb1.setTextColor(Color.BLACK);
        rb2.setTextColor(Color.BLACK);
        rb3.setTextColor(Color.BLACK);
        rb4.setTextColor(Color.BLACK);


        if (questionCounter < questionTotalCount) {
            currentQuestions = questionList.get(questionCounter);
            textViewQuestion.setText(currentQuestions.getQuestion());
            questionImage.setImageResource(currentQuestions.getImage());
            rb1.setText(currentQuestions.getOption1());
            rb2.setText(currentQuestions.getOption2());
            rb3.setText(currentQuestions.getOption3());
            rb4.setText(currentQuestions.getOption4());

            questionCounter++;
            answered = false;
            buttonConfirmNext.setText("Confirm");

            textViewQuestionCount.setText("Questions: " + questionCounter + "/" + questionTotalCount);


            timeleftinMillis = COUNTDOWN_IN_MILLIS;
            startCountDown();


        } else {

            // If Number of Questions Finishes then we need to finish the Quiz and Shows the User Quiz Performance


            Toast.makeText(this, "Quiz Finished", Toast.LENGTH_SHORT).show();

            rb1.setClickable(false);
            rb2.setClickable(false);
            rb3.setClickable(false);
            rb4.setClickable(false);
            buttonConfirmNext.setClickable(false);

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    finalResult();

                }
            }, 2000);
        }
    }

    private void quizOperation() {
        answered = true;

        countDownTimer.cancel();

        RadioButton rbselected = findViewById(rbGroup.getCheckedRadioButtonId());
        int answerNr = rbGroup.indexOfChild(rbselected) + 1;

        checkSolution(answerNr, rbselected);

    }


    private void checkSolution(int answerNr, RadioButton rbselected) {

        switch (currentQuestions.getAnswerNr()) {
            case 1:
                if (currentQuestions.getAnswerNr() == answerNr) {

                    rb1.setBackground(ContextCompat.getDrawable(
                            this, R.drawable.when_answer_correct));
                    rb1.setTextColor(Color.BLACK);

                    correctAns++;


                    score += 10;
                    textViewScore.setText("Score: " + String.valueOf(score));
                    correctDialog.correctDialog(score,this);


                    FLAG = 1;
                    playAudioForAnswers.setAudioforAnswer(FLAG);






                } else {
                    changetoIncorrectColor(rbselected);

                    wrongAns++;


                    String correctAnswer = (String) rb1.getText();
                    wrongDialog.wrongDialog(correctAnswer,this);

                    FLAG = 2;
                    playAudioForAnswers.setAudioforAnswer(FLAG);



                }
                break;
            case 2:
                if (currentQuestions.getAnswerNr() == answerNr) {

                    rb2.setBackground(ContextCompat.getDrawable(this, R.drawable.when_answer_correct));
                    rb2.setTextColor(Color.BLACK);

                    correctAns++;


                    score += 10;
                    textViewScore.setText("Score: " + String.valueOf(score));
                    correctDialog.correctDialog(score,this);

                    FLAG = 1;
                    playAudioForAnswers.setAudioforAnswer(FLAG);



                } else {
                    changetoIncorrectColor(rbselected);
                    wrongAns++;


                    String correctAnswer = (String) rb2.getText();
                    wrongDialog.wrongDialog(correctAnswer,this);

                    FLAG = 2;
                    playAudioForAnswers.setAudioforAnswer(FLAG);




                }
                break;
            case 3:
                if (currentQuestions.getAnswerNr() == answerNr) {

                    rb3.setBackground(ContextCompat.getDrawable(this, R.drawable.when_answer_correct));
                    rb3.setTextColor(Color.BLACK);


                    correctAns++;


                    score += 10;
                    textViewScore.setText("Score: " + String.valueOf(score));
                    correctDialog.correctDialog(score,this);

                    FLAG = 1;
                    playAudioForAnswers.setAudioforAnswer(FLAG);



                } else {
                    changetoIncorrectColor(rbselected);
                    wrongAns++;


                    String correctAnswer = (String) rb3.getText();
                    wrongDialog.wrongDialog(correctAnswer,this);

                    FLAG = 2;
                    playAudioForAnswers.setAudioforAnswer(FLAG);




                }
                break;
            case 4:
                if (currentQuestions.getAnswerNr() == answerNr) {

                    rb4.setBackground(ContextCompat.getDrawable(this, R.drawable.when_answer_correct));
                    rb4.setTextColor(Color.BLACK);


                    correctAns++;


                    score += 10;
                    textViewScore.setText("Score: " + String.valueOf(score));
                    correctDialog.correctDialog(score,this);

                    FLAG = 1;
                    playAudioForAnswers.setAudioforAnswer(FLAG);




                } else {
                    changetoIncorrectColor(rbselected);
                    wrongAns++;


                    String correctAnswer = (String) rb4.getText();
                    wrongDialog.wrongDialog(correctAnswer,this);

                    FLAG = 2;
                    playAudioForAnswers.setAudioforAnswer(FLAG);




                }
                break;
        }
        if (questionCounter == questionTotalCount) {
            buttonConfirmNext.setText("Confirm and Finish");
        }
    }

    void changetoIncorrectColor(RadioButton rbselected) {
        rbselected.setBackground(ContextCompat.getDrawable(this, R.drawable.when_answer_wrong));

        rbselected.setTextColor(Color.BLACK);
    }



    //  the timer code

    private void startCountDown(){

        countDownTimer = new CountDownTimer(timeleftinMillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeleftinMillis = millisUntilFinished;

                updateCountDownText();
            }

            @Override
            public void onFinish() {

                timeleftinMillis = 0;
                updateCountDownText();

            }
        }.start();

    }



    private void updateCountDownText(){

        int minutes = (int) (timeleftinMillis/1000) /60;
        int seconds = (int) (timeleftinMillis/1000) % 60;

        //  String timeFormatted = String.format(Locale.getDefault(),"02d:%02d",minutes,seconds);

        String timeFormatted = String.format(Locale.getDefault(),"%02d:%02d",minutes, seconds);
        textViewCountDown.setText(timeFormatted);


        if (timeleftinMillis < 10000){


            textViewCountDown.setTextColor(ContextCompat.getColor(this,R.color.red));

            FLAG = 3;
            playAudioForAnswers.setAudioforAnswer(FLAG);


        }else {
            textViewCountDown.setTextColor(ContextCompat.getColor(this,R.color.black));
        }


        if (timeleftinMillis == 0 ){


            Toast.makeText(this, "Times Up!", Toast.LENGTH_SHORT).show();


            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    timerDialog.timerDialog();

                }
            },2000);



        }
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("BUGBUG","onRestart() in QuizActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("BUGBUG","onStop() in QuizActivity");
        finish();

    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i("BUGBUG","onPause() in QuizActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("BUGBUG","onResume() in QuizActivity");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("BUGBUG","onStart() in QuizActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (countDownTimer!=null){
            countDownTimer.cancel();
        }
        Log.i("BUGBUG","onDestroy() in QuizActivity");


    }


    private void finalResult(){

        unlockTheLevels();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent resultData = new Intent(QuizActivity.this,ResultActivity.class);

                resultData.putExtra("UserScore",score);
                resultData.putExtra("TotalQuestion",questionTotalCount);
                resultData.putExtra("CorrectQues",correctAns);
                resultData.putExtra("WrongQues",wrongAns);

                resultData.putExtra("Category", categoryValue);
                resultData.putExtra("Level",levelsID);

                startActivity(resultData);
            }
        },1000);




    }



    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()){

            Intent intent = new Intent(QuizActivity.this,PlayActivity.class);
            startActivity(intent);

        }else {
            Toast.makeText(this, "Press Again to Exit", Toast.LENGTH_SHORT).show();

        }
        backPressedTime = System.currentTimeMillis();
    }

    private void unlockTheLevels() {

        unLockBeginnerLevels();
        unLockIntermediateLevels();
        unLockDifficultLevels();

    }

    private void unLockBeginnerLevels() {

        SharedPreferences sharedPreferences =
                getSharedPreferences(getPackageName() + Constant.MY_LEVEL_PREFERENCE, Context.MODE_PRIVATE);

        if (levelsID == 1 && categoryValue.equals("Beginner")){

            // The active level is 1 and we need to unlock the level 2

            UNLOCK_BL2 = correctAns;

            if (UNLOCK_BL2 >= 4){

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constant.KEY_BEGINNER_LEVEL_2, 1);
                editor.apply();

                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor.putString(Constant.KEY_BEGINNER_LEVEL_2, "Unlock");
                editor1.apply();

            }


        }else if (levelsID == 2 && categoryValue.equals("Beginner")){

            // The active level is 2 and we need to unlock the level 3

            UNLOCK_BL3 = correctAns;

            if (sharedPreferences.getInt(Constant.KEY_BEGINNER_LEVEL_2,0) == 1){

                if (UNLOCK_BL3 >= 4) {

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt(Constant.KEY_BEGINNER_LEVEL_3, 1);
                    editor.apply();

                    SharedPreferences.Editor editor1 = sharedPreferences.edit();
                    editor.putString(Constant.KEY_BEGINNER_LEVEL_3, "Unlock");
                    editor1.apply();

                }

            }


        }



    }

    private void unLockIntermediateLevels() {

        SharedPreferences sharedPreferences =
                getSharedPreferences(getPackageName() + Constant.MY_LEVEL_PREFERENCE, Context.MODE_PRIVATE);

        if (levelsID == 1 && categoryValue.equals("Intermediate")){

            // The active level is 1 and we need to unlock the level 2

            UNLOCK_IL2 = correctAns;

            if (UNLOCK_IL2 >= 6){

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constant.KEY_INTERMEDIATE_LEVEL_2, 1);
                editor.apply();

                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor.putString(Constant.KEY_INTERMEDIATE_LEVEL_2, "Unlock");
                editor1.apply();

            }


        }else if (levelsID == 2 && categoryValue.equals("Intermediate")){

            // The active level is 2 and we need to unlock the level 3

            UNLOCK_IL3 = correctAns;

            if (sharedPreferences.getInt(Constant.KEY_DIFFICULT_LEVEL_2,0) == 1){

                if (UNLOCK_IL3 >= 6) {

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt(Constant.KEY_INTERMEDIATE_LEVEL_3, 1);
                    editor.apply();

                    SharedPreferences.Editor editor1 = sharedPreferences.edit();
                    editor.putString(Constant.KEY_INTERMEDIATE_LEVEL_3, "Unlock");
                    editor1.apply();

                }

            }



        }



    }


    private void unLockDifficultLevels() {

        SharedPreferences sharedPreferences =
                getSharedPreferences(getPackageName() + Constant.MY_LEVEL_PREFERENCE, Context.MODE_PRIVATE);

        if (levelsID == 1 && categoryValue.equals("Difficult")){

            // The active level is 1 and we need to unlock the level 2

            UNLOCK_DL2 = correctAns;

            if (UNLOCK_DL2 >= 8){

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constant.KEY_DIFFICULT_LEVEL_2, 1);
                editor.apply();

                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor.putString(Constant.KEY_DIFFICULT_LEVEL_2, "Unlock");
                editor1.apply();

            }


        }else if (levelsID == 2 && categoryValue.equals("Difficult")){

            // The active level is 2 and we need to unlock the level 3

            UNLOCK_DL3 = correctAns;

            if (sharedPreferences.getInt(Constant.KEY_DIFFICULT_LEVEL_2,0) == 1){

                if (UNLOCK_DL3 >= 8) {

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt(Constant.KEY_DIFFICULT_LEVEL_3, 1);
                    editor.apply();

                    SharedPreferences.Editor editor1 = sharedPreferences.edit();
                    editor.putString(Constant.KEY_DIFFICULT_LEVEL_3, "Unlock");
                    editor1.apply();

                }

            }



        }



    }


}
