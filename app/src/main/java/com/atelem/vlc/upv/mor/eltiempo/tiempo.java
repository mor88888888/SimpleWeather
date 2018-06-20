package com.atelem.vlc.upv.mor.eltiempo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class tiempo extends AppCompatActivity {
    //private EditText Tiempo1,Tiempo2,Tiempo3;
    private TextView Tiempo1,Tiempo11,Tiempo12,Tiempo13,Tiempo3,Tiempo31,Tiempo32,Tiempo33,Tiempo4,Tiempo41,Tiempo42,Tiempo43,fecha1,fecha3,fecha4,cielo1,cielo3,cielo4,max1,max3,max4,min1,min3,min4;
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

            fecha1 = findViewById(R.id.fecha1);
            fecha3 = findViewById(R.id.fecha3);
            fecha4 = findViewById(R.id.fecha4);

            cielo1 = findViewById(R.id.cielo1);
            cielo3 = findViewById(R.id.cielo3);
            cielo4 = findViewById(R.id.cielo4);

            max1 = findViewById(R.id.max1);
            max3 = findViewById(R.id.max3);
            max4 = findViewById(R.id.max4);

            min1 = findViewById(R.id.min1);
            min3 = findViewById(R.id.min3);
            min4 = findViewById(R.id.min4);

            String NOMBRE = getIntent().getStringExtra("NOMBRE");
            System.out.println(NOMBRE);
            String Resultado[] = null;
            Resultado = new consultaAsincrona().execute(NOMBRE).get();

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
            fecha1.setText(Resultado[0]);
            fecha3.setText(Resultado[1]);
            fecha4.setText(Resultado[2]);
            cielo1.setText(Resultado[3]);
            cielo3.setText(Resultado[4]);
            cielo4.setText(Resultado[5]);
            max1.setText(Resultado[6]);
            max3.setText(Resultado[7]);
            max4.setText(Resultado[8]);
            min1.setText(Resultado[9]);
            min3.setText(Resultado[10]);
            min4.setText(Resultado[11]);


        } catch (Exception e) {

        }
    }



}