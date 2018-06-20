package com.atelem.vlc.upv.mor.eltiempo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class tiempo extends AppCompatActivity {
    private EditText Tiempo1,Tiempo2,Tiempo3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiempo);
            Tiempo1 = (EditText)findViewById(R.id.editText2);
            Tiempo2 = (EditText)findViewById(R.id.editText3);
            Tiempo3 = (EditText)findViewById(R.id.editText4);
        String NOMBRE = getIntent().getStringExtra("NOMBRE");
        System.out.println(NOMBRE);
        String Resultado[] = null;
        Resultado = new consultaAsincrona().execute(NOMBRE).get();
        String[] cielo = new String[12];
        System.out.print("cieloooooo;%s%n");
            Tiempo1.setText(Resultado[0]);
            Tiempo2.setText(Resultado[1]);
            Tiempo3.setText(Resultado[2]);


        } catch (Exception e) {

        }
    }



}
