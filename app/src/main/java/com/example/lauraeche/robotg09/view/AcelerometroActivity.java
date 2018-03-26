package com.example.lauraeche.robotg09.view;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.lauraeche.robotg09.R;

/**
 * Created by Lauraeche on 21/03/2018.
 */

public class AcelerometroActivity extends AppCompatActivity  implements SensorEventListener {
    private String ACCELEROMETER_FRAGMENT = "ACCELEROMETER_FRAGMENT";

    public Vibrator vib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        initFragment();
    }

    private void initFragment(){
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentByTag(ACCELEROMETER_FRAGMENT);
        if(fragment == null){
            fragment = AcelerometroFragment.newInstance();
        }

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        transaction.replace(R.id.activity_accelerometer_container,fragment,ACCELEROMETER_FRAGMENT);
        transaction.commit();



    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
