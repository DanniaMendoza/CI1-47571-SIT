package Modelo;

import Conexion.Conexion;
import Entidades.usuarios;
import Entidades.roles;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoUsuario extends Conexion {

    public usuarios identificar(usuarios user) throws Exception {
        usuarios usu = null;
        ResultSet rs = null;

        String sql = "SELECT U.ID_Usuario, R.NombreRol, U.NombreUsuario "
                + "FROM Usuarios U "
                + "INNER JOIN Roles R ON U.ID_Rol = R.ID_Rol "
                + "WHERE U.EstadoUsuario = 1 AND U.DNI = '" + user.getDni() + "' AND U.ClaveUsuario = '" + user.getClave() + "'";

        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);
            if (rs.next()) {
                usu = new usuarios();
                usu.setId_usuario(rs.getInt("ID_Usuario"));
                usu.setDni(user.getDni());
                usu.setNombreUsuario(rs.getString("NombreUsuario"));
                usu.setRol(new roles());
                usu.getRol().setNombreRol(rs.getString("NombreRol"));
                usu.setEstado(true);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        } finally {
            this.cerrar(false);
        }
        return usu;

    }

    public List<usuarios> listarUsuarios() throws Exception {
        List<usuarios> usuarios;
        usuarios usu;
        ResultSet rs = null;
        String sql = "SELECT U.ID_Usuario, R.NombreRol, U.NombreUsuario,  U.ApellidoPaterno, U.ApellidoMaterno, U.DNI, U.CorreoElectronico, U.ClaveUsuario, U.NumeroTelefono, U.EstadoUsuario "
                + "FROM Usuarios U "
                + "INNER JOIN Roles R ON U.ID_Rol = R.ID_Rol";

        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);

            usuarios = new ArrayList<>();

            while (rs.next() == true) {
                usu = new usuarios();
                usu.setId_usuario(rs.getInt("ID_Usuario"));
                usu.setNombreUsuario(rs.getString("NombreUsuario"));
                usu.setApellidoPaterno(rs.getString("ApellidoPaterno"));
                usu.setApellidoMaterno(rs.getString("ApellidoMaterno"));

                usu.setRol(new roles());
                usu.getRol().setNombreRol(rs.getString("NombreRol"));

                usu.setDni(rs.getString("DNI"));
                usu.setCorreo(rs.getString("CorreoElectronico"));
                usu.setTelefono(rs.getString("NumeroTelefono"));
                usu.setClave(rs.getString("ClaveUsuario"));
                usu.setEstado(true);

                usuarios.add(usu);
            }
            this.cerrar(true);
        } catch (Exception e) {
            throw e;
        } finally {
        }
        return usuarios;
    }

    public void registrarUsuario(usuarios usu) throws Exception {
        String sql;
        sql = "INSERT INTO Usuarios (NombreUsuario, ApellidoPaterno, ApellidoMaterno, DNI, CorreoElectronico, NumeroTelefono, ClaveUsuario, EstadoUsuario, ID_Rol) "
                + "VALUES ('" + usu.getNombreUsuario() + "','"
                + usu.getApellidoPaterno() + "','"
                + usu.getApellidoMaterno() + "','"
                + usu.getDni() + "','"
                + usu.getCorreo() + "','"
                + usu.getTelefono() + "','"
                + usu.getClave() + "',"
                + (usu.isEstado() ? "1" : "0") + ","
                + usu.getRol().getIdRol() + ")";
        

        try {
            this.conectar(false);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }

    public usuarios leerUsuario(usuarios usu) throws Exception {
        usuarios usus = null;
        ResultSet rs = null;

        String sql = "SELECT U.ID_Usuario, R.ID_Rol, U.NombreUsuario,  U.ApellidoPaterno, U.ApellidoMaterno, U.DNI, U.CorreoElectronico, U.NumeroTelefono, U.ClaveUsuario, U.EstadoUsuario FROM Usuarios U INNER JOIN Roles R ON U.ID_Rol = R.ID_Rol WHERE U.ID_Usuario = " + usu.getId_usuario();

        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);

            if (rs.next() == true) {
                usus = new usuarios();
                usus.setId_usuario(rs.getInt("ID_Usuario"));
                usus.setRol(new roles());
                usus.getRol().setIdRol(rs.getInt("ID_Rol"));
                usus.setNombreUsuario(rs.getString("NombreUsuario"));
                usus.setApellidoPaterno(rs.getString("ApellidoPaterno"));
                usus.setApellidoMaterno(rs.getString("ApellidoMaterno"));
                usus.setDni(rs.getString("DNI"));
                usus.setCorreo(rs.getString("CorreoElectronico"));
                usus.setTelefono(rs.getString("NumeroTelefono"));
                usus.setClave(rs.getString("ClaveUsuario"));
                usus.setEstado(rs.getBoolean("EstadoUsuario"));
            }
            this.cerrar(true);
        } catch (Exception e) {
            throw e;
        } finally {
        }
        return usus;
    }

    public void actualizarUsuarios(usuarios usu) throws Exception {
        String sql = "UPDATE usuarios SET NombreUsuario = '"
                + usu.getNombreUsuario() + "', ApellidoPaterno = '"
                + usu.getApellidoPaterno() + "', ApellidoMaterno = '"
                + usu.getApellidoMaterno() + "', DNI = '"
                + usu.getDni() + "', CorreoElectronico = '"
                + usu.getCorreo() + "', NumeroTelefono = '"
                + usu.getTelefono() + "', ClaveUsuario = '"
                + usu.getClave() + "'  WHERE ID_Usuario = " + usu.getId_usuario();

        try {
            this.conectar(false);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }

    public void eliminarUsuario(usuarios usu) throws Exception {
        String sql = "DELETE FROM USUARIOS"
                + " WHERE ID_USUARIO = " + usu.getId_usuario();

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
