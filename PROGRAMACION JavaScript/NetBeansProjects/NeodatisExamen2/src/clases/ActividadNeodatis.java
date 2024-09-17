package clases;

/**
 * @author Ernest Serna
 */
import java.util.Date;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.Where;
import clases.Empleados;

public class ActividadNeodatis {
        public static void main(String[] args) {
            // Abre la conexión a la base de datos
            ODB odb = ODBFactory.open("examen.db");

            // Obtiene la fecha límite (01/01/2000)
            Date fechaLimite = new Date(100, 0, 1); // Año: 2000, Mes: Enero (0), Día: 1

            // Realiza la consulta para obtener los empleados incorporados después de la fecha límite
            Objects<Empleados> empleadosDespuesDeFecha = odb.getObjects(Where.gt("fechaAlta", fechaLimite));

            // Calcula el salario medio
            double salarioTotal = 0;
            int contador = 0;
            while (empleadosDespuesDeFecha.hasNext()) {
                Empleados empleado = empleadosDespuesDeFecha.next();
                salarioTotal += empleado.getSalario();
                contador++;
            }
            double salarioMedio = contador > 0 ? salarioTotal / contador : 0;

            // Muestra el salario medio
            System.out.println("Salario medio de los empleados incorporados después del 01/01/2000: " + salarioMedio);

            // Cierra la conexión a la base de datos
            odb.close();
        }
    }


