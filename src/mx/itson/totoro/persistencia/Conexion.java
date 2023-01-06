/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.totoro.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Alejandra Medina
 */
public class Conexion {
    
    public Connection obtener(){
        Connection Conexion = null;
        try{
            Conexion = DriverManager.getConnection("jdbc:mysql://localhost/totorodb?user=root&password=Poke6470");
        }catch(Exception e){
            System.err.println("Ocurrio un error: "+e.getMessage());
        }
        return Conexion;
    }
    
}
