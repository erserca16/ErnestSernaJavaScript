/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Proyecto1 {

    public static void main(String[] args) {
        // Inicializa el entorno Hibernate
        Configuration cfg = new Configuration();
        cfg.configure("/hibernate.cfg.xml");

        // Crea el ejemplar de SessionFactory
        SessionFactory sessionFactory = cfg.buildSessionFactory(new 
            StandardServiceRegistryBuilder().configure().build());

        // Crea Session
        Session sesion = sessionFactory.openSession();
        // Crea transacción
        Transaction tx = sesion.beginTransaction(); 

        // Código de persistencia
        try {
            // Visualiza los datos del empleado 7369
            Empleados emp = new Empleados();
            try {
                emp = (Empleados) sesion.load(Empleados.class,(short) 7369);
                System.out.printf("Apellido: %s %n", emp.getApellido());
                System.out.printf("Departamento: %s %n", emp.getDepartamentos().getDnombre());
                System.out.printf("Trabajo: %s %n", emp.getOficio());
                System.out.printf("Dir: %d %n", emp.getDir());
                System.out.printf("Fecha alta: %tF %n", emp.getFechaAlt());
                System.out.printf("Salario: %.2f %n", emp.getSalario());
            } catch (ObjectNotFoundException o) {
                System.out.println("NO EXISTE EL EMPLEADO!!");
            }
            tx.commit(); // valida la transacción
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback(); // en caso de error, hace un rollback
            }
            e.printStackTrace();
        } finally {
            sesion.close(); // finaliza la sesión
        }
    }
}