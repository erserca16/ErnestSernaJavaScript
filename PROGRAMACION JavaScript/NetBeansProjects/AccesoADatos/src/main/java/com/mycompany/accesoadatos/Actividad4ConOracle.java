package com.mycompany.accesoadatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Actividad4ConOracle {

    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String usuario = "empleados";
        String contraseña = "admin";

        //Establecemos la conexión con la BD
        try {
            // Establecer la conexión
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);

            // Consulta 1: Muestra empleados con salario > 1050
            String sql = "SELECT e.id, e.nombre, e.salario, "
                    + "e.fechaalta FROM pruebaex.empleados e WHERE e.salario > 1050";
            Statement sentencia = conexion.createStatement();
            ResultSet resul = sentencia.executeQuery(sql);

            // Procesar los resultados
            while (resul.next()) {
                // Obtener datos específicos de cada fila
                String id = resul.getString("ID");
                String nombre = resul.getString("nombre");
                double salario = resul.getDouble("salario");
                java.sql.Date fechaAlta = resul.getDate("fechaalta");
                
                // Imprimir o manejar los datos según tus necesidades
                System.out.println("ID: " + id + " - NOMBRE: " + nombre + " - SALARIO: " + salario + "- FECHA ALTA: " + fechaAlta);
            }
            resul.close();
            sentencia.close();
            System.out.println("---------");

            //Consulta 2: media del salario de empleados con fechaalta > 01/01/2000
            String sql2 = "SELECT AVG(e.salario) AS salario_medio "
                    + "FROM pruebaex.empleados e WHERE e.fechaalta > TO_DATE('01/01/2000', 'DD/MM/YYYY')";
            Statement sentencia2 = conexion.createStatement();
            ResultSet resul2 = sentencia2.executeQuery(sql2);

            // Verificar si hay un resultado
            if (resul2.next()) {
                // Obtener el salario medio
                double salarioMedio = resul2.getDouble("salario_medio");

                // Imprimir el salario medio
                System.out.println("El salario medio de los empleados incorporados después de"
                        + " 01/01/2000 es:\n " + salarioMedio);
            } else {
                // No se encontraron resultados
                System.out.println("No se encontraron resultados para la consulta.");
            }

            // Cerrar recursos
            resul2.close();
            sentencia2.close();
            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}