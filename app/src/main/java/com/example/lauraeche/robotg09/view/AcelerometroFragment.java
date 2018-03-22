package com.example.lauraeche.robotg09.view;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lauraeche.robotg09.R;
import com.example.lauraeche.robotg09.viewmodel.AcelerometroViewModel;

/**
 * Created by Lauraeche on 21/03/2018.
 */

public class AcelerometroFragment extends Fragment {


    private AcelerometroViewModel viewModel;

    public static AcelerometroFragment newInstance(){
        return new AcelerometroFragment();
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
        View v = inflater.inflate(R.layout.fragment_accelerometer,container,false);
        bindViews(v);
        initViewModel();
        return v;
    }


    private void bindViews(View v){
        //DEFINO LOS TextViews del Acelerometro

    }

    private void initViewModel(){
        viewModel = ViewModelProviders.of(getActivity()).get(AcelerometroViewModel.class);

        //elapsedTimeObserver = new Observer<Integer>() {
            /*@Override
            public void onChanged(@Nullable Integer seconds) {
                setElapsedTime(seconds);
            }*/
        //};
    }


    @Override
    public void onStop(){
        super.onStop();
        viewModel.stopCounting(getContext());
    }
}
