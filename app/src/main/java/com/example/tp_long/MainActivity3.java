package com.example.tp_long;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Bundle b=this.getIntent().getExtras();
        Fragment_Main3 fragment_main3 = new Fragment_Main3();
        fragment_main3.setArguments(b);
        getSupportFragmentManager().beginTransaction()
                //replace in activity_main.xml the view with id frag_menu with the fragment fragMenu passing a null bundle (bundle is used to pass data to your fragment)
                .add(R.id.framlayout2, fragment_main3, null)
                //commit to update
                .commit();

    }

    @Override
    public void onClick(View view) {

    }
}