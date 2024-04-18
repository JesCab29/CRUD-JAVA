package crudbbdd;
import java.sql.*;
public class Conexion {
    
    public static Connection conn = null;
    public static Statement stm = null;
    public static ResultSet rs = null;

    public static boolean conectar(String url, String user, String password) {

        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            return false;
        }

        return true;
    }

    public static boolean desconectar() {

        try {
            conn.close();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }
}
