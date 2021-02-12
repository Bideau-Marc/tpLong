package com.example.tp_long;

import java.security.PublicKey;
import java.util.ArrayList;

public class Exercice {
    private String name,type,lidteRep,poids;
    public String getName(){
        return name;
    }
    public  String getType(){
        return type;
    }
    public String getLidteRep(){
        return lidteRep;
    }
    public String getPoids(){
        return poids;
    }
    public Exercice(String name,String type,String listeRep,String poids){
        this.name = name;
        this.poids = poids;
        this.lidteRep = listeRep;
        this.type = type;
    }
}
