/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conf;

import java.sql.Connection;
import java.sql.DriverManager;
import jdk.internal.org.jline.terminal.TerminalBuilder;

/**
 *
 * @author PC
 */
public class Conexion {
    
    Connection con;
    String url="jdbc:mysql://localhost:3306/sit";
    String user="root";
    String pass="";
    public Connection Conexion(){
        try{
            Class.forName("com.mysql.jbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
            System.out.println("Conexion aceptada");
            
        }catch(Exception e){
            
        }
       return con; 
    }
    
    
}
