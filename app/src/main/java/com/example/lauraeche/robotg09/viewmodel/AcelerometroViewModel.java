package com.example.lauraeche.robotg09.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.example.lauraeche.robotg09.data.repository.Repository;

/**
 * Created by Oscar on 22/03/2018.
 */

public class AcelerometroViewModel extends ViewModel implements Repository.RepositoryCallbacks {

    //our repository
    private Repository repository;

    //observable integer variable
    private MutableLiveData<Integer> elapsedSeconds;

    public AcelerometroViewModel(){
        repository = new Repository(this);
    }

    public LiveData<Integer> startCounting(Context context){
        if(elapsedSeconds == null){
            //init observable variable
            elapsedSeconds = new MutableLiveData<>();
        }
        //tell the repository to start the service
        //repository.startService(context);
        //return the observable variable
        return elapsedSeconds;
    }

    public void stopCounting(Context context){
        //tell the repository to stop the service
        //repository.stopService(context);
    }

    /*-------------------------- Repository Callbacks -----------------------------*/
    /*@Override
    public void onSecondsUpdate(int seconds) {
        //post value to the view
        elapsedSeconds.postValue(seconds);
    }*/

    /*@Override
    public void onServiceStopped() {
        //post value to the view
        //elapsedSeconds.postValue(-1);
    }*/
}
