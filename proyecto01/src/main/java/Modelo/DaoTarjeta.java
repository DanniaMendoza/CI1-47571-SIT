/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Conexion.Conectar;
import Conexion.Conexion;
import Entidades.Tarjeta;
import Entidades.roles;
import Entidades.usuarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class DaoTarjeta extends Conectar {
    
    
    
       public int add(Tarjeta t) {
        int resultado=0;
        String sql="insert into tarjetatransporte(CodigoTarjeta,Monto,Estado,ID_Usuario)values(?,?,?,?)";
        try {
            PreparedStatement ps=Conectar.getConexion().prepareStatement(sql);
            ps.setString(1, t.getCodigoTarjeta());
            ps.setDouble(2, t.getMonto());
            ps.setString(3, t.getEstado());
            ps.setInt(4, t.getUsuario().getId_usuario());
            resultado=ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error to add"+e );
        }
        return resultado;
    }
        
       
     public List<Tarjeta> getTarjetasP(int codigo) {
          List<Tarjeta>tarjetas=new ArrayList<>();
        String sql="SELECT * FROM tarjetatransporte WHERE ID_Usuario=?";
       
        try{
             PreparedStatement ps=Conectar.getConexion().prepareStatement(sql);
             ps.setInt(1, codigo);
             ResultSet rs=ps.executeQuery();
             while(rs.next()){
                 Tarjeta t= new Tarjeta();
                 t.setId_Tarjeta(rs.getInt(1));
                 t.setCodigoTarjeta(rs.getString(2));
                 t.setMonto(rs.getDouble(3));
                 t.setEstado(rs.getString(4));
                 t.setUsuario(new usuarios());
                 t.getUsuario().setId_usuario(rs.getInt(5));
                 tarjetas.add(t);
                 
             }
        } catch(Exception e){
            System.out.println("Error"+e);
        }
        return tarjetas;
    }  
     
     
     public Tarjeta getId(int id) {
        
         String sql="select * from tarjetatransporte where Id_Tarjeta=?";
         Tarjeta t= new Tarjeta();
         try{
             PreparedStatement ps=Conectar.getConexion().prepareStatement(sql);
             ps.setInt(1, id);
             ResultSet rs=ps.executeQuery();
             while(rs.next()){  
                 t.setId_Tarjeta(rs.getInt(1));
                 t.setCodigoTarjeta(rs.getString(2));
                 t.setMonto(rs.getDouble(3));
                 t.setEstado(rs.getString(4));
                 t.setUsuario(new usuarios());
                 t.getUsuario().setId_usuario(rs.getInt(5));
                
                 
             }
        } catch(Exception e){
            System.out.println("Error"+e);
        }
         return t;
         
      
    }
     
     
     
    public int addCarga(double monto,int idTa, LocalDate fecha) {
        int resultado=0;
        String sql="insert into carga(Monto,Id_Tarjeta,Fecha)values(?,?,?)";
        try {
            PreparedStatement ps=Conectar.getConexion().prepareStatement(sql);
            ps.setDouble(1,monto);
            ps.setInt(2, idTa);
            java.sql.Date sqlDate = java.sql.Date.valueOf(fecha);
            ps.setDate(3,sqlDate);
            resultado=ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error to add"+e );
        }
        return resultado;
    }
     
    
     public int updateTarjeta(int idTa,double monto){
     int resultado=0;
     String sql="UPDATE tarjetatransporte SET Monto=(Monto+?)WHERE Id_Tarjeta=?";
      try {
            PreparedStatement ps=Conectar.getConexion().prepareStatement(sql);
            ps.setDouble(1, monto);
            ps.setInt(2, idTa);
            resultado=ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error to add"+e );
        }
     
     
     return resultado;
     }
     
     
      public int updateTarjetaM(int idTa,double monto){
     int resultado=0;
     String sql="UPDATE tarjetatransporte SET Monto=(Monto-?)WHERE Id_Tarjeta=?";
      try {
            PreparedStatement ps=Conectar.getConexion().prepareStatement(sql);
            ps.setDouble(1, monto);
            ps.setInt(2, idTa);
            resultado=ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error to add"+e );
        }
     
     
     return resultado;
     }
    
}
