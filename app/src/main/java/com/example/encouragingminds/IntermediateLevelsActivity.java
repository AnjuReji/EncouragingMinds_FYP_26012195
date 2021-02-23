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

public class IntermediateLevelsActivity extends AppCompatActivity implements View.OnClickListener{

    Button btLevel1, btLevel2, btLevel3;

    String categoryValue = "";

    int IL1, IL2, IL3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_intermediatelevels);

        btLevel1 = findViewById(R.id.btLevel1);
        btLevel2 = findViewById(R.id.btLevel2);
        btLevel3 = findViewById(R.id.btLevel3);

        // btLevel1.setOnClickListener(this);    This bit was commented out because the onClickListener is being called below
        //  btLevel2.setOnClickListener(this);
        //  btLevel3.setOnClickListener(this);


        lockandunlockLevels();


        Intent intentCategory = getIntent();
        categoryValue = intentCategory.getStringExtra("Category");

    }

    private void lockandunlockLevels() {

        SharedPreferences sharedPreferences =
                getSharedPreferences(getPackageName() + Constant.MY_LEVEL_PREFERENCE, Context.MODE_PRIVATE);

        IL1 = sharedPreferences.getInt(Constant.KEY_INTERMEDIATE_LEVEL_1, 1);
        IL2 = sharedPreferences.getInt(Constant.KEY_INTERMEDIATE_LEVEL_2, 0);
        IL3 = sharedPreferences.getInt(Constant.KEY_INTERMEDIATE_LEVEL_3, 0);

        if (IL1 == 1){

            btLevel1.setClickable(true);
            btLevel1.setBackground(ContextCompat.getDrawable(this, R.drawable.buttons_background));
            btLevel1.setOnClickListener(this);
        }else if (IL1 == 0) {

            btLevel1.setClickable(false);
            btLevel1.setBackground(ContextCompat.getDrawable(this, R.drawable.level_lock));

        }

        if (IL2 == 1) {

            btLevel2.setClickable(true);
            btLevel2.setBackground(ContextCompat.getDrawable(this, R.drawable.buttons_background));
            btLevel2.setOnClickListener(this);

        } else if (IL2 == 0) {

            btLevel2.setClickable(false);
            btLevel2.setBackground(ContextCompat.getDrawable(this, R.drawable.level_lock));

        }

        if (IL3 == 1) {

            btLevel3.setClickable(true);
            btLevel3.setBackground(ContextCompat.getDrawable(this, R.drawable.buttons_background));
            btLevel3.setOnClickListener(this);

        } else if (IL3 == 0) {

            btLevel3.setClickable(false);
            btLevel3.setBackground(ContextCompat.getDrawable(this, R.drawable.level_lock));

        }


    }


    @Override
    public void onClick(View v) {

        if (categoryValue.equals("Intermediate")){

            switch (v.getId()){

                case R.id.btLevel1:

                    Intent intentIntermediateLevel1 = new Intent(IntermediateLevelsActivity.this, QuizActivity.class);

                    intentIntermediateLevel1.putExtra("Category", categoryValue);
                    intentIntermediateLevel1.putExtra("Level", Questions.LEVEL1);
                    startActivity(intentIntermediateLevel1);
                    break;

                case R.id.btLevel2:

                    Intent intentIntermediateLevel2 = new Intent(IntermediateLevelsActivity.this, QuizActivity.class);

                    intentIntermediateLevel2.putExtra("Category", categoryValue);
                    intentIntermediateLevel2.putExtra("Level", Questions.LEVEL2);
                    startActivity(intentIntermediateLevel2);

                    break;

                case R.id.btLevel3:

                    Intent intentIntermediateLevel3 = new Intent(IntermediateLevelsActivity.this, QuizActivity.class);

                    intentIntermediateLevel3.putExtra("Category", categoryValue);
                    intentIntermediateLevel3.putExtra("Level", Questions.LEVEL3);
                    startActivity(intentIntermediateLevel3);

                    break;

            }


        }

    }
}
