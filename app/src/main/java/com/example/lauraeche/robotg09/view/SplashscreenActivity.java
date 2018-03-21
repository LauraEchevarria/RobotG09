package com.example.lauraeche.robotg09.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.lauraeche.robotg09.R;
import com.example.lauraeche.robotg09.constants.SplashConstants;

/**
 * Created by Lauraeche on 21/03/2018.
 */

public class SplashscreenActivity extends AppCompatActivity {

    private String SPLASH_FRAGMENT = "SPLASH_FRAGMENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFragment();

        //SPLASH SCREEN:
        Thread background = new Thread() {
            public void run() {
                try {
                    sleep(SplashConstants.TIME);
                    startActivity(new Intent(SplashscreenActivity.this,MainActivity.class));
                    finish();
                } catch (Exception e) {
                }
            }
        };
        // start thread
        background.start();
    }

    private void initFragment(){
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentByTag(SPLASH_FRAGMENT);
        if(fragment == null){
            fragment = SplashscreenFragment.newInstance();
        }

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        transaction.replace(R.id.activity_main_container,fragment,SPLASH_FRAGMENT);
        transaction.commit();

    }


}
