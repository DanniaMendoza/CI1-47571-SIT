package Servlets;

import Entidades.*;
import Modelo.DaoRuta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SvRuta", urlPatterns = {"/SvRuta"})
public class SvRuta extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String accion = request.getParameter("accion");
        try {
            if (accion != null) {
                switch (accion) {
                    case "listarRutas":
                        listarRutas(request, response);
                        break;
                    case "registrarRutas":
                        registrarRutas(request, response);
                        break;
                    case "mostrarFormularioRutas":
                        mostrarFormularioRutas(request, response);
                        break;
                    case "imprimirRutas":
                        imprimirRutas(request, response);
                        break;
                    case "leerRutas":
                        leerRutas(request, response);
                        break;
                    case "actualizarRutas":
                        actualizarRutas(request, response);
                        break;
                    case "eliminarRutas":
                        eliminarRutas(request, response);
                        break;
                    default:
                        response.sendRedirect("error.jsp");
                }

            } else {
                response.sendRedirect("mensaje.jsp");
            }

        } catch (Exception e) {
            try {
                this.getServletConfig().getServletContext().getRequestDispatcher("/mensaje.jsp").forward(request, response);
            } catch (Exception ex) {
                System.out.println("Error " + e.getMessage());
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void listarRutas(HttpServletRequest request, HttpServletResponse response) {
       DaoRuta dao = new DaoRuta();
        List<rutas> listaRuta = null;
        try {
            listaRuta = dao.listarRutas();
            request.setAttribute("listarRutas", listaRuta);

        } catch (Exception e) {
            request.setAttribute("mensaje", "No se pudo listar rutas" + e.getMessage());
        } finally {
            dao = null;
        }

        try {
            this.getServletConfig().getServletContext().getRequestDispatcher("/Vistas/listaRutas.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("mensaje", "No se pudo listar usuarios" + ex.getMessage());
        }
    }

    private void registrarRutas(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void mostrarFormularioRutas(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void imprimirRutas(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void leerRutas(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void actualizarRutas(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void eliminarRutas(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
