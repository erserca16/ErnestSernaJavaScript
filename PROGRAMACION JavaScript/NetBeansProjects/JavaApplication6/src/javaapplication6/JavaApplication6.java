package javaapplication6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class JavaApplication6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String reportSource = "C:\\Users\\Ernest\\JaspersoftWorkspace\\MyReports\\Plantilla.jrxml";
        String reportHTML = "C:\\Users\\Ernest\\Desktop\\Informe.html";
        String reportPDF = "C:\\Users\\Ernest\\Desktop\\Informe.pdf";
        String reportXML = "C:\\Users\\Ernest\\Desktop\\Informe.xml";

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("titulo", "LISTADO DE DEPARTAMENTOS.");
        params.put("autor", "Ernest Serna Cabañero");
        params.put("fecha", (new java.util.Date()).toString());
        
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);

            // Establece la conexión a la base de datos
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "Valsalobre6991");

            JasperPrint MiInforme = JasperFillManager.fillReport(jasperReport, params, con);
            JasperViewer.viewReport(MiInforme);
            JasperExportManager.exportReportToHtmlFile(MiInforme, reportHTML);
            JasperExportManager.exportReportToPdfFile(MiInforme, reportPDF);
            JasperExportManager.exportReportToXmlFile(MiInforme, reportXML, false);
            System.out.println("ARCHIVOS CREADOS");
        } catch (ClassNotFoundException e) {
            System.out.println("Error driver.");
        } catch (SQLException e) {
            System.out.println("Error al ejecutar sentencia SQL.");
        } catch (Exception ex) {
            System.out.println("Error Jasper.");
            ex.printStackTrace();
        }
    }
    }
    

