package Modelo;

import Conexion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Entidades.*;

public class DaoTransporte extends Conexion {

    public List<transporte> listarTransporte() throws Exception {
        List<transporte> vehiculo;
        transporte transpor;
        ResultSet rs = null;
        String sql = "SELECT V.ID_Vehiculo, V.ID_Conductor, U.NombreUsuario, V.Marca, V.Modelo, V.Anio, V.NumeroPlaca, V.Empresa, V.Estado FROM Vehiculos AS V INNER JOIN Usuarios AS U ON V.ID_Conductor = U.ID_Usuario";

        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);

            vehiculo = new ArrayList<>();

            while (rs.next() == true) {
                transpor = new transporte();

                transpor.setId_Vehiculo(rs.getInt("ID_Vehiculo"));

                transpor.setId_Conductor(new usuarios());
                transpor.getId_Conductor().setNombreUsuario(rs.getString("NombreUsuario"));
                transpor.getId_Conductor().setId_usuario(rs.getInt("ID_Conductor"));

                transpor.setMarca(rs.getString("Marca"));
                transpor.setModelo(rs.getString("Modelo"));
                transpor.setAnio(rs.getInt("Anio"));
                transpor.setNumeroPlaca(rs.getString("NumeroPlaca"));
                transpor.setEstadoMantenimiento(rs.getString("Empresa"));
                transpor.setEstado(true);

                vehiculo.add(transpor);
            }
            this.cerrar(true);
        } catch (Exception e) {
            throw e;
        } finally {
        }
        return vehiculo;
    }

    public void registrarVehiculo(transporte vehiculo) throws Exception {
        String sql;
        sql = "INSERT INTO Usuarios (ID_Vehiculo, ID_Conductor, Marca, Modelo, Anio, NumeroPlaca, Empresa, Estado) "
                + "VALUES ('" + vehiculo.getId_Vehiculo() + "','"
                + vehiculo.getId_Vehiculo()+ "','"
                + vehiculo.getMarca() + "','"
                + vehiculo.getModelo() + "',"
                + vehiculo.getAnio() + ",'"
                + vehiculo.getNumeroPlaca() + "','"
                + vehiculo.getEstadoMantenimiento() + "',"
                + (vehiculo.isEstado()? "1" : "0")+ ")";

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
