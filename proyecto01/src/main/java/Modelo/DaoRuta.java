/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.Conectar;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Entidades.*;
import java.sql.PreparedStatement;

public class DaoRuta extends Conexion{

    public List<rutas> listarRutas() throws Exception {
        List<rutas> listaRuta;
        rutas objRuta;
        ResultSet rs = null;
        String sql = "SELECT ID_Ruta, Origen, Destino, Distancia, TiempoEstimadoViaje, tarifa, EstadoRutas FROM rutas ORDER BY ID_Ruta";

   
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);

            listaRuta = new ArrayList<>();

            while (rs.next() == true) {
                objRuta = new rutas();

                objRuta.setId_ruta(rs.getInt("ID_Ruta"));
                
                objRuta.setOrigen(rs.getString("Origen"));
                objRuta.setDestino(rs.getString("Destino"));
                objRuta.setDistancia(rs.getInt("Distancia"));
                objRuta.setTiempo(rs.getInt("TiempoEstimadoViaje"));
                objRuta.setTarifa(rs.getInt("tarifa"));
                objRuta.setEstado(true);

                listaRuta.add(objRuta);
            }
            this.cerrar(true);
        } catch (Exception e) {
            throw e;
        } finally {
        }
        return listaRuta;
    }
    public rutas getId(int id) {
        
         String sql="select * from rutas where ID_Ruta=?";
         rutas ru=new rutas();
         try{
             PreparedStatement ps=Conectar.getConexion().prepareStatement(sql);
             ps.setInt(1, id);
             ResultSet rs=ps.executeQuery();
             while(rs.next()){  
                 ru.setId_ruta(rs.getInt(1));
                 ru.setOrigen(rs.getString(2));
                 ru.setDestino(rs.getString(3));
                 ru.setDistancia(rs.getFloat(4));
                 ru.setTiempo(rs.getInt(5));
                 ru.setEstado(rs.getBoolean(6));
                 ru.setTarifa(rs.getDouble(7));
                
                 
             }
        } catch(Exception e){
            System.out.println("Error"+e);
        }
         return ru; 
    }
    
       public void registrarRol(roles rol) throws Exception {
        String sql;
        sql = "INSERT INTO Roles (NombreRol, EstadoRol) "
                + "VALUES ('" + rol.getNombreRol()+ "',"
                + rol.isEstadoRol() + ")";

        try {
            this.conectar(false);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }

    }

}
