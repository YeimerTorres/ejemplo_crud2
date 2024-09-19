/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo_crud2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author YEIMER
 */
public class agregar {
   public void agregarPersona(String nombre, String documento, String edad, String direccion, String telefono) throws SQLException {
        String sqlInsert = "INSERT INTO persona (nombre, documento, edad, direccion, telefono) VALUES (?, ?, ?, ?, ?)";
        try (Connection cn = new conexion().getConection();
             PreparedStatement pstmt = cn.prepareStatement(sqlInsert)) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, documento);
            pstmt.setString(3, edad);
            pstmt.setString(4, direccion);
            pstmt.setString(5, telefono);

            pstmt.executeUpdate();
            // su función es agregar nuevos registros a la base de datos
 }
}
}