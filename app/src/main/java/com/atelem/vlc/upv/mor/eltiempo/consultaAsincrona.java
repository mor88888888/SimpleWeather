package com.atelem.vlc.upv.mor.eltiempo;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class consultaAsincrona extends AsyncTask<String, Void, Boolean>{

    protected Boolean doInBackground(String... NOMBRE){
        try {

            System.out.println(NOMBRE);
            URL url = new URL("http://servermor.asuscomm.com:8564/bd.php?nombre=" + NOMBRE);
            String inputLine="";
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
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
}
