package com.atelem.vlc.upv.mor.eltiempo;

import java.sql.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

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
        }

        //INICIALIZACIONES Y DEFINICIONES
        Connection con;
        Statement st;
        ResultSet rs;
        String SQL="SELECT CPRO,CMUN, NOMBRE FROM ElTiempo Where='" +Poblacion+"'";
        String [] out=new String[20];


            //CONEXIONES
        try {
            con = DriverManager.getConnection("jdbc:mysql://servermor.asucomm.com:1562/eltiempo", "root", "mor");
            st = con.createStatement();
            rs = st.executeQuery(SQL);
            for(int i=0;rs.next();i++){
                out[i] = rs.getString(i);
            }
        } catch (SQLException e){
            System.out.println(e);
        }
        return out;
    }
    //Private string Poblacion;
}
