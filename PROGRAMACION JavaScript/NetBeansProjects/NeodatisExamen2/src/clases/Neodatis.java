package clases;

/**
 *
 * @author Ernest Serna
 */
import clases.Empleados;
import java.text.SimpleDateFormat;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

public class Neodatis {

    public static void main(String[] args) {

   Empleados empleado1 = new Empleados("emp1", "Juan", 1000, "10/10/1999");
   Empleados empleado2 = new Empleados("emp2", "Alicia", 1400, "07/08/2000");
   Empleados empleado3 = new Empleados("emp3", "Maria Jesús", 1500, "05/01/2005");
   Empleados empleado4 = new Empleados("emp4", "Alberto", 1100, "15/11/2001");
        
        ODB odb = ODBFactory.open("examen.db");
        //Almacenamos objetos

        odb.store(empleado1);
        odb.store(empleado2);
        odb.store(empleado3);
        odb.store(empleado4);
        
        odb.close();
    }
    
}
