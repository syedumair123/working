package com.example.mymosque;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SplashScreen extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);




     /*   //Gradient Object for 5 color
        GradientDrawable gradientDrawable = new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                new int[]{ContextCompat.getColor(this, R.color.gradientColorOne),
                        ContextCompat.getColor(this, R.color.gradientColorTwo),
                        ContextCompat.getColor(this, R.color.gradientColorThree),
                        ContextCompat.getColor(this, R.color.gradientColorFour),
                        ContextCompat.getColor(this, R.color.gradientColorFive)


                });

        gradientDrawable.setGradientType(GradientDrawable.RADIAL_GRADIENT);
        gradientDrawable.setGradientRadius(10000);
        //Gradient Object for 5 color*/
        // findViewById(R.id.Splashscreen).setBackground(gradientDrawable);



        //Hide Actionbar and For full screen
        //window
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        //Hide Actionbar and For full screen


        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */

                //if user is already logged in openeing the profile activity
                Intent mainIntent = new Intent(SplashScreen.this,OnBoarding.class);
                SplashScreen.this.startActivity(mainIntent);
                SplashScreen.this.finish();


            }
        }, SPLASH_DISPLAY_LENGTH);






    }//end of OnCreate Method







}//end of Class
