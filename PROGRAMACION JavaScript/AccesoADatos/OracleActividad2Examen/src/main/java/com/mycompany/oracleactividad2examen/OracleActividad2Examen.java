package com.mycompany.oracleactividad2examen;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleActividad2Examen {

    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String usuario = "empleados";
        String contraseña = "admin";

        //Establecemos la conexión con la BD
        try {
            // Establecer la conexión
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);

            // Consulta 1: Muestra empleados con salario > 1050
            String sql = "SELECT e.id, e.nombre, e.salario, e.fecha_alta FROM empleados e WHERE e.salario > 1050";

            Statement sentencia1 = conexion.createStatement();
            ResultSet resultado1 = sentencia1.executeQuery(sql);

             System.out.println("CONSULTA 1. SALARIO MAYOR QUE 1050");
            while (resultado1.next()) {
                String id = resultado1.getString("ID");
                String nombre = resultado1.getString("nombre");
                double salario = resultado1.getDouble("salario");
                Date fecha_alta = resultado1.getDate("fecha_alta");
                
                
                System.out.println("Id empleado: " + id + " - Nombre Empleado: " + nombre + " - Salario: " + salario + " - Fecha de alta: " + fecha_alta);
            }
            resultado1.close();
            sentencia1.close();
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("");

            
            String sql2 = "SELECT AVG(e.salario) AS salario_medio "
                    + "FROM empleados e WHERE e.fecha_alta > TO_DATE('01/01/2000', 'DD/MM/YYYY')";
            Statement sentencia2 = conexion.createStatement();
            ResultSet resultado2 = sentencia2.executeQuery(sql2);

            // Verificar si hay un resultado
            if (resultado2.next()) {
                // Obtener el salario medio
                double salariomedio = resultado2.getDouble("salario_medio");
                System.out.println("CONSULTA 2. SALARIO MEDIO DE LOS EMPLEADOS QUE ENTRARON DESPUÉS DEL 1 DE ENERO DEL 2000");
                System.out.println("Salario medio de los empleados incorporados después de"
                        + " 01/01/2000 es:\n " + salariomedio);
            } else {
                // No se encontraron resultados
                System.out.println("No se encontraron resultados para la consulta realizada.");
            }

            // Cerrar recursos
            resultado2.close();
            sentencia2.close();
            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}