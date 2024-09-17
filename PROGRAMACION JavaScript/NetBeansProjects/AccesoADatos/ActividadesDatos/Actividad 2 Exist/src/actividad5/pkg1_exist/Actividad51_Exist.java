/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad5.pkg1_exist;

import java.util.Collection;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XPathQueryService;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;

public class Actividad51_Exist {
  public static void main(String[] args) {
        try {
            XQDataSource xqpe = new ExistXQDataSource();
            xqpe.setProperty("serverName", "localhost");
            xqpe.setProperty("port", "8088");
            xqpe.setProperty("user", "admin");
            xqpe.setProperty("password", "admin");
            
            XQConnection con = xqpe.getConnection();
            
            //Consulta de los datos de departamentos
            XQPreparedExpression consulta;
            XQResultSequence resultado;
            consulta= con.prepareExpression(" for $dep in /departamentos/DEP_ROW "
                    + "let $id := $dep/DEPT_NO, $nom := $dep/DNOMBRE, $loc := $dep/LOC "
                    + "return concat( 'ID: ', $id, ' - Nombre: ', $nom, ' - Ciudad: ', $loc)");
            resultado = consulta.executeQuery();
            
            int cont = 1;
            while (resultado.next()) {
                System.out.println(cont +". "+ resultado.getItemAsString(null));
                cont++;
            }
            con.close();
            
        } catch (XQException e) {
            System.out.println("Error al operar");
             e.printStackTrace();
        }
    }