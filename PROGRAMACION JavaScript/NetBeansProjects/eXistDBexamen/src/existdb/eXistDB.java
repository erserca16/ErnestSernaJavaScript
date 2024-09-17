package existdb;
import javax.xml.xquery.*;

import net.xqj.exist.ExistXQDataSource;

public class eXistDB {

    public static String obtenerDatosSucursales() {
        StringBuilder resultadoConsulta = new StringBuilder();
        try {
            // Crear y configurar el origen de datos
            XQDataSource xqds = new ExistXQDataSource();
            xqds.setProperty("serverName", "localhost");
            xqds.setProperty("port", "8088");
            xqds.setProperty("user", "admin");
            xqds.setProperty("password", "admin");

            // Establecer la conexión
            XQConnection con = xqds.getConnection();

            // Consulta XQuery para mostrar todos los datos de sucursales
            String consultaXQuery1 = "/sucursales/*";

            // Preparar la expresión de consulta
            XQExpression expression = con.createExpression();

            // Ejecutar la consulta y obtener el resultado
            XQResultSequence resultado = expression.executeQuery(consultaXQuery1);

            // Iterar sobre los resultados y construir la cadena de salida
            resultadoConsulta.append("Datos de las sucursales:\n");
            while (resultado.next()) {
                resultadoConsulta.append(resultado.getItemAsString(null)).append("\n");
            }

            // Consulta XQuery para seleccionar los clientes con saldo deudor igual a cero
            String consultaXQuery2 = "/sucursales/sucursal/cuenta[saldodebe = 0]";

            // Ejecutar la consulta y obtener el resultado
            XQResultSequence resultado2 = expression.executeQuery(consultaXQuery2);

            // Iterar sobre los resultados y construir la cadena de salida
            resultadoConsulta.append("\nClientes con saldo deudor igual a cero:\n");
            while (resultado2.next()) {
                resultadoConsulta.append(resultado2.getItemAsString(null)).append("\n");
            }

            // Cerrar la conexión
            con.close();

        } catch (XQException e) {
            resultadoConsulta.append("Error al operar\n");
            e.printStackTrace();
        }
        return resultadoConsulta.toString();
    }

    public static void main(String[] args) {
        String datos = obtenerDatosSucursales();
        System.out.println(datos);
    }
}
