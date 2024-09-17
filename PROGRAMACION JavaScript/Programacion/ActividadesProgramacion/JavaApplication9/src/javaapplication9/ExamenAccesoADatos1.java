package javaapplication9;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExamenAccesoADatos1 {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/empresa";
        String usuario = "root";
        String contraseña = "Valsalobre6991";

        
            // Preparar la consulta SQL
            try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {

                DatabaseMetaData metaData = conexion.getMetaData();
                ResultSet rsTablas = metaData.getTables(null, null, "%", null);

                while (rsTablas.next()) {
                    String nombreTabla = rsTablas.getString("TABLE_NAME");

                    System.out.println("Tabla: " + nombreTabla);
                    System.out.println("Claves Primarias:");

                    ResultSet rsPrimaryKeys = metaData.getPrimaryKeys(null, null, nombreTabla);
                    while (rsPrimaryKeys.next()) {
                        String columnaPrimaryKey = rsPrimaryKeys.getString("COLUMN_NAME");
                        System.out.println(" - " + columnaPrimaryKey);
                    }

                    System.out.println("Claves Ajenas:");
                    ResultSet rsForeignKeys = metaData.getImportedKeys(null, null, nombreTabla);
                    while (rsForeignKeys.next()) {
                        String columnaForeignKey = rsForeignKeys.getString("FKCOLUMN_NAME");
                        String tablaReferenciada = rsForeignKeys.getString("PKTABLE_NAME");
                        String columnaReferenciada = rsForeignKeys.getString("PKCOLUMN_NAME");

                        System.out.println(" - " + columnaForeignKey + " -> " + tablaReferenciada + "." + columnaReferenciada);
                    }

                    System.out.println("--------------------");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

