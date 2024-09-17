
package proyecto1;
 
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class Proyecto1actividad5 {

    public static void main(String[] args) {
        // Inicializa el entorno Hibernate
        Configuration cfg = new Configuration();
        cfg.configure("C:\\Users\\Ernest\\Documents\\NetBeansProjects\\Proyecto1\\src\\hibernate.cfg.xml");

        // Crea el ejemplar de SessionFactory
        SessionFactory sessionFactory = cfg.buildSessionFactory(new 
            StandardServiceRegistryBuilder().configure().build());

        // Crea Session
        Session sesion = sessionFactory.openSession();
        // Crea transacción
        Transaction tx = sesion.beginTransaction(); 

        // Código de persistencia
        try {
            // Obtener los datos del departamento 10
            Departamentos depart = (Departamentos) sesion.load(Departamentos.class, (byte) 10);
            System.out.printf("Departamento: %s %n", depart.getDnombre());
            
            // Obtener empleados del departamento 10
           for (Empleados emp : depart.getEmpleadoses()) {
                System.out.printf("Apellido: %s, Salario: %.2f %n", emp.getApellido(), emp.getSalario());
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