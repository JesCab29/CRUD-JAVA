package crudbbdd;
import java.sql.*;
import java.util.Scanner;
import 

public class DesarrolloAplicacion {

    //App que me permita hacer gestionar departamentos//
    /*Que tenga un menu con:
    1. Alta departamento --> Comprobar que el id no esta ya en uso.
    2. Modificar departamento
    3. Eliminar departamento
    4. Listar departamentos añadir que se guard el resultado en un fichero.
    */
    public static void main(String[] args) {

        String nombre_dept;
        int localidad;
        int codigo;
        int codModificacion = 0;

        int opc = 0;

        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("""
                                   Menu de departamentos
                                   1. Alta
                                   2. Modificar registro
                                   3. Baja
                                   4. Listado
                                   5. Salir
                                   """);

                System.out.println("Seleccione una opción: ");
                opc = sc.nextInt();

                switch (opc) {
                    case 1:
                        Scanner sc2 = new Scanner(System.in);
                        System.out.println("Introduzca el nombre del departamento: ");
                        nombre_dept = sc2.nextLine();
                        System.out.println("Introduzca el número de localidad del departamento: ");
                        localidad = sc2.nextInt();
                        Conexion.conectar("jdbc:mysql://127.0.0.1:3306/empresa", "root", "alumno");
                        FeatureAnadirRegistro.alta(nombre_dept, localidad);
                        Conexion.desconectar();

                        break;

                    case 2:

                        System.out.println("Introducir el codigo de departamento que quiere modificar: ");
                        codModificacion = sc.nextInt();
                        Conexion.conectar("jdbc:mysql://127.0.0.1:3306/empresa", "root", "alumno");
                        ModificarRegistro.modificar(codModificacion);
                        Conexion.desconectar();

                        break;

                    case 3:
                        System.out.println("Introduzca el codigo del departamento a eliminar: ");
                        codigo = sc.nextInt();
                        Conexion.conectar("jdbc:mysql://127.0.0.1:3306/empresa", "root", "alumno");
                        EliminarRegistro.baja(codigo);
                        Conexion.desconectar();

                        break;

                    case 4:
                        Conexion.conectar("jdbc:mysql://127.0.0.1:3306/empresa", "root", "alumno");
                        ListarRegistros.listar();
                        Conexion.desconectar();

                        break;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Opción no valida.");
            }

        } while (opc != 5);

    }
}