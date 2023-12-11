package Servlets;

import Entidades.ServiciosViaje;
import Entidades.roles;
import Modelo.DaoHistorialViajes;
import Modelo.DaoRol;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.System.out;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@WebServlet(name = "SvReporte", urlPatterns = {"/SvReporte"})
public class SvReporte extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tipoReporte = request.getParameter("tipoReporte");
        switch (tipoReporte) {
            case "exportarHistorialPorPasajero":
                exportarHistorialPorPasajero(request, response);
                break;
            case "exportarReporteRoles":
                exportarReporteRoles(request, response);
                break;
            case "exportarServiciosPorFecha": {
                try {
                    exportarServiciosPorFecha(request, response);
                } catch (Exception ex) {
                    Logger.getLogger(SvReporte.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            default:
                throw new AssertionError();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tipoReporte = request.getParameter("tipoReporte");
        switch (tipoReporte) {
            case "exportarHistorialPorPasajero":
                exportarHistorialPorPasajero(request, response);
                break;
            case "exportarServiciosPorFecha": {
                try {
                    exportarServiciosPorFecha(request, response);
                } catch (Exception ex) {
                    Logger.getLogger(SvReporte.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;

            default:
                throw new AssertionError();
        }
    }

    private void exportarReporteRoles(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DaoRol daoRol = new DaoRol();
        try {
            ServletOutputStream out = response.getOutputStream();
            //Iniciamos el JasperReport
            InputStream reporteRoles = this.getServletConfig()
                    .getServletContext()
                    .getResourceAsStream("Reportes/ReporteRoles.jasper");//Url del jasperReport

            if (reporteRoles != null) {
                List<roles> lstRoles2 = new ArrayList<>();
                //Cargamos la lista 2 con todos los roles
                lstRoles2 = daoRol.listarRoles();
                // Creamos objeto Jasper Report
                JasperReport report = (JasperReport) JRLoader.loadObject(reporteRoles);
                //Este JRBeanArrayDataSource sirve para proporcionar los datos al informe
                JRBeanArrayDataSource ds = new JRBeanArrayDataSource(lstRoles2.toArray());
                // Creamos los parametros del Jasper Report
                Map<String, Object> parametros = new HashMap();
                parametros.put("ds", ds);
                //Establecemos el tipo de contenido de la respuesta HTTP como PDF
                response.setContentType("application/pdf");
                response.addHeader("Content-disposition", "inline; filename=ReporteRoles.pdf");
                JasperPrint jasperPrint = JasperFillManager.fillReport(report, parametros, ds);
                JasperExportManager.exportReportToPdfStream(jasperPrint, out);
                out.flush();
                out.close();

            } else {
                response.setContentType("text/plain");
                out.println("ERROR: No se pudo generar el reporte");
                out.println(
                        "ERROR: Esto puede deberse a que la lista de datos no fue recibida o el archivo plantilla del reporte no se ha encontrado");
            }

        } catch (Exception ex) {
            response.setContentType("text/plain");
            out.print("ERROR: Al intentar generar el reporte: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void exportarServiciosPorFecha(HttpServletRequest request, HttpServletResponse response) throws ParseException, Exception {
        DaoHistorialViajes daoViajes = new DaoHistorialViajes();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        // Obtener y convertir las fechas de util.Date a sql.Date
        Date fechaDesdeUtil = formatter.parse(request.getParameter("fechaDesde"));
        Date fechaHastaUtil = formatter.parse(request.getParameter("fechaHasta"));
        List<ServiciosViaje> historialViajes = daoViajes.obtenerHistorialPorFecha(fechaDesdeUtil, fechaHastaUtil);

        try {
            ServletOutputStream out = response.getOutputStream();
            //Iniciamos el JasperReport
            InputStream reporteRoles = this.getServletConfig()
                    .getServletContext()
                    .getResourceAsStream("Reportes/ServicioFecha.jasper");//Url del jasperReport

            if (reporteRoles != null) {
                // Creamos Arrays y agregamos los datos
                List<ServiciosViaje> lstServicios2 = new ArrayList<>();
                //Cargamos la lista 2 con todos los viajes
                lstServicios2 = historialViajes;
                // Creamos objeto Jasper Report
                JasperReport report = (JasperReport) JRLoader.loadObject(reporteRoles);
                //Este JRBeanArrayDataSource sirve para proporcionar los datos al informe
                JRBeanArrayDataSource ds = new JRBeanArrayDataSource(lstServicios2.toArray());
                // Creamos los parametros del Jasper Report
                Map<String, Object> parametros = new HashMap();
                parametros.put("ds", ds);
                //Establecemos el tipo de contenido de la respuesta HTTP como PDF
                response.setContentType("application/pdf");
                response.addHeader("Content-disposition", "inline; filename=ReporteServicios.pdf");
                JasperPrint jasperPrint = JasperFillManager.fillReport(report, parametros, ds);
                JasperExportManager.exportReportToPdfStream(jasperPrint, out);
                out.flush();
                out.close();

            } else {
                response.setContentType("text/plain");
                out.println("ERROR: No se pudo generar el reporte");
                out.println(
                        "ERROR: Esto puede deberse a que la lista de datos no fue recibida o el archivo plantilla del reporte no se ha encontrado");
            }

        } catch (Exception ex) {
            response.setContentType("text/plain");
            out.print("ERROR: Al intentar generar el reporte: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void exportarHistorialPorPasajero(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DaoHistorialViajes daoViajes = new DaoHistorialViajes();
        int idPasajero = Integer.parseInt(request.getParameter("idPasajero"));
        try {
            ServletOutputStream out = response.getOutputStream();
            //Iniciamos el JasperReport
            InputStream reporteRoles = this.getServletConfig()
                    .getServletContext()
                    .getResourceAsStream("Reportes/ServicioPasajero.jasper");//Url del jasperReport

            if (reporteRoles != null) {
                // Creamos Arrays y agregamos los datos
                List<ServiciosViaje> lstViajes2 = new ArrayList<>();
                //Cargamos la lista 2 con todos los viajes
                lstViajes2 = daoViajes.obtenerHistorialPorIdPasajero(idPasajero);
                // Creamos objeto Jasper Report
                JasperReport report = (JasperReport) JRLoader.loadObject(reporteRoles);
                //Este JRBeanArrayDataSource sirve para proporcionar los datos al informe
                JRBeanArrayDataSource ds = new JRBeanArrayDataSource(lstViajes2.toArray());
                // Creamos los parametros del Jasper Report
                Map<String, Object> parametros = new HashMap();
                parametros.put("ds", ds);
                //Establecemos el tipo de contenido de la respuesta HTTP como PDF
                response.setContentType("application/pdf");
                response.addHeader("Content-disposition", "inline; filename=ReportePasajero.pdf");
                JasperPrint jasperPrint = JasperFillManager.fillReport(report, parametros, ds);
                JasperExportManager.exportReportToPdfStream(jasperPrint, out);
                out.flush();
                out.close();

            } else {
                response.setContentType("text/plain");
                out.println("ERROR: No se pudo generar el reporte");
                out.println(
                        "ERROR: Esto puede deberse a que la lista de datos no fue recibida o el archivo plantilla del reporte no se ha encontrado");
            }

        } catch (Exception ex) {
            response.setContentType("text/plain");
            out.print("ERROR: Al intentar generar el reporte: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

}
