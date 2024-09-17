package com.mycompany.pruebadeconexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ERNEST-PC
 */
public class PruebaDeConexion {

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo", "root", "Valsalobre6991");
            String consulta = "SELECT * FROM departamentos";
            PreparedStatement ps = conn.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Integer id = rs.getInt("dept_no");
                String nombre = rs.getString("dnombre");
                String localidad = rs.getString("loc");
                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Localidad: " + localidad);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
