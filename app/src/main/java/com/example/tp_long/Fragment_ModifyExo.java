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
import android.widget.Button;
import android.widget.EditText;

public class Fragment_ModifyExo extends Fragment implements View.OnClickListener {


    public Fragment_ModifyExo() {
        super(R.layout.fragment__modify_exo);

    }
    AppCompatActivity activity;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText editText = getView().findViewById(R.id.editTextAddName);
        EditText editText1 = getView().findViewById(R.id.editTextAddType);
        EditText editText2 = getView().findViewById(R.id.editTextAddRep);
        EditText editText3 = getView().findViewById(R.id.editTextAddWeight);
        Button btn = getView().findViewById(R.id.btnadd);
        Button btndel = getView().findViewById(R.id.btnDel);
        btndel.setOnClickListener(this);
        btn.setOnClickListener(this);
    }
        public void onAttach(@NonNull Context context) {
            super.onAttach(context);

            this.activity = (AppCompatActivity) context;
        }

        @Override
        public void onClick(View v) {
            EditText editText = getView().findViewById(R.id.editTextAddName);
            EditText editText1= getView().findViewById(R.id.editTextAddType);
            EditText editText2= getView().findViewById(R.id.editTextAddRep);
            EditText editText3= getView().findViewById(R.id.editTextAddWeight);
            Exercice exo = new Exercice(editText.getText().toString(), editText1.getText().toString(),editText2.getText().toString(),editText3.getText().toString());
            switch (v.getId()) {
                case R.id.btnadd:
                    ((MainActivity2)getActivity()).updateListe(exo);
                    break;
                case R.id.btnDel:
                    ((MainActivity2)getActivity()).deleteExo(editText.getText().toString());
            }

        }
}