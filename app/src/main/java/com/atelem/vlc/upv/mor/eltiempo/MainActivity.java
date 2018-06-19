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

    public void Consulta (View view) {
        consultaAsincrona consulta = new consultaAsincrona();
        String NOMBRE = Poblacion.getText().toString();
        consulta.execute(NOMBRE);
    }

}
