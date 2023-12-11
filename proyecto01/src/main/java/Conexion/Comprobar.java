/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

/**
 *
 * @author usuario
 */
public class Comprobar {
    public static void main(String[] args){
        Conectar c= new Conectar();
        if(c.getConexion() != null){
            System.err.println("Conexion es correcta");
        }else{
            System.err.println("Conexion es incorrecta");
        }
    }
    
}
