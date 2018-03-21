package com.example.lauraeche.robotg09.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.example.lauraeche.robotg09.data.repository.Repository;


/**
 * Created by Lauraeche on 18/03/2018.
 */

public class ComunicacionViewModel extends ViewModel implements Repository.RepositoryCallbacks {
    private Repository repository;

    //observable integer variable
    private MutableLiveData<Integer> elapsedSeconds;

    public ComunicacionViewModel(){
        repository = new Repository(this);
    }

    public LiveData<Integer> startCounting(Context context){
        if(elapsedSeconds == null){
            //init observable variable
            elapsedSeconds = new MutableLiveData<>();
        }
        //tell the repository to start the service
        repository.startService(context);
        //return the observable variable
        return elapsedSeconds;
    }
}
