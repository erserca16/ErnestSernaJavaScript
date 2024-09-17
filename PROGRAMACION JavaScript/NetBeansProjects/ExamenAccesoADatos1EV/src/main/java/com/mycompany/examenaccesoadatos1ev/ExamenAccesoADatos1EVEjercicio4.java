package com.mycompany.examenaccesoadatos1ev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExamenAccesoADatos1EVEjercicio4 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/empresa";
        String usuario = "root";
        String contraseña = "Valsalobre6991";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            String nif = "A28017894";
            String nombre = "EL CORTE INGLÉS";
            String direccion = "Hermosilla, 112";
            String consulta = "INSERT INTO proveedor (NIF, NOMBRE, DIRECCION) VALUES (?, ?, ?)";

            try (PreparedStatement pstmt = conexion.prepareStatement(consulta)) {
                pstmt.setString(1, nif);
                pstmt.setString(2, nombre);
                pstmt.setString(3, direccion);

                pstmt.executeUpdate();

                System.out.println("Proveedor insertado correctamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
