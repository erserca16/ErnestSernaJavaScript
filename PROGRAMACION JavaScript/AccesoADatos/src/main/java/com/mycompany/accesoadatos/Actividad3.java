package com.mycompany.accesoadatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

/**
 ** @author Gemma Manejo de conectores. Parte 4 Ejercicio 3
 */
public class Actividad3 {

    public static void main(String[] args) {
        // Establecer la conexion con la base de datos
     // String url = "jdbc:mysql://localhost:3306/ejemplo?allowMultiQueries=true";
        String url = "jdbc:mysql://localhost:3306/ejemplo"; //Da igual cual utilizar
        String usuario = "root";
        String contraseña = "Valsalobre6991";
        try {
            // Preparar la consulta SQL
            try ( Connection conexion = DriverManager.getConnection(url,
                    usuario, contraseña)) {
                
                //Consulta de los empleados del departamento ?
                String sql = "select e.apellido, e.oficio, e.salario, d.dnombre\n"
                        + "from empleados e  \n"
                        + "join departamentos d on e.dept_no=d.dept_no\n"
                        + "where d.dept_no = ?;";

                try ( PreparedStatement ps = conexion.prepareStatement(sql)) {

                    ps.setInt(1, 20); //placeholder
                    ResultSet rs = ps.executeQuery();

                        while (rs.next()) {
                        String apellido = rs.getString("apellido");
                        double salario = rs.getDouble("salario");
                        String oficio = rs.getString("oficio");
                        String dnombre = rs.getString("dnombre");

                        System.out.printf("Apellido: %s\n Salario: %.2f\n"
                                + " Oficio: %s\n Departamento: %s\n\n", apellido,
                                salario, oficio, dnombre);
                    }
                }

                // Consulta para obtener el salario promedio en el departamento
                // y el número de empleados del departamento
                String salarioMedio = "SELECT AVG(e.salario) AS \"Salario medio\","
                        + " count(*) as \"Total empleados\"\n"
                        + "FROM empleados e\n"
                        + "WHERE e.dept_no = ?";
                
                try ( PreparedStatement psMedia = conexion.prepareStatement(salarioMedio)) {
                    psMedia.setInt(1, 30);
                    ResultSet rsMedia = psMedia.executeQuery();
                    if (rsMedia.next()) {
                        double media = rsMedia.getDouble("Salario medio");
                        int totalEmpleados = rsMedia.getInt("Total empleados");
                        
                        //Formato para el salario (0.000,00)
                        DecimalFormat formato = new DecimalFormat("###,###.##");
                        String salarioFormateado = formato.format(media);
                        
                        System.out.printf("Salario medio del departamento "
                                + "30: %s €%n", salarioFormateado);
                        System.out.printf("Número total de empleados en el departamento "
                                + "30: %d%n", totalEmpleados);
                    }
                }

            }
        } catch (SQLException cn) {
            cn.printStackTrace();
        }

    }

}
