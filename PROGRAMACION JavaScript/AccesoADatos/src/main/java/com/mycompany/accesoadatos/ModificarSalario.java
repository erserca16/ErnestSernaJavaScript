package com.mycompany.accesoadatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ERNEST-PC
 */
public class ModificarSalario {
    public static void main(String[] args) {
        // Establecer la conexión con la base de datos
        String url = "jdbc:mysql://localhost:3306/ejemplo";
        String usuario = "root";
        String contraseña = "Valsalobre6991";
        
        try {
            
            // Preparar la consulta SQL
            try ( Connection conexión = DriverManager.getConnection(url, usuario, contraseña)) {

               // String sql = "UPDATE departamentos SET dnombre = LOWER(dnombre)";
               // String sql = "SELECT * FROM departamentos";
                String sql = "UPDATE empleados SET salario = salario + 100 " + "WHERE dept_no = 10";
                // Preparar la consulta SQL
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

                sentencia.close(); //Cerrar Statement
                //Cerrar conexión
            }
        } catch (SQLException cn) {
            cn.printStackTrace();
        }
    }

    
}
