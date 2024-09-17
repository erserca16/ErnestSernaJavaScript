package proyecto1;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Proyecto1actividad6 {

    public static void main(String[] args) {
        // Inicializa el entorno Hibernate
        Configuration cfg = new Configuration();
        cfg.configure("/hibernate.cfg.xml");

       
        SessionFactory sessionFactory = cfg.buildSessionFactory(new 
            StandardServiceRegistryBuilder().configure().build());

        
        Session sesion = sessionFactory.openSession();
        Transaction tx = sesion.beginTransaction();

      
        try {
            Empleados emp = (Empleados) sesion.load(Empleados.class, (short) 7369);
            
            System.out.printf("Antes:\n -Apellido: %s %n -Departamento:  %s %n "
                    + "-Salario: %.2f %n", emp.getApellido(),
                    emp.getDepartamentos().getDnombre(), emp.getSalario());

            emp.setSalario(emp.getSalario() + 1000);
            
            Departamentos depart = (Departamentos) sesion.load(Departamentos.class, (byte) 30);
            emp.setDepartamentos(depart);
            
            sesion.update(emp);
            
            System.out.println("Cambios realizados");

            tx.commit(); 
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback(); 
            }
            e.printStackTrace();
        } finally {
            sesion.close(); 
        }
    }
}
