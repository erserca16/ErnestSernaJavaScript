package com.mycompany.examenaccesoadatos1ev;

import java.sql.*;

public class ExamenAccesoADatos1EVEjercicio3 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/empresa";
        String usuario = "root";
        String contraseña = "Valsalobre6991";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            try (CallableStatement cstmt = conexion.prepareCall("{call AUMENTO5PVP()}")) {
                cstmt.execute();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
