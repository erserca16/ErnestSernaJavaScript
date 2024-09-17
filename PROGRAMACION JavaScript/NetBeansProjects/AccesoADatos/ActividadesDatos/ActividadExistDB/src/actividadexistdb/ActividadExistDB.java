package actividadexistdb;

/**
 * @author Ernest Serna
 */
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;
import net.xqj.exist.ExistXQDataSource;

public class ActividadExistDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            XQDataSource server = new ExistXQDataSource();
            server.setProperty("serverName", "localhost");
            server.setProperty("port", "8088");
            server.setProperty("user", "admin");
            server.setProperty("password", "admin");

            XQConnection conn = server.getConnection();

            //Primera consulta, departamentos
            XQPreparedExpression consulta_1;
            XQResultSequence resultado_1;
            consulta_1 = conn.prepareExpression("for $dep in /departamentos/DEP_ROW "
                    + "return concat('ID: ', $dep/DEPT_NO, ' - Nombre: ', $dep/DNOMBRE, ' - Ciudad: ', $dep/LOC)");
            resultado_1 = consulta_1.executeQuery();

            int contador_resultados = 1;
            while (resultado_1.next()) {
                System.out.println("Departamento " + contador_resultados + ": " + resultado_1.getItemAsString(null));
                contador_resultados++;
            }

            System.out.println("---------------------------------");

            //SEgunda consulta, salario empleados
            XQPreparedExpression consulta_2;
            XQResultSequence resultado_2;
            consulta_2 = conn.prepareExpression("for $emp in /EMPLEADOS/EMP_ROW "
                    + "where xs:integer($emp/SALARIO) >= 1000 and xs:integer($emp/SALARIO) <= 2000 "
                    + "order by xs:integer($emp/SALARIO) "
                    + "return concat('Apellido: ', $emp/APELLIDO, ' - Oficio: ', $emp/OFICIO, ' - Salario: ', $emp/SALARIO)");
            resultado_2 = consulta_2.executeQuery();

            int contador_resultados_2 = 1;
            while (resultado_2.next()) {
                System.out.println("Empleado nº" + contador_resultados_2 + ": " + resultado_2.getItemAsString(null));
                contador_resultados_2++;
            }

            conn.close();

        } catch (XQException e) {
            System.out.println("Error al operar");
            e.printStackTrace();
        }
    }
}
