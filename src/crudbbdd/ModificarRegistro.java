package crudbbdd;

import static crudbbdd.Conexion.conn;
import static crudbbdd.Conexion.rs;
import static crudbbdd.Conexion.stm;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author JesusCabral
 */
public class ModificarRegistro {

    public static boolean modificar(int department_id) {
        try {

            Scanner sc = new Scanner(System.in);
            stm = conn.createStatement();
            rs = stm.executeQuery("SELECT department_name FROM departments WHERE department_id=" + department_id + ";");

            while (rs.next()) {
                System.out.println("department_name: " + rs.getString(1) + " ");
            }

            System.out.println("¿Quiere modificar esta columna?S/N");
            String comp = sc.next();

            if (comp.equalsIgnoreCase("S")) {
                Scanner sc2 = new Scanner(System.in);
                System.out.println("Escriba el nuevo nombre del registro: ");
                String nuevoNombre = sc2.nextLine();
                stm.executeUpdate("UPDATE departments SET department_name=\"" + nuevoNombre + "\" WHERE department_id =" + department_id + ";");
            }

            rs = stm.executeQuery("SELECT location_id FROM departments WHERE department_id=" + department_id + ";");
            while (rs.next()) {
                System.out.println("location_id: " + rs.getInt(1) + " ");
            }

            System.out.println("¿Quiere modificar esta columna?S/N");
            String comp2 = sc.next();

            if (comp2.equalsIgnoreCase("S")) {
                System.out.println("Escriba el numero de localización del registro: ");
                int nuevaLoc = sc.nextInt();
                stm.executeUpdate("UPDATE departments SET location_id=" + nuevaLoc + " WHERE department_id =" + department_id + ";");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

        return true;
    }

}
