
package Modelo;

import Conexion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Entidades.*;


public class DaoRol extends Conexion{

    public List<roles> listarRoles() throws Exception {
        List<roles> roles;
        roles rol;
        ResultSet rs = null;
        String sql = "SELECT ID_Rol, NombreRol, EstadoRol FROM Roles ORDER BY ID_Rol";

   
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);

            roles = new ArrayList<>();

            while (rs.next() == true) {
                rol = new roles();

                rol.setIdRol(rs.getInt("ID_Rol"));
                rol.setNombreRol(rs.getString("NombreRol"));
                rol.setEstadoRol(true);

                roles.add(rol);
            }
            this.cerrar(true);
        } catch (Exception e) {
            throw e;
        } finally {
        }
        return roles;
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
