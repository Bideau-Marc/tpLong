package com.example.tp_long;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
public class Frag_act3 extends Fragment implements View.OnClickListener {
    public Frag_act3() {
        super(R.layout.fragment_frag_act3);
    }
    String url_img ;
    TextView textView;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Button button = getView().findViewById(R.id.buttonaddquote);
        button.setOnClickListener(this);
         textView = getView().findViewById(R.id.idquote);
        Ion.with(this)
                .load("http://api.quotable.io/random")
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        url_img = result.get("content").getAsString();
                        textView.setMaxWidth(1100);
                        textView.setText(url_img);

                    }
                });
    }

    @Override
    public void onClick(View view) {
        textView = getView().findViewById(R.id.idquote);
        Ion.with(this)
                .load("http://api.quotable.io/random")
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        url_img = result.get("content").getAsString();
                        textView.setText(url_img);
                    }
                });

    }
}