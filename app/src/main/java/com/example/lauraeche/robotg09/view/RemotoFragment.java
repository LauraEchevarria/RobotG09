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
import com.example.lauraeche.robotg09.constants.GeneralConstants;
import com.example.lauraeche.robotg09.constants.RemotoConstants;
import com.example.lauraeche.robotg09.viewmodel.RemotoViewModel;

/**
 * Created by Lauraeche on 21/03/2018.
 */

public class RemotoFragment extends Fragment {
    private Button btn_back, btn_menos, btn_mas, btn_acelerar;


    //CTES DE CONTROL DE "estados"
    private boolean MANUAL = true;
    private boolean LUCES = false;
    private int MARCHA_ACTUAL = RemotoConstants.MARCHA_PUNTOMUERTO;
    private int VELOCIDAD = 0;
    private boolean ACELERAR = false;


    private RemotoViewModel viewModel;

    public static RemotoFragment newInstance(){
        return new RemotoFragment();
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
        View v = inflater.inflate(R.layout.fragment_control,container,false);
        bindViews(v);
        initViewModel();
        return v;
    }

    private void bindViews(View v){
        //BOTÓN ATRÁS
        //TODO: Esta función debería hacerse general -> GeneralViewModel
        create_btn_back(v); //TODO: como llamar a la función de GeneralViewModel




        //BOTONES MARCHAS
        btn_mas = v.findViewById(R.id.btn_masMarcha);
        //btn_mas.setText(RemotoConstants.MARCHA_ACTUAL+1);

        btn_menos = v.findViewById(R.id.btn_masMarcha);
        //btn_mas.setText(RemotoConstants.MARCHA_ACTUAL-1);

        btn_acelerar = v.findViewById(R.id.btn_acelerar);


    }

    private void initViewModel(){
        viewModel = ViewModelProviders.of(getActivity()).get(RemotoViewModel.class);
    }

    public void closeActivity(){
        startActivity(new Intent(getActivity(), MainActivity.class));
    }

    private void create_btn_back(View v){
        btn_back = v.findViewById(R.id.btn_back);
        btn_back.setText(GeneralConstants.BTN_BACK_TEXT);
        btn_back.setHeight(GeneralConstants.BTN_BACK_HEIGHT);
        btn_back.setWidth(GeneralConstants.BTN_BACK_WIDTH);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {closeActivity();}
        });
    }

}
