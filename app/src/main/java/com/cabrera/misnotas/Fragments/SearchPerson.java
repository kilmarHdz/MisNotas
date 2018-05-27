package com.cabrera.misnotas.Fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cabrera.misnotas.Database.DBHelper;
import com.cabrera.misnotas.Model.Person;
import com.cabrera.misnotas.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchPerson extends Fragment {
    private Button button;
    private EditText texto;
    private TextView carnet;
    private TextView nota;
    private TextView materia;
    private TextView catedratico;

    public SearchPerson() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        texto= view.findViewById(R.id.SearchEditText);
        carnet = view.findViewById(R.id.SearchCarnet);
        nota = view.findViewById(R.id.SearchNota);
        materia = view.findViewById(R.id.SearchMateria);
        catedratico = view.findViewById(R.id.SearchCatedratico);
        button = view.findViewById(R.id.SearchButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person p= DBHelper.myDB.findUser(texto.getText().toString());
                if(p!=null){
                    carnet.setText(p.getCarnet());
                    nota.setText(p.getNota()+"");
                    materia.setText(p.getMateria());
                    catedratico.setText(p.getCatedratico());
                }
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_person, container, false);
    }

}