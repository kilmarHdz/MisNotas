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

import com.cabrera.misnotas.Database.DBHelper;
import com.cabrera.misnotas.Model.Person;
import com.cabrera.misnotas.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class InsertPerson extends Fragment {

    private EditText catedratico;
    private EditText materia;
    private EditText carnet;
    private EditText nota;
    public InsertPerson() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button insert = view.findViewById(R.id.IngresarButton);
        catedratico  = view.findViewById(R.id.CatedraticoInsert);
        materia = view.findViewById(R.id.MateriaInsert);
        carnet = view.findViewById(R.id.CarnetInsert);
        nota = view.findViewById(R.id.NotaInsert);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper.myDB.add(new Person(
                        carnet.getText().toString(),
                        Integer.parseInt(nota.getText().toString()),
                        materia.getText().toString(),
                        catedratico.getText().toString()));
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_insert_person, container, false);

        return v;
    }

}