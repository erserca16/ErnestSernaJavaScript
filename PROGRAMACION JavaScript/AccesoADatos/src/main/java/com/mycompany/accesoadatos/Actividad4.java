package com.mycompany.accesoadatos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class Actividad4 {
    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String usuario = "system";
        String contraseña = "SYSTEM";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            // Consulta a) - Empleados cuyo salario sea mayor que 1050
            String consultaA = "SELECT * FROM ernest.empleados WHERE salario > 1050";
            System.out.println("Consulta A:");
            ejecutarConsulta(conexion, consultaA);

            // Consulta b) - Salario medio de los empleados incorporados después del 01/01/2000
            String consultaB = "SELECT AVG(salario) AS salario_medio FROM ernest.empleados WHERE fecha_alta > TO_DATE('01/01/2000', 'DD/MM/YYYY')";
            System.out.println("\nConsulta B:");
            ejecutarConsulta(conexion, consultaB);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void ejecutarConsulta(Connection conexion, String consulta) throws SQLException {
        try (Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery(consulta)) {

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String nombre = resultSet.getString("nombre");
                double salario = resultSet.getDouble("salario");
                java.sql.Date fecha_alta = resultSet.getDate("fecha_alta");
                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Salario: " + salario + ", Fecha de Alta: " + fecha_alta);
            }
        }
    }
}