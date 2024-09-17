package com.mycompany.examenaccesoadatos1ev;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExamenAccesoADatos1EVEjercicio2 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/empresa";
        String usuario = "root";
        String contraseña = "Valsalobre6991";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            DatabaseMetaData metaData = conexion.getMetaData();
            ResultSet result = metaData.getTables("empresa", null, null, null);

            while (result.next()) {
                String nombreTabla = result.getString(3);
                System.out.println("TABLA: " + nombreTabla);
                System.out.println("");
                System.out.println("Primary Key:");

                ResultSet rsPrimaryKeys = metaData.getPrimaryKeys("empresa", null, nombreTabla);
                while (rsPrimaryKeys.next()) {
                    String columnaPrimaryKey = rsPrimaryKeys.getString("Column_name");
                    System.out.println(columnaPrimaryKey);
                }
                System.out.println("");
                System.out.println("Foreign Key:");
                ResultSet rsForeignKeys = metaData.getImportedKeys("empresa", null, nombreTabla);
                while (rsForeignKeys.next()) {
                    String columnaForeignKey = rsForeignKeys.getString("Fkcolumn_name");
                    System.out.println(columnaForeignKey);
                }
                System.out.println("");
                System.out.println("********************");
            }

            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
