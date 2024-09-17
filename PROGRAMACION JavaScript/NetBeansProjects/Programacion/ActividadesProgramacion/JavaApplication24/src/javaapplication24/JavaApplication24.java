package javaapplication24;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class JavaApplication24 {

    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Apertura de la sesión
        Session session = sessionFactory.openSession();

        // Uso de la sesión para realizar consultas
        Query q = session.createQuery("SELECT e.apellido, e.salario FROM Empleados e WHERE e.dept_no = :dept_no");
        q.setParameter("dept_no", 20);

        // Obtención de los resultados
        List<Object[]> resultados = q.list();

        // Impresión de los resultados
        for (Object[] resultado : resultados) {
            String apellido = (String) resultado[0];
            Double salario = (Double) resultado[1]; // Asumiendo que el salario es de tipo Double, ajusta según tu modelo

            System.out.println("Apellido: " + apellido + ", Salario: " + salario);
        }

        // Cierre de la sesión y de la fábrica de sesiones al finalizar la aplicación
        session.close();
        sessionFactory.close();
    }
}