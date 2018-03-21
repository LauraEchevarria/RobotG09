package com.example.lauraeche.robotg09.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lauraeche.robotg09.R;

/**
 * Created by Lauraeche on 21/03/2018.
 */

public class SplashscreenFragment extends Fragment {

    public static SplashscreenFragment newInstance(){
        return new SplashscreenFragment();
    }
    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View v = inflater.inflate(R.layout.fragment_splash,container,false);
        return v;
    }


}
