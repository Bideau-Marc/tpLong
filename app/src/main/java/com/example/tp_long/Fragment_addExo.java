package com.example.tp_long;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Fragment_addExo extends Fragment implements View.OnClickListener {

    public Fragment_addExo() {
        super(R.layout.fragment_add_exo);
    }
    AppCompatActivity activity;
    private AdapterView.OnItemSelectedListener listener;
String name, poids, nbrep,type;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Button btn = getView().findViewById(R.id.button2);
        btn.setOnClickListener(this);
        name = this.getArguments().getString("name");
        type = this.getArguments().getString("type");
        nbrep = this.getArguments().getString("rep");
        poids = this.getArguments().getString("poids");
    }
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        this.activity = (AppCompatActivity) context;
    }

    @Override
    public void onClick(View v) {
        System.out.println("test");
        EditText editText = getView().findViewById(R.id.editTextNumber);
        Exercice exercice = new Exercice(name,type,editText.getText().toString(), poids);
        ((MainActivity2)getActivity()).addListe(exercice);

    }
}