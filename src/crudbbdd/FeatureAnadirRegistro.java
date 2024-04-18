package crudbbdd;

import java.sql.*;

public class FeatureAnadirRegistro {
    
     public static boolean alta(String department_name, int location_id) {

        //Cuidado con las comillas que debe llevar una variable varchar en los comandos mysql//
        try {
            Conexion.stm = Conexion.conn.createStatement();
            Conexion.stm.executeUpdate("INSERT INTO departments(department_name,location_id) VALUES (\"" + department_name + "\"," + location_id + ");");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

        return true;
    }
    
    
}
