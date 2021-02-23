package com.example.encouragingminds;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static java.lang.Thread.sleep;

public class SplashScreen extends AppCompatActivity {

    private final static int EXIT_CODE = 100;

    ImageView imgViewLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);

        imgViewLogo = findViewById(R.id.imgviewLogo);


        Animation animation = AnimationUtils.loadAnimation(this,R.anim.transition);
        imgViewLogo.setAnimation(animation);


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {


                try{

                    sleep(3000);


                }catch (Exception e){

                    e.printStackTrace();
                }finally {


                    GotoPlayActivity();

                }


            }
        });
        thread.start();

    }

    private void GotoPlayActivity() {

        startActivityForResult( new Intent(SplashScreen.this,PlayActivity.class),EXIT_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == EXIT_CODE){

            if (resultCode == RESULT_OK){
                if (data.getBooleanExtra("EXIT",true)){
                    finish();
                }
            }
        }


    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("BUGBUG","onStop() in SplashActivity");
        finish();

    }
}