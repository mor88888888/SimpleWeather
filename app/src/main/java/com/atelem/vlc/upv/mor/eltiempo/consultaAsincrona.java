package com.atelem.vlc.upv.mor.eltiempo;

import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import org.json.*;

public class consultaAsincrona extends AsyncTask<String,Void,String[]>{

    String inputLine="";
    String api="";
    String [] cielos= new String[3];
    String diaactual="";
    int [] max= new int[3];
    int [] min= new int[3];

    @Override
    protected String[] doInBackground(String... NOMBRE){
        try {
            System.out.println("Nombre: "+NOMBRE[0]);
            URL url = new URL("http://servermor.asuscomm.com:8564/bd.php?nombre=" + NOMBRE[0]);
            //URL url = new URL("http://192.168.1.12/bd.php?nombre=" + NOMBRE[0]);
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
            URL url = new URL("https://opendata.aemet.es/opendata/api/"
                    +"prediccion/especifica/municipio/diaria/"
                    +inputLine+"?api_key=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb21vYWw2QGRvY3Rvci51cHYuZXMiLCJqdGkiOiJjMjc3YmIzZS04YWEwLTQ4MGMtOTFmZC1hODNlZjYxMjdkMTciLCJpc3MiOiJBRU1FVCIsImlhdCI6MTUyNjAyNDE1NywidXNlcklkIjoiYzI3N2JiM2UtOGFhMC00ODBjLTkxZmQtYTgzZWY2MTI3ZDE3Iiwicm9sZSI6IiJ9.wa5Ft9x1FyKTJKRxP-DcO3urDFGNp6zSnFoAdb33Cc8");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String ok="";
            String line;
            while((line = in.readLine()) != null){
                ok += line+"\n";
            }
            System.out.println(ok);
            JSONObject json = new JSONObject(ok);
            api = json.getString("datos");
            System.out.println(api);
        } catch (Exception e){
            System.out.println(e);
        }

        try {
            URL url = new URL(api);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String response="";
            String line;
            while((line = in.readLine()) != null){
                response += line+"\n";
            }
            JSONArray json = new JSONArray(response);
            JSONObject raiz = json.getJSONObject(0);

            diaactual=raiz.getString("elaborado");
            System.out.println("Dia: "+diaactual);
            System.out.println(" ");

            JSONObject prediccion = raiz.getJSONObject("prediccion");
            JSONArray dia = prediccion.getJSONArray("dia");
            for(int i=0;i<3;i++){
                JSONObject num_dia = dia.getJSONObject(i);
                JSONArray cielo = num_dia.getJSONArray("estadoCielo");
                JSONObject tododia = cielo.getJSONObject(0);

                cielos[i]=tododia.getString("descripcion");

                JSONObject temp = num_dia.getJSONObject("temperatura");
                max[i]=temp.getInt("maxima");
                min[i]=temp.getInt("minima");
                System.out.println("Fecha: "+num_dia.getString("fecha"));
                System.out.println("Cielo: "+cielos[i]);
                System.out.println("Temperatura max: "+max[i]);
                System.out.println("Temperatura min: "+min[i]);
            }

        } catch (Exception e){
            System.out.println(e);
        }
        return cielos;
    }


}