package com.example.tp_long;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn;
        btn = findViewById(R.id.button);
        btn.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        SQLiteDatabase db = openOrCreateDatabase("MaBaseDeDonnees",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS user(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,login TEXT,password TEXT)");
        db.execSQL("INSERT INTO user (login, password) VALUES ('eddi','malou')");

        EditText ed = findViewById(R.id.editTextTextPersonName);
        EditText ed2 = findViewById(R.id.editTextTextPersonName2);
        boolean exist = false;
        Switch s = findViewById(R.id.switch1);
        if(s.isChecked()){
            ContentValues newTaskValues = new ContentValues();
            String log = ed.getText().toString();
            String psw = ed2.getText().toString();
            newTaskValues.put("login",ed.getText().toString());
            newTaskValues.put("password",ed2.getText().toString());

            System.out.println(log+"ici");

            Cursor cursorSELECT = db.rawQuery("SELECT * FROM user", null);
            cursorSELECT.moveToFirst();
            while (!cursorSELECT.isLast()) {
                if(cursorSELECT.getString(1).equals(ed.getText().toString()) && cursorSELECT.getString(2).equals(ed2.getText().toString())){
                    exist=true;
                    System.out.println("vrai");
                }
                System.out.println(cursorSELECT.getString(1)+" ed "+ed.getText().toString() + cursorSELECT.getString(2)+ " ed2 "+ed2.getText().toString());
                cursorSELECT.moveToNext();
            }
            if(!exist){
                db.insert("user",null,newTaskValues);
                System.out.println("insertion bd");
            }
            else{
                s.setChecked(false);
                System.out.println(log+"ici");
                System.out.println("nous testons le setChecked "+ s.isChecked());
            }

        }
        else {
            Cursor cursorSELECT = db.rawQuery("SELECT * FROM user", null);
            cursorSELECT.moveToFirst();
            while (!cursorSELECT.isLast()) {
                cursorSELECT.moveToNext();
                if(cursorSELECT.getString(1).equals(ed.getText().toString()) && cursorSELECT.getString(2).equals(ed2.getText().toString())){
                    System.out.println("je suis la");
                    Intent activity2Intent = new Intent(getApplicationContext(), MainActivity2.class);
                    startActivity(activity2Intent);
                }
            }

            s.setChecked(true);
        }
    }
}