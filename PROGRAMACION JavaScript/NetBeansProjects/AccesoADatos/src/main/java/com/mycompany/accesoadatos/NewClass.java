/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.accesoadatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NewClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:3306/ejemplo";
            String usuario = "root";
            String contraseña = "Valsalobre6991";
            // ALTER USER ejemplo@localhost IDENTIFIED WITH mysql_native_password;
            //ALTER USER ejemplo@localhost IDENTIFIED BY 'ejemplo';
            //https://mvnrepository.com/artifact/mysql/mysql-connector-java/8.0.13
// Cargar el driver
            Class.forName("com.mysql.jdbc.Driver");

            // Establecemos la conexion con la BD
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root",
                    "Valsalobre6991");

            // Preparamos la consulta
            Statement sentencia = conexion.createStatement();
            String sql = "SELECT * FROM departamentos";
            ResultSet resul = sentencia.executeQuery(sql);

            // Recorremos el resultado para visualizar cada fila
            // Se hace un bucle mientras haya registros y se van visualizando
            while (resul.next()) {
                System.out.printf("%d, %s, %s %n", resul.getInt(1), resul.getString(2), resul.getString(3));
            }

            resul.close(); // Cerrar ResultSet
            sentencia.close(); // Cerrar Statement
            conexion.close(); // Cerrar conexión

        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }// fin de main
}// fin de la clase
