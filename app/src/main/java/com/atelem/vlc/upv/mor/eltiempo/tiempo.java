package com.atelem.vlc.upv.mor.eltiempo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class tiempo extends AppCompatActivity {
    //private EditText Tiempo1,Tiempo2,Tiempo3;
    private TextView Tiempo1,Tiempo2,Tiempo3,Tiempo4,Tiempo5,Tiempo6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tiempo);
            Tiempo1 = findViewById(R.id.textView1);
            Tiempo2 = findViewById(R.id.textView3);
            Tiempo3 = findViewById(R.id.textView4);
            Tiempo4 = findViewById(R.id.textView5);
            Tiempo5 = findViewById(R.id.textView6);
            Tiempo6 = findViewById(R.id.textView7);
            //Tiempo2 = (TextView) findViewById(R.id.textView);
            String NOMBRE = getIntent().getStringExtra("NOMBRE");
            System.out.println(NOMBRE);
            String Resultado[] = null;
            Resultado = new consultaAsincrona().execute(NOMBRE).get();
            String[] cielo = new String[12];
            System.out.print("cieloooooo;%s%n");
            Tiempo1.setText("El tiempo del dia:");
            Tiempo1.setText("El tiempo del dia:");
            Tiempo1.setText("El tiempo del dia:");
            Tiempo4.setText(Resultado[0]);
            Tiempo5.setText(Resultado[1]);
            Tiempo6.setText(Resultado[2]);


        } catch (Exception e) {

        }
    }



}