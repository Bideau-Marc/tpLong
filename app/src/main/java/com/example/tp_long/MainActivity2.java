package com.example.tp_long;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    public MainActivity2() {
        super(R.layout.activity_main2);
    }
    ArrayList<Exercice> arrayList = new ArrayList<Exercice>() ;
    ArrayList<Exercice> seance = new ArrayList<Exercice>();
    Fragment_Principal fragmentPricipal = new Fragment_Principal();
    FragmentManager fm = getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Exercice exercice = new Exercice("push ups","musculation", "3x10",null);
        Exercice exercice1 = new Exercice("abs","cardio", "3x10",null);
        Exercice exercice2 = new Exercice("squats","musculation", "3x10","500 grammes");
        arrayList.add(exercice1);
        arrayList.add(exercice2);
        arrayList.add(exercice);
        int i = (int) (Math.random() * ( arrayList.size() - 0 ));
        Bundle bundle = new Bundle();
        bundle.putString("name", arrayList.get(i).getName() );
        bundle.putString("type", arrayList.get(i).getType() );
        bundle.putString("rep", arrayList.get(i).getLidteRep());
        bundle.putString("poids",arrayList.get(i).getPoids());
        fragmentPricipal.setArguments(bundle);
        fm.beginTransaction()
                //replace in activity_main.xml the view with id frag_menu with the fragment fragMenu passing a null bundle (bundle is used to pass data to your fragment)
                .add(R.id.frameLayout, fragmentPricipal, null)
                //commit to update
                .commit();
    }

    public void updateListe(Exercice exercice) {
        arrayList.add(exercice);Bundle bundle = new Bundle();
        int i = (int) (Math.random() * ( arrayList.size() - 0 ));
        bundle.putString("name", arrayList.get(i).getName() );
        bundle.putString("type", arrayList.get(i).getType() );
        fragmentPricipal.setArguments(bundle);
        fm.beginTransaction()
                //replace in activity_main.xml the view with id frag_menu with the fragment fragMenu passing a null bundle (bundle is used to pass data to your fragment)
                .replace(R.id.frameLayout, fragmentPricipal, null)
                //commit to update
                .commit();
    }
    public void addListe(Exercice exercice) {
        seance.add(exercice);
        Bundle bundle = new Bundle();
        int i = (int) (Math.random() * ( arrayList.size() - 0 ));
        bundle.putString("name", arrayList.get(i).getName() );
        bundle.putString("type", arrayList.get(i).getType() );
        System.out.println(seance.size());
        fragmentPricipal.setArguments(bundle);
        for (int j =0;j<seance.size();j++){
            System.out.println("nom " +seance.get(j).getName()+ " type " +seance.get(j).getType());
        }
        fm.beginTransaction()
                //replace in activity_main.xml the view with id frag_menu with the fragment fragMenu passing a null bundle (bundle is used to pass data to your fragment)
                .replace(R.id.frameLayout, fragmentPricipal, null)
                //commit to update
                .commit();
    }

    public void deleteExo(String toString) {
        for(int o =0; o<arrayList.size(); o++) {
            System.out.println("avant del"+arrayList.get(o).getName());
            if(arrayList.get(o).getName().equals(toString)) {
                arrayList.remove(arrayList.get(o));
            }
        }
        for(int e =0; e<arrayList.size(); e++) {
            System.out.println("apprsè del "+ arrayList.get(e).getName());
        }
        int i = (int) (Math.random() * ( arrayList.size() - 0 ));
        Bundle bundle = new Bundle();
        bundle.putString("name", arrayList.get(i).getName() );
        bundle.putString("type", arrayList.get(i).getType() );
        fragmentPricipal.setArguments(bundle);
        fm.beginTransaction()
                //replace in activity_main.xml the view with id frag_menu with the fragment fragMenu passing a null bundle (bundle is used to pass data to your fragment)
                .replace(R.id.frameLayout, fragmentPricipal, null)
                //commit to update
                .commit();
    }
    public void launchAct3(){
        Bundle a=new Bundle();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> type = new ArrayList<>();
        ArrayList<String> rep = new ArrayList<>();
        ArrayList<String> weight = new ArrayList<>();
        for(int i =0 ; i<seance.size();i++){
            name.add(seance.get(i).getName());
            type.add(seance.get(i).getType());
            rep.add(seance.get(i).getLidteRep());
            weight.add(seance.get(i).getPoids());
        }
        a.putStringArrayList("name", name);
        a.putStringArrayList("type", type);
        a.putStringArrayList("rep", rep);
        a.putStringArrayList("weight", weight);
        Intent i=new Intent(getApplicationContext(), MainActivity3.class);
        i.putExtras(a);
        startActivity(i);
    }
    public void switchEx(){
        int i = (int) (Math.random() * ( arrayList.size() - 0 ));
        System.out.println("test : "+i);
        Bundle bundle = new Bundle();
        System.out.println("name : "+arrayList.get(i).getName());
        bundle.putString("name", arrayList.get(i).getName() );
        bundle.putString("type", arrayList.get(i).getType() );
        bundle.putString("rep", arrayList.get(i).getLidteRep());
        bundle.putString("poids",arrayList.get(i).getPoids());
        Fragment_Principal fragment_Principal = new Fragment_Principal();
        fragment_Principal.setArguments(bundle);
        fm.beginTransaction()
                //replace in activity_main.xml the view with id frag_menu with the fragment fragMenu passing a null bundle (bundle is used to pass data to your fragment)
                .replace(R.id.frameLayout, fragment_Principal, null)
                //commit to update
                .commit();
    }
}
