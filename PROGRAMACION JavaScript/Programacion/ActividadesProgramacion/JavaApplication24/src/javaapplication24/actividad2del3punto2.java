
package javaapplication24;

import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class actividad2del3punto2 {
    
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Apertura de la sesión
        Session session = sessionFactory.openSession();

        // Uso de la sesión para realizar consultas SQL nativas
        SQLQuery query = session.createSQLQuery("SELECT d.dept_no, d.dnombre, d.loc, AVG(salario) as salario_promedio, COUNT(*) as cantidad_empleados " +
                                               "FROM Departamentos d " +
                                               "JOIN Empleados e ON d.dept_no = e.dept_no " +
                                               "GROUP BY dept_no");

        // Obtención de los resultados
        List<Object[]> resultados = query.list();

        // Impresión de los resultados
        for (Object[] resultado : resultados) {
            byte deptNo = (byte) resultado[0];
            String dnombre = (String) resultado[1];
            String loc = (String) resultado[2];
            Double salarioPromedio = (Double) resultado[3];
            Long cantidadEmpleados = ((Number) resultado[4]).longValue();

            System.out.println("Departamento: " + deptNo +
                               ", Nombre: " + dnombre +
                               ", Ubicación: " + loc +
                               ", Salario Promedio: " + salarioPromedio +
                               ", Cantidad de Empleados: " + cantidadEmpleados);
        }

        // Cierre de la sesión y de la fábrica de sesiones al finalizar la aplicación
        session.close();
        sessionFactory.close();
    }
}