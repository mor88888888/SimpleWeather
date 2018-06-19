package com.atelem.vlc.upv.mor.eltiempo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText Poblacion;
    String response="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Poblacion = (EditText)findViewById(R.id.editText);
    }

    consultaAsincrona consulta = new consultaAsincrona();

    public void Consulta (View view) {

        String NOMBRE = Poblacion.getText().toString();
        consulta.execute(NOMBRE);
        //System.out.println("Respuesta: "+consulta.onPostExecute());
    }

    protected void printMain(String str) {
        response=str;
        System.out.println("Respuesta: "+response);
    }

}
