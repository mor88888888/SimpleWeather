package com.atelem.vlc.upv.mor.eltiempo;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

public class consultaAsincrona extends AsyncTask<String, Void, Boolean>{

    protected string Codigo(String... datos){

        try {

            System.out.println(NOMBRE);
            URL url = new URL("http://servermor.asuscomm.com:8564/bd.php?nombre=" + NOMBRE);
            String inputLine;
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            while((inputLine = in.readLine()) != null){
                System.out.println(inputLine);
                return inputLine;
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }




}
