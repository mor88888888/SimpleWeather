package com.atelem.vlc.upv.mor.eltiempo;

import java.sql.*;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText Poblacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public Array [] Consulta (View view){
        Poblacion = findViewById(R.id.editText);
        Log.d("busqueda", String.valueOf(Poblacion));
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        }
        catch(Exception e){
            System.out.println("Error abriendo el driver: " +e.toString());
        }

        //INICIALIZACIONES Y DEFINICIONES
        Connection con;
        Statement st;
        ResultSet rs;
        String SQL="SELECT CPRO, CMUN, NOMBRE FROM ElTiempo Where='" +Poblacion+"'";
        Array [] out=new Array[20];


        //CONEXIONES
        try {
            con = DriverManager.getConnection("jdbc:mysql://servermor.asucomm.com:1562/eltiempo", "root", "mor");
            st = con.createStatement();
            rs = st.executeQuery(SQL);
            for(int i=0;rs.next();i++){
                out[i] = rs.getArray(i);
            }
        } catch (SQLException e){
            System.out.println(e);
        }
        return out;
    }
}
