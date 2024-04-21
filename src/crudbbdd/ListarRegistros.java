package crudbbdd;
import static crudbbdd.Conexion.conn;
import static crudbbdd.Conexion.rs;
import static crudbbdd.Conexion.stm;

public class ListarRegistros {
     public static boolean listar() {

        String cadena = "";

        try {
            stm = conn.createStatement();
            rs = stm.executeQuery("SELECT * FROM departments");

            while (rs.next()) {
                System.out.print(rs.getInt(1) + " ");
                System.out.print(rs.getString(2) + " ");
                System.out.print(rs.getInt(3) + "\n");

                cadena += (rs.getInt(1) + " ");
                cadena += (rs.getString(2) + " ");
                cadena += (rs.getInt(3) + "\n");

                File f = new File("listado.txt");
                try ( FileWriter fw = new FileWriter(f);  BufferedWriter bw = new BufferedWriter(fw);) {

                    bw.write(cadena);

                } catch (Exception e) {
                }

            }
}


