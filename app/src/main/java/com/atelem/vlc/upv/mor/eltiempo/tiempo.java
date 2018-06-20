package com.atelem.vlc.upv.mor.eltiempo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class tiempo extends AppCompatActivity {
    //private EditText Tiempo1,Tiempo2,Tiempo3;
    private TextView Tiempo1,Tiempo11,Tiempo12,Tiempo13,Tiempo3,Tiempo31,Tiempo32,Tiempo33,Tiempo4,Tiempo41,Tiempo42,Tiempo43,cielo1,cielo3,cielo4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tiempo);
            Tiempo1 = findViewById(R.id.textView1);
            Tiempo11 = findViewById(R.id.textView11);
            Tiempo12 = findViewById(R.id.textView12);
            Tiempo13 = findViewById(R.id.textView13);
            Tiempo3 = findViewById(R.id.textView3);
            Tiempo31 = findViewById(R.id.textView31);
            Tiempo32 = findViewById(R.id.textView32);
            Tiempo33 = findViewById(R.id.textView33);
            Tiempo4 = findViewById(R.id.textView4);
            Tiempo41 = findViewById(R.id.textView41);
            Tiempo42 = findViewById(R.id.textView42);
            Tiempo43 = findViewById(R.id.textView43);
            /*
            dia1 = findViewById(R.id.textView5);
            dia3 = findViewById(R.id.textView6);
            dia4 = findViewById(R.id.textView7);
            */
            cielo1 = findViewById(R.id.textView5);
            cielo3 = findViewById(R.id.textView6);
            cielo4 = findViewById(R.id.textView7);
            /*
            max1 = findViewById(R.id.textView5);
            max3 = findViewById(R.id.textView6);
            max4 = findViewById(R.id.textView7);

            min1 = findViewById(R.id.textView5);
            min3 = findViewById(R.id.textView6);
            min4 = findViewById(R.id.textView7);
            */
            String NOMBRE = getIntent().getStringExtra("NOMBRE");
            System.out.println(NOMBRE);
            String Resultado[] = null;
            Resultado = new consultaAsincrona().execute(NOMBRE).get();
            String[] cielo = new String[12];
            System.out.print("cieloooooo;%s%n");

            // Mensajes constantes
            String mensaje_dia="El tiempo del dia:";
            String mensaje_cielo="El cielo está:";
            String mensaje_max="La máxima es:";
            String mensaje_min="La mínima es:";
            Tiempo1.setText(mensaje_dia);
            Tiempo11.setText(mensaje_cielo);
            Tiempo12.setText(mensaje_max);
            Tiempo13.setText(mensaje_min);
            Tiempo3.setText(mensaje_dia);
            Tiempo31.setText(mensaje_cielo);
            Tiempo32.setText(mensaje_max);
            Tiempo33.setText(mensaje_min);
            Tiempo4.setText(mensaje_dia);
            Tiempo41.setText(mensaje_cielo);
            Tiempo42.setText(mensaje_max);
            Tiempo43.setText(mensaje_min);

            // Valores DIA,CIELO,MAX,MIN
            cielo1.setText(Resultado[0]);
            cielo3.setText(Resultado[1]);
            cielo4.setText(Resultado[2]);


        } catch (Exception e) {

        }
    }



}