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
public class EditPerson extends Fragment {

    private EditText carnet;
    private EditText nota;
    private Button buton;
    public EditPerson() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        carnet = view.findViewById(R.id.EditCarnet);
        nota = view.findViewById(R.id.EditNota);
        buton = view.findViewById(R.id.EditButton);

        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person p = DBHelper.myDB.findUser(carnet.getText().toString());
                p.setNota(Integer.parseInt(nota.getText().toString()));
                DBHelper.myDB.editUser(p);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_person, container, false);
    }

}
