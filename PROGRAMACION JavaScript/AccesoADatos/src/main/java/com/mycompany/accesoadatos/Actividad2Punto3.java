package com.mycompany.accesoadatos;

import java.sql.*;

/**
 *
 * @author ERNEST-PC
 */
public class Actividad2Punto3 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/ejemplo";
        String usuario = "root";
        String contraseña = "Valsalobre6991";
        
        try {
            
            // Preparar la consulta SQL
            try ( Connection conexión = DriverManager.getConnection(url, usuario, contraseña)) {

              
                String sql = "INSERT INTO departamentos VALUES (15,'INFORMATICA'," + "'MADRID')";
                Statement sentencia = conexión.createStatement();
                
                
                boolean valor = sentencia.execute(sql);

                if (valor) {
                    ResultSet rs = sentencia.getResultSet();
                    while (rs.next()) {
                        System.out.printf("%d, %s, %s,%n",
                                rs.getInt(1), 
                                rs.getString(2),
                                rs.getString(3));
                    }
                    rs.close();
                } else {
                    int f = sentencia.getUpdateCount();
                    System.out.printf("Filas afectadas: %d %n", f);
                }

                sentencia.close(); 
            }
        } catch (SQLException cn) {
            cn.printStackTrace();
        }
    }
}
