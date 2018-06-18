package com.atelem.vlc.upv.mor.eltiempo;

import java.sql.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public String [] Consulta (String Ciudad){
        EditText Poblacion = (EditText) findViewById(R.id.editText);

        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e){
            System.out.println("Error abriendo el driver: " +e.toString());
            return;
        }

            //INICIALIZACIONES Y DEFINICIONES
            Connection con;
            Statement st;
            ResultSet rs;
            String SQL;


            //CONEXIONES
            con=DriverManager.getConnection("jdbc:mysql://servermor.asucomm.com/eltiempo","root","mor");

            st = con.createStatement();

            out = res.getWriter();



    }
    //Private string Poblacion;
}
