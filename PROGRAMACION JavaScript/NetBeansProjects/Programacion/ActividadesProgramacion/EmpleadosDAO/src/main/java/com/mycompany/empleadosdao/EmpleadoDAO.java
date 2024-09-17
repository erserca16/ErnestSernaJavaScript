package com.mycompany.empleadosdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author Ernest Serna
 */
public class EmpleadoDAO { //aqui es donde están los métodos del CRUD

    private static final String URL = "jdbc:mysql://localhost:3306/empresa";
    private static final String USER = "root";
    private static final String PASSWORD = "Valsalobre6991";
    
    private static Connection conectar(){
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/empresa";
        String user = "root";
        String password = "Valsalobre6991";
        try{
            con = DriverManager.getConnection(url,user,password);
        } catch (SQLException ex){
            System.out.println("Error al conectar a la Base de Datos");
        }
        return con;
    }
    
    // Crear
    public static void create(Empleado empleado) {
        String sql = "INSERT INTO empleados (numemp, nombre, edad, oficina, puesto, contrato) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, empleado.getNumemp());
            pstmt.setString(2, empleado.getNombre());
            pstmt.setInt(3, empleado.getEdad());
            pstmt.setInt(4, empleado.getOficina());
            pstmt.setString(5, empleado.getPuesto());
            pstmt.setDate(6, java.sql.Date.valueOf(empleado.getContrato()));
            pstmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Leer
    public static Empleado read(int numemp) {
        String sql = "SELECT * FROM empleados WHERE numemp = ?";
        try (Connection conn = conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, numemp);
            try (ResultSet rs = pstmt.executeQuery(sql)) {
                if (rs.next()) {
                    return new Empleado(
                            rs.getInt("numemp"),
                            rs.getString("nombre"),
                            rs.getInt("edad"),
                            rs.getInt("oficina"),
                            rs.getString("puesto"),
                            rs.getDate("contrato").toLocalDate()
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    // Actualizar

    public static void update(Empleado empleado) {
        String sql = "UPDATE empleados SET nombre = ?, edad = ?, oficina = ?, puesto = ?, contrato = ? WHERE numemp = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, empleado.getNombre());
            pstmt.setInt(2, empleado.getEdad());
            pstmt.setInt(3, empleado.getOficina());
            pstmt.setString(4, empleado.getPuesto());
            pstmt.setDate(5, java.sql.Date.valueOf(empleado.getContrato()));
            pstmt.setInt(6, empleado.getNumemp());
            pstmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Borrar
    public static void delete(int numemp) {
        String sql = "DELETE FROM empleados WHERE numemp = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, numemp);
            pstmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Leer Todo
    public static Set<Empleado> readAll() {
        String sql = "SELECT * FROM empleados";
        Set<Empleado> empleados = new HashSet<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Empleado empleado = new Empleado(
                        rs.getInt("numemp"),
                        rs.getString("nombre"),
                        rs.getInt("edad"),
                        rs.getInt("oficina"),
                        rs.getString("puesto"),
                        rs.getDate("contrato").toLocalDate()
                );
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }

}
