package com.example.encouragingminds;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class DifficultLevelsActivity extends AppCompatActivity implements View.OnClickListener{

    Button btLevel1, btLevel2, btLevel3;

    String CategoryValue = "";

    int DL1, DL2, DL3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_difficultlevels);

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

        DL1 = sharedPreferences.getInt(Constant.KEY_DIFFICULT_LEVEL_1, 1);
        DL2 = sharedPreferences.getInt(Constant.KEY_DIFFICULT_LEVEL_2, 0);
        DL3 = sharedPreferences.getInt(Constant.KEY_DIFFICULT_LEVEL_3, 0);

        if (DL1 == 1){

            btLevel1.setClickable(true);
            btLevel1.setBackground(ContextCompat.getDrawable(this, R.drawable.buttons_background));
            btLevel1.setOnClickListener(this);
        }

            if (DL2 == 1) {

                btLevel2.setClickable(true);
                btLevel2.setBackground(ContextCompat.getDrawable(this, R.drawable.buttons_background));
                btLevel2.setOnClickListener(this);

            } else if (DL2 == 0) {

                btLevel2.setClickable(false);
                btLevel2.setBackground(ContextCompat.getDrawable(this, R.drawable.level_lock));

            }

            if (DL3 == 1) {

                btLevel3.setClickable(true);
                btLevel3.setBackground(ContextCompat.getDrawable(this, R.drawable.buttons_background));
                btLevel3.setOnClickListener(this);

            } else if (DL3 == 0) {

                btLevel3.setClickable(false);
                btLevel3.setBackground(ContextCompat.getDrawable(this, R.drawable.level_lock));

            }



    }


    @Override
    public void onClick(View v) {

        if (CategoryValue.equals("Difficult")){

            switch (v.getId()){

                case R.id.btLevel1:

                    Intent intentDifficultLevel1 = new Intent(DifficultLevelsActivity.this, QuizActivity.class);

                    intentDifficultLevel1.putExtra("Category", CategoryValue);
                    intentDifficultLevel1.putExtra("Level", Questions.LEVEL1);
                    startActivity(intentDifficultLevel1);
                    break;

                case R.id.btLevel2:

                    Intent intentDifficultLevel2 = new Intent(DifficultLevelsActivity.this, QuizActivity.class);

                    intentDifficultLevel2.putExtra("Category", CategoryValue);
                    intentDifficultLevel2.putExtra("Level", Questions.LEVEL2);
                    startActivity(intentDifficultLevel2);

                    break;

                case R.id.btLevel3:

                    Intent intentDifficultLevel3 = new Intent(DifficultLevelsActivity.this, QuizActivity.class);

                    intentDifficultLevel3.putExtra("Category", CategoryValue);
                    intentDifficultLevel3.putExtra("Level", Questions.LEVEL3);
                    startActivity(intentDifficultLevel3);

                    break;

            }


        }

    }
}