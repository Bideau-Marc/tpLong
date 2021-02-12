package com.example.tp_long;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class Fragment_Main3 extends Fragment implements View.OnClickListener {


    public Fragment_Main3() {
        super(R.layout.fragment__main3);
    }
    TableLayout tableLayout;
    ArrayList<String> name ;
    ArrayList<String> type ;
    ArrayList<String> rep;
    ArrayList<String> poids;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        tableLayout = getView().findViewById(R.id.table);
        name = this.getArguments().getStringArrayList("name");
        type = this.getArguments().getStringArrayList("type");
        rep = this.getArguments().getStringArrayList("rep");
        poids = this.getArguments().getStringArrayList("weight");
        for(int i =0;i<name.size(); i++){
            LinearLayout layout = new LinearLayout(getContext());
            TextView textView = new TextView(getContext());
            if(poids.get(i)==null){
                textView.setText("nom de l'exercice : "+name.get(i) + " de type : " + type.get(i)+" à repeter : " + rep.get(i) + "fois");
            }else{
                textView.setText("nom de l'exercice : "+name.get(i) + " de type : " + type.get(i)+" à repeter : " + rep.get(i) + " fois avec : " +poids.get(i) + " poids" );
            }
            layout.addView(textView);
            tableLayout.addView(layout);
        }
        Button button = getView().findViewById(R.id.button3);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(R.id.button3 == view.getId()){
            System.out.println("test");
            for(int i = name.size(); i<0;i--){
                name.remove(i);
                type.remove(i);
                rep.remove(i);
                poids.remove(i);
            }
            Frag_act3 frag_act3 = new Frag_act3();
            getFragmentManager().beginTransaction()
                    //replace in activity_main.xml the view with id frag_menu with the fragment fragMenu passing a null bundle (bundle is used to pass data to your fragment)
                    .replace(R.id.framlayout2, frag_act3, null)
                    //commit to update
                    .commit();
        }
    }
}