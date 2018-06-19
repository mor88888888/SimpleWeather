package com.atelem.vlc.upv.mor.eltiempo;

import java.sql.*;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText Poblacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Poblacion = (EditText)findViewById(R.id.editText);
    }

    public void Consulta (View view) {
        try {
            String NOMBRE = Poblacion.getText().toString();
            System.out.println(NOMBRE);
            URL url = new URL("http://servermor.asuscomm.com?nombre=" + NOMBRE);
            String inputLine;
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            while((inputLine = in.readLine()) != null){
                System.out.println(inputLine);
            }
        } catch (Exception e){
            System.out.println(e);
        }

    }

}
