package com.atelem.vlc.upv.mor.eltiempo;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import okhttp3.*;
import javax.json.*;

public class consultaAsincrona extends AsyncTask<String, Void, Boolean>{

    String inputLine="";

    protected Boolean doInBackground(String... NOMBRE){
        try {
            System.out.println("Nombre: "+NOMBRE[0]);
            //URL url = new URL("http://servermor.asuscomm.com:8564/bd.php?nombre=" + NOMBRE[0]);
            URL url = new URL("http://192.168.1.12/bd.php?nombre=" + NOMBRE[0]);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            if((inputLine = in.readLine()) != null){
                System.out.println(inputLine);
            } else{
                System.out.println("ERROR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            }
        } catch (Exception e){
            System.out.println(e);
        }

        try {
            String api_key="";
            URL url = new URL("https://opendata.aemet.es/opendata/api/"
                    +"prediccion/especifica/municipio/diaria/"
                    +inputLine+"?api_key=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb21vYWw2QGRvY3Rvci51cHYuZXMiLCJqdGkiOiJjMjc3YmIzZS04YWEwLTQ4MGMtOTFmZC1hODNlZjYxMjdkMTciLCJpc3MiOiJBRU1FVCIsImlhdCI6MTUyNjAyNDE1NywidXNlcklkIjoiYzI3N2JiM2UtOGFhMC00ODBjLTkxZmQtYTgzZWY2MTI3ZDE3Iiwicm9sZSI6IiJ9.wa5Ft9x1FyKTJKRxP-DcO3urDFGNp6zSnFoAdb33Cc8");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String ok="";
            while((ok = in.readLine()) != null){
                System.out.println(ok);
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return true;
    }


}
