package com.example.encouragingminds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CategoryActivity extends QuizBaseActivity implements View.OnClickListener {

    Button btBeginner, btIntermediate, btDifficult, btEmotionDetection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);


        btBeginner = findViewById(R.id.button2);
        btIntermediate = findViewById(R.id.button3);
        btDifficult = findViewById(R.id.button5);
        btEmotionDetection = findViewById(R.id.button4);


        btBeginner.setOnClickListener(this);
        btIntermediate.setOnClickListener(this);
        btDifficult.setOnClickListener(this);
        btEmotionDetection.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()){

            case R.id.button2: // beginner

                createLevelsforBeginner();

                Intent intentBeginner = new Intent(CategoryActivity.this, BeginnerLevelsActivity.class);
                intentBeginner.putExtra("Category", CategoryConstants.BEGINNER);
                startActivity(intentBeginner);

                break;

            case R.id.button3: // intermediate

                createLevelsforIntermediate();

                Intent intentIntermediate = new Intent(CategoryActivity.this, IntermediateLevelsActivity.class);
                intentIntermediate.putExtra("Category", CategoryConstants.INTERMEDIATE);
                startActivity(intentIntermediate);

                break;

            case R.id.button5: // difficult

                createLevelsforDifficult();

                Intent intentDifficult = new Intent(CategoryActivity.this, DifficultLevelsActivity.class);
                intentDifficult.putExtra("Category", CategoryConstants.DIFFICULT);
                startActivity(intentDifficult);

                break;

            case R.id.button4: // emotion detection

                Intent intentEmotionDetection = new Intent(CategoryActivity.this, EmotionDetectionActivity.class);
                intentEmotionDetection.putExtra("Category", CategoryConstants.EMOTIONDETECTION);
                startActivity(intentEmotionDetection);

                break;
        }

    }

    ////    1 = UNLOCKED LEVEL      0 = LOCKED LEVEL
    private void createLevelsforBeginner() {

        SharedPreferences sharedPreferences =
                getSharedPreferences(getPackageName() + Constant.MY_LEVEL_PREFERENCE, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(Constant.KEY_CAT_BEGINNER_LEVEL_1, 1); //  BY DEFAULT IT IS SET TO LEVEL 1 UNLOCKED
        editor.putString(Constant.KEY_CAT_BEGINNER_LEVEL_1, "Unlock");
        editor.apply();

        if (sharedPreferences.getString(Constant.KEY_CAT_BEGINNER_LEVEL_1, "N/A").equals("Unlock")){

            editor.putInt(Constant.KEY_BEGINNER_LEVEL_1, 1);
            editor.putInt(Constant.KEY_BEGINNER_LEVEL_2, 0);
            editor.putInt(Constant.KEY_BEGINNER_LEVEL_3, 0);

        }else
        if (sharedPreferences.getString(Constant.KEY_CAT_BEGINNER_LEVEL_2, "N/A").equals("Unlock")){

            editor.putInt(Constant.KEY_BEGINNER_LEVEL_1, 1);
            editor.putInt(Constant.KEY_BEGINNER_LEVEL_2, 1);
            editor.putInt(Constant.KEY_BEGINNER_LEVEL_3, 0);

        } else
        if (sharedPreferences.getString(Constant.KEY_CAT_BEGINNER_LEVEL_3, "N/A").equals("Unlock")){

            editor.putInt(Constant.KEY_BEGINNER_LEVEL_1, 1);
            editor.putInt(Constant.KEY_BEGINNER_LEVEL_2, 1);
            editor.putInt(Constant.KEY_BEGINNER_LEVEL_3, 1);

        }


    }

    private void createLevelsforIntermediate() {

        SharedPreferences sharedPreferences =
                getSharedPreferences(getPackageName() + Constant.MY_LEVEL_PREFERENCE, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(Constant.KEY_CAT_INTERMEDIATE_LEVEL_1, 1); //  BY DEFAULT IT IS SET TO LEVEL 1 UNLOCKED
        editor.putString(Constant.KEY_CAT_INTERMEDIATE_LEVEL_1, "Unlock");
        editor.apply();

        if (sharedPreferences.getString(Constant.KEY_CAT_INTERMEDIATE_LEVEL_1, "N/A").equals("Unlock")){

            editor.putInt(Constant.KEY_INTERMEDIATE_LEVEL_1, 1);
            editor.putInt(Constant.KEY_INTERMEDIATE_LEVEL_2, 0);
            editor.putInt(Constant.KEY_INTERMEDIATE_LEVEL_3, 0);

        }else
        if (sharedPreferences.getString(Constant.KEY_CAT_INTERMEDIATE_LEVEL_2, "N/A").equals("Unlock")){

            editor.putInt(Constant.KEY_INTERMEDIATE_LEVEL_1, 1);
            editor.putInt(Constant.KEY_INTERMEDIATE_LEVEL_2, 1);
            editor.putInt(Constant.KEY_INTERMEDIATE_LEVEL_3, 0);

        } else
        if (sharedPreferences.getString(Constant.KEY_CAT_INTERMEDIATE_LEVEL_3, "N/A").equals("Unlock")){

            editor.putInt(Constant.KEY_INTERMEDIATE_LEVEL_1, 1);
            editor.putInt(Constant.KEY_INTERMEDIATE_LEVEL_2, 1);
            editor.putInt(Constant.KEY_INTERMEDIATE_LEVEL_3, 1);

        }


    }


    private void createLevelsforDifficult() {

        SharedPreferences sharedPreferences =
                getSharedPreferences(getPackageName() + Constant.MY_LEVEL_PREFERENCE, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(Constant.KEY_CAT_DIFFICULT_LEVEL_1, 1); //  BY DEFAULT IT IS SET TO LEVEL 1 UNLOCKED
        editor.putString(Constant.KEY_CAT_DIFFICULT_LEVEL_1, "Unlock");
        editor.apply();

        if (sharedPreferences.getString(Constant.KEY_CAT_DIFFICULT_LEVEL_1, "N/A").equals("Unlock")){

            editor.putInt(Constant.KEY_DIFFICULT_LEVEL_1, 1);
            editor.putInt(Constant.KEY_DIFFICULT_LEVEL_2, 0);
            editor.putInt(Constant.KEY_DIFFICULT_LEVEL_3, 0);

        }else
        if (sharedPreferences.getString(Constant.KEY_CAT_DIFFICULT_LEVEL_2, "N/A").equals("Unlock")){

            editor.putInt(Constant.KEY_DIFFICULT_LEVEL_1, 1);
            editor.putInt(Constant.KEY_DIFFICULT_LEVEL_2, 1);
            editor.putInt(Constant.KEY_DIFFICULT_LEVEL_3, 0);

        } else
        if (sharedPreferences.getString(Constant.KEY_CAT_DIFFICULT_LEVEL_3, "N/A").equals("Unlock")){

            editor.putInt(Constant.KEY_DIFFICULT_LEVEL_1, 1);
            editor.putInt(Constant.KEY_DIFFICULT_LEVEL_2, 1);
            editor.putInt(Constant.KEY_DIFFICULT_LEVEL_3, 1);

        }


    }




}