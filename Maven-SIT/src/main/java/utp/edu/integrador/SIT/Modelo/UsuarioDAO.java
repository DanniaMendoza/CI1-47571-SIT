package utp.edu.integrador.SIT.Modelo;

import utp.edu.integrador.SIT.Conexion.Conexion;
import utp.edu.integrador.SIT.Entidades.Usuario;
//import Entidad.Rol;
//import Entidad.Usuario;
import com.mysql.cj.xdevapi.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
//import utilitarios.Conexion;

public class UsuarioDAO extends Conexion {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    Usuario usu = new Usuario(); //crear objeto usuario
    public List listar(){
        System.out.println("Llego al listado del DAO");
        ArrayList<Usuario> list=new ArrayList();
        String sql="SELECT * FROM `usuario`";
        try{
            con=cn.getConexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Usuario u=new Usuario();
                u.setId(rs.getInt("id"));
                u.setNombre(rs.getString("nombre"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setRol(rs.getString("rol"));
                u.setEstado(rs.getInt("estado"));
                list.add(u);
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return list;
    }
    /*public Usuario identificar(String email, String clave) throws Exception {
        Usuario usu = null;
        ResultSet rs = null;

        String sql = "select p.idPersona, p.Nombre, u.Correo, u.idRol , r.nom_rol\n"
                + "FROM persona p INNER JOIN usuario u \n"
                + "ON u.idPersona = p.idPersona\n"
                + "inner join rol r\n"
                + "on u.idRol = r.idRol\n"
                + "WHERE u.Correo = ? AND u.Clave = ? ";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, clave);
            rs = ps.executeQuery();                       
            if (rs.next()) {
                usu = new Usuario();
                usu.setIdPersona(rs.getInt("idPersona"));
                usu.setNombrePersona(rs.getString("Nombre"));
                usu.setCorreo(rs.getString("Correo"));
                usu.setIdRol(rs.getInt("idRol"));
                usu.setNombreRol(rs.getString("nom_rol"));
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return usu;
        
    }

    public List<Usuario> listarUsuarios() throws Exception {
        List<Usuario> usuarios;
        Usuario usu;
        ResultSet rs = null;
        String sql = "SELECT usuario.idUsuario, usuario.Correo, usuario.clave, usuario.estado, rol.nom_rol "
                + "FROM usuario "
                + "INNER JOIN rol ON rol.idRol=usuario.idRol";

        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);

            usuarios = new ArrayList<>();

            while (rs.next() == true) {
                usu = new Usuario();
                usu.setCodUsuario(rs.getInt("idUsuario"));
                usu.setCorreo(rs.getString("Correo"));
                usu.setClave(rs.getString("clave"));
                //usu.setEstado(rs.getBoolean("estado"));
               // usu.setRol(new Rol());
               // usu.getRol().setNombreRol(rs.getString("nom_rol"));

                usuarios.add(usu);
            }
            this.cerrar(true);
        } catch (Exception e) {
            throw e;
        } finally {
        }
        return usuarios;
    }

    public void registrarUsuarios(Usuario usu) throws Exception {
        String sql;
        sql = "INSERT INTO Usuario (Correo, Clave, Estado, idPersona, idRol) ";
              //  + "VALUES ('" + usu.getCorreo() + "', '"
                //+ usu.getClave() + "', "
                //+ (usu.isEstado() == true ? "1" : "0")
               // + ", " + usu.getPersona().getCodPersona()
               // + ", " + usu.getRol().getCodigoRol() + ")";
        try {
            this.conectar(false);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }

    public Usuario leerUsuario(Usuario usu) throws Exception {
        Usuario usus = null;
        ResultSet rs = null;
        String sql = "SELECT usuario.idUsuario, "
                + "usuario.Correo, "
                + "usuario.Clave, "
                + "usuario.estado, "
                //+ "usuario.idPersona, "
                + "usuario.idRol "
                + "FROM usuario "
                + "where usuario.idUsuario = " + usu.getCodUsuario();

        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);

            if (rs.next() == true) {
                usus = new Usuario();
                usus.setCodUsuario(rs.getInt("idUsuario"));
                usus.setCorreo(rs.getString("Correo"));
                usus.setClave(rs.getString("Clave"));
               // usus.setEstado(rs.getBoolean("estado"));

                /*usus.setPersona(new persona());
                //usus.getPersona().setIdPersona(rs.getInt("idPersona"));
               // usus.setRol(new Rol());
               // usus.getRol().setCodigoRol(rs.getInt("idRol"));
            }
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        } finally {
        }
        return usus;
    }

    public void actualizarUsuarios(Usuario usu) throws Exception {
        String sql = "UPDATE usuario SET "
                + "usuario.Correo = '" + usu.getCorreo() + "', "
                + "usuario.Clave = '" + usu.getClave() + "', "
                //+ "usuario.Estado = " + (usu.isEstado() == true ? "1" : "0") + ", "
               // + "usuario.idRol = " + usu.getRol().getCodigoRol() + " "
                + "WHERE usuario.idUsuario = " + usu.getCodUsuario();
        try {
            this.conectar(false);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }

    public void eliminarUsuario(Usuario usu) throws Exception {
        String sql = "DELETE FROM USUARIO"
                + " WHERE IDUSUARIO = " + usu.getCodUsuario();

        try {
            this.conectar(false);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }

    public void cambiarEstado(Usuario usus) throws Exception {
        String sql = "UPDATE usuario SET estado = "
                //+ (usus.isEstado() == true ? "1" : "0")
                + " WHERE idusuario = " + usus.getCodUsuario();
        try {
            this.conectar(false);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }*/

}
