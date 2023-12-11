package Modelo;

import Conexion.Conexion;
import Entidades.ServiciosViaje;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DaoHistorialViajes extends Conexion {

    public List<ServiciosViaje> obtenerHistorialPorFecha(Date desde, Date hasta) throws Exception {
        List<ServiciosViaje> historialViajes = new ArrayList<>();
        ResultSet rs = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sql = "SELECT * FROM historialviajes WHERE FechaHora BETWEEN '"
                + dateFormat.format(desde) + "' AND '" + dateFormat.format(hasta) + "'";
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);

            while (rs.next()) {
                ServiciosViaje viaje = new ServiciosViaje();
                viaje.setId_viaje(rs.getInt("ID_Viaje"));
                viaje.setId_pasajero(rs.getInt("ID_Pasajero"));
                viaje.setId_conductor(rs.getInt("ID_Conductor"));
                viaje.setId_ruta(rs.getInt("ID_Ruta"));
                viaje.setFecha(rs.getDate("FechaHora"));
                viaje.setEstadoviaje(rs.getString("EstadoViaje"));
                viaje.setTarifa(rs.getFloat("Tarifas"));

                historialViajes.add(viaje);
            }
            this.cerrar(true);
        } catch (Exception e) {
            throw e;
        }
        return historialViajes;
    }

    public List<ServiciosViaje> obtenerHistorialPorIdPasajero(int idPasajero) {
        List<ServiciosViaje> historialViajes = new ArrayList<>();
        ResultSet rs = null;
        String sql = "SELECT * FROM historialviajes WHERE ID_Pasajero = " + idPasajero;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);

            while (rs.next()) {
                ServiciosViaje viaje = new ServiciosViaje();
                viaje.setId_viaje(rs.getInt("ID_Viaje"));
                viaje.setId_pasajero(rs.getInt("ID_Pasajero"));
                viaje.setId_conductor(rs.getInt("ID_Conductor"));
                viaje.setId_ruta(rs.getInt("ID_Ruta"));
                viaje.setFecha(rs.getDate("FechaHora"));
                viaje.setEstadoviaje(rs.getString("EstadoViaje"));
                viaje.setTarifa(rs.getFloat("Tarifas"));

                historialViajes.add(viaje);
            }
            this.cerrar(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return historialViajes;
    }

}
