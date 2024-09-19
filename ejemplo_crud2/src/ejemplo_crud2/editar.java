/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo_crud2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author YEIMER
 */

public class editar {

    private Connection conexion;

    // Constructor de la clase, donde inicializamos la conexión
    public editar() {
        try {
            // Reemplaza estos valores con los de tu base de datos
           Class.forName("com.mysql.cj.jdbc.Driver");
            // Establece la conexión a la base de datos
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/evidencia25", "root", "Cucuta202301@");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver no encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    
    

    public void editarPersona(int id, String nombre, String documento, String edad, String direccion, String telefono) throws SQLException {
        // Crear una consulta SQL para actualizar la persona
        String sql = "UPDATE persona SET nombre = COALESCE(NULLIF(?, ''), nombre), " +
                     "documento = COALESCE(NULLIF(?, ''), documento), " +
                     "edad = COALESCE(NULLIF(?, ''), edad), " +
                     "direccion = COALESCE(NULLIF(?, ''), direccion), " +
                     "telefono = COALESCE(NULLIF(?, ''), telefono) " +
                     "WHERE id = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, documento);
            stmt.setString(3, edad);
            stmt.setString(4, direccion);
            stmt.setString(5, telefono);
            stmt.setInt(6, id);

            stmt.executeUpdate();
        }
    }

    // Método para cerrar la conexión cuando ya no sea necesaria
    public void close() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión a la base de datos: " + e.getMessage());
            // Su función es editar registros de la base de datos
 }
}
}