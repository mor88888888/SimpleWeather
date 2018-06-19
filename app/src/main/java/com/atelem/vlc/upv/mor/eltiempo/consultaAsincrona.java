package com.atelem.vlc.upv.mor.eltiempo;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class consultaAsincrona extends AsyncTask<String, Void, Boolean>{

    String inputLine="";

    protected Boolean doInBackground(String... NOMBRE){
        try {

            System.out.println("Nombre: "+NOMBRE[0]);
            //URL url = new URL("http://servermor.asuscomm.com:8564/bd.php?nombre=" + NOMBRE);
            URL url = new URL("http://192.168.1.12/bd.php?nombre=" + NOMBRE[0]);
            System.out.println("URL!!!!!!!!!!!!!!!!!!");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            System.out.println("IN!!!!!!!!!!!!!!!!!!");
            if((inputLine = in.readLine()) != null){
                System.out.println(inputLine);
            } else{
                System.out.println("ERROR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            }
            //return inputLine;
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public String getLine(){
        return inputLine;
    }
}
