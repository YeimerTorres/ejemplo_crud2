/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo_crud2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author YEIMER
 */

public class conexion {

    private Connection con;

    public conexion() {
        try {
            // Registra el driver JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establece la conexión a la base de datos
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/evidencia25", "root", "Cucuta2023 01@");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver no encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    public Connection getConection() {
        return con;
        // Su función es conectarse con la base de datos
}
}