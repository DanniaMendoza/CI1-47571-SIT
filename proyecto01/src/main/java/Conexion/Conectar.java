/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author usuario
 */
public class Conectar {
     public static Connection getConexion(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/transporteaqpbackup","root","");
            System.out.println("Conexion Satisfactoria");
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return con;
    }
    
    
    
    
}


