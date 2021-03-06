package com.example.lauraeche.robotg09.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.lauraeche.robotg09.R;

/**
 * Created by Lauraeche on 21/03/2018.
 */

public class RemotoActivity extends AppCompatActivity {
    private String CONTROL_FRAGMENT = "CONTROL_FRAGMENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        initFragment();
    }

    private void initFragment(){
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentByTag(CONTROL_FRAGMENT);
        if(fragment == null){
            fragment = RemotoFragment.newInstance();
        }

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        transaction.replace(R.id.activity_main_container,fragment,CONTROL_FRAGMENT);
        transaction.commit();
    }
}
