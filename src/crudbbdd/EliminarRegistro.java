package crudbbdd;
import static crudbbdd.Conexion.conn;
import static crudbbdd.Conexion.rs;
import static crudbbdd.Conexion.stm;
import java.sql.*;

public class EliminarRegistro {
    
    public static boolean baja(int department_id) {

        try {
            stm = conn.createStatement();
            stm.executeUpdate("DELETE FROM departments WHERE department_id =" + department_id + ";");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

        return true;
    }
}
