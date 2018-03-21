package com.example.lauraeche.robotg09.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.lauraeche.robotg09.R;
import com.example.lauraeche.robotg09.constants.MainConstants;
import com.example.lauraeche.robotg09.viewmodel.MainViewModel;

/**
 * Created by Lauraeche on 21/03/2018.
 */

public class MainFragment extends Fragment{

    private Button btn_remoto, btn_laberinto, btn_acelerometro, btn_comunicacion;
    //private ImageView img_background;
    //private TextView textView;
    //private Button button1,button2;

    private MainViewModel viewModel;
    //private Observer<Integer> elapsedTimeObserver;

    public static MainFragment newInstance(){
        return new MainFragment();
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
        View v = inflater.inflate(R.layout.fragment_main,container,false);
        bindViews(v);
        initViewModel();
        return v;
    }

    private void bindViews(View v){
        //DEFINO LOS 4 BOTONES DEL MAIN Y PARA CADA UNO LANZO SU ACTIVITY
        btn_remoto = v.findViewById(R.id.btn_remoto);
        btn_remoto.setText(MainConstants.BTN_REMOTO);
        btn_remoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {launchActivity(MainConstants.ACTIVITY_REMOTO);}
        });

        btn_laberinto = v.findViewById(R.id.btn_labterinto);
        btn_laberinto.setText(MainConstants.BTN_LABERINTO);
        btn_laberinto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {launchActivity(MainConstants.ACTIVITY_LABERINTO);}
        });

        btn_acelerometro = v.findViewById(R.id.btn_acelerometro);
        btn_acelerometro.setText(MainConstants.BTN_ACELEROMETRO);
        btn_acelerometro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {launchActivity(MainConstants.ACTIVITY_ACELEROMETRO);}
        });

        btn_comunicacion = v.findViewById(R.id.btn_comunicacion);
        btn_comunicacion.setText(MainConstants.BTN_COMUNICACION);
        btn_comunicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {launchActivity(MainConstants.ACTIVITY_COMUNICACION);}
        });
    }

    private void initViewModel(){
        viewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);

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



    public void launchActivity(int actividadNueva){
        switch (actividadNueva){
            case MainConstants.ACTIVITY_REMOTO:
                startActivity(new Intent(getActivity(), RemotoActivity.class));
                break;
            case MainConstants.ACTIVITY_ACELEROMETRO:
                startActivity(new Intent(getActivity(), AcelerometroActivity.class));
                break;
            case MainConstants.ACTIVITY_LABERINTO:
                startActivity(new Intent(getActivity(), LaberintoActivity.class));
                break;
            case MainConstants.ACTIVITY_COMUNICACION:
                startActivity(new Intent(getActivity(), ComunicacionActivity.class));
                break;
            default:
            //TODO: que hay que poner por defecto?
        }
    }
}
