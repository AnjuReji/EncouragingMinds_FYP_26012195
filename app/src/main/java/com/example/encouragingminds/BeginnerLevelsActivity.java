package com.example.encouragingminds;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.core.content.ContextCompat;

public class BeginnerLevelsActivity extends QuizBaseActivity implements View.OnClickListener{

    Button btLevel1, btLevel2, btLevel3;

    String CategoryValue = "";

    int BL1, BL2, BL3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginnerlevels);

        btLevel1 = findViewById(R.id.btLevel1);
        btLevel2 = findViewById(R.id.btLevel2);
        btLevel3 = findViewById(R.id.btLevel3);

        // btLevel1.setOnClickListener(this);    This bit was commented out because the onClickListener is being called below
        //  btLevel2.setOnClickListener(this);
        //  btLevel3.setOnClickListener(this);


        lockandunlockLevels();


        Intent intentCategory = getIntent();
        CategoryValue = intentCategory.getStringExtra("Category");

    }

    private void lockandunlockLevels() {

        SharedPreferences sharedPreferences =
                getSharedPreferences(getPackageName() + Constant.MY_LEVEL_PREFERENCE, Context.MODE_PRIVATE);

        BL1 = sharedPreferences.getInt(Constant.KEY_BEGINNER_LEVEL_1, 1);
        BL2 = sharedPreferences.getInt(Constant.KEY_BEGINNER_LEVEL_2, 0);
        BL3 = sharedPreferences.getInt(Constant.KEY_BEGINNER_LEVEL_3, 0);

        if (BL1 == 1){

            btLevel1.setClickable(true);
            btLevel1.setBackground(ContextCompat.getDrawable(this, R.drawable.buttons_background));
            btLevel1.setOnClickListener(this);
        }else if (BL1 == 0) {

            btLevel1.setClickable(false);
            btLevel1.setBackground(ContextCompat.getDrawable(this, R.drawable.level_lock));

        }

        if (BL2 == 1) {

            btLevel2.setClickable(true);
            btLevel2.setBackground(ContextCompat.getDrawable(this, R.drawable.buttons_background));
            btLevel2.setOnClickListener(this);

        } else if (BL2 == 0) {

            btLevel2.setClickable(false);
            btLevel2.setBackground(ContextCompat.getDrawable(this, R.drawable.level_lock));

        }

        if (BL3 == 1) {

            btLevel3.setClickable(true);
            btLevel3.setBackground(ContextCompat.getDrawable(this, R.drawable.buttons_background));
            btLevel3.setOnClickListener(this);

        } else if (BL3 == 0) {

            btLevel3.setClickable(false);
            btLevel3.setBackground(ContextCompat.getDrawable(this, R.drawable.level_lock));

        }


    }


    @Override
    public void onClick(View v) {

        if (CategoryValue.equals("Beginner")){

            switch (v.getId()){

                case R.id.btLevel1:

                    Intent intentBeginnerLevel1 = new Intent(BeginnerLevelsActivity.this, QuizActivity.class);

                    intentBeginnerLevel1.putExtra("Category", CategoryValue);
                    intentBeginnerLevel1.putExtra("Level", Questions.LEVEL1);
                    startActivity(intentBeginnerLevel1);
                    break;

                case R.id.btLevel2:

                    Intent intentBeginnerLevel2 = new Intent(BeginnerLevelsActivity.this, QuizActivity.class);

                    intentBeginnerLevel2.putExtra("Category", CategoryValue);
                    intentBeginnerLevel2.putExtra("Level", Questions.LEVEL2);
                    startActivity(intentBeginnerLevel2);

                    break;

                case R.id.btLevel3:

                    Intent intentBeginnerLevel3 = new Intent(BeginnerLevelsActivity.this, QuizActivity.class);

                    intentBeginnerLevel3.putExtra("Category", CategoryValue);
                    intentBeginnerLevel3.putExtra("Level", Questions.LEVEL3);
                    startActivity(intentBeginnerLevel3);

                    break;

            }


        }

    }
}
