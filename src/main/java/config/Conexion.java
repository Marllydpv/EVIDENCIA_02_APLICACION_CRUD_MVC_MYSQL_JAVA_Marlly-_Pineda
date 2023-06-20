package config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Conexion
 */
public class Conexion {
    // Atributos  para la conexion
    private static final String bbdd="jdbc:mysql://localhost:3306/proyectos_java";
    private static final String usuario="root";
    private static final String clave="";
    private static Connection con;

    public static Connection conectar() {
        try {
            // Invocar manager-permite la conexion - 19
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(bbdd, usuario, clave);
            System.out.print("conexión Exitosa");
        } catch (Exception e) {
            System.out.print("Error de conexión a la base de datos "+e.getMessage().toString());
        }
        return con;
    }
    public static void main(String[] args) {
        Conexion.conectar(); 
    }


}