
package utp.edu.integrador.SIT.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Jakheline Dannia Mendoza Hancco
 */
public class Conexion {
    public static Connection getConexion(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_sit","root","");
            System.out.println("Conexion Satisfactoria");
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return con;
    }
}
