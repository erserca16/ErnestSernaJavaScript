package proyecto1;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author ERNEST-PC
 */
public class NewHibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            Configuration cfg = new Configuration();
            cfg.configure("/hibernate.cfg.xml");

            sessionFactory = cfg.buildSessionFactory();

        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}