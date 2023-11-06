
package Servlets;

import Entidades.roles;
import Entidades.usuarios;
import Modelo.DaoRol;
import Modelo.DaoUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvRol", urlPatterns = {"/SvRol"})
public class SvRol extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        try {
            if (accion != null) {
                switch (accion) {
                    case "listarRoles":
                        listarRoles(request, response);
                        break;
                    case "registrarRol":
                        registrarRol(request, response);
                        break;
                    case "mostrarFormularioRol":
                        mostrarFormularioRol(request, response);
                        break;
                    case "leerRol":
                        leerRol(request, response);
                        break;
                    case "actualizarRol":
                        actualizarRol(request, response);
                        break;
                    case "eliminarRol":
                        eliminarRol(request, response);
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
    }

    private void listarRoles(HttpServletRequest request, HttpServletResponse response) {
        DaoRol dao = new DaoRol();
        List<roles> listaRoles = null;
        try {
            listaRoles = dao.listarRoles();
            request.setAttribute("listarRoles", listaRoles);

        } catch (Exception e) {
            request.setAttribute("mensaje", "No se pudo listar usuarios" + e.getMessage());
        } finally {
            dao = null;
        }

        try {
            this.getServletConfig().getServletContext().getRequestDispatcher("/Vistas/listaRoles.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("mensaje", "No se pudo listar usuarios" + ex.getMessage());
        }
    }

    private void mostrarFormularioRol(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.getServletConfig().getServletContext().getRequestDispatcher("/Vistas/agregarRol.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("mensaje", "No se pudo agregar usuarios" + e.getMessage());
        }
    }

    private void registrarRol(HttpServletRequest request, HttpServletResponse response) {
        DaoRol rolDAO = null;
        roles rol;
        if (request.getParameter("txtNombreRol") != null) {

            rol = new roles();
            rol.setNombreRol(request.getParameter("txtNombreRol"));
            
        
            
            rolDAO = new DaoRol();
            
            try {
                rolDAO.registrarRol(rol);
                response.sendRedirect("SvRol?accion=listarRoles");
            } catch (Exception e) {
                request.setAttribute("msje","No se pudo registrar el usuario" + e.getMessage());
                request.setAttribute("usuario", rol);
                
                this.mostrarFormularioRol(request, response);
            }

        }
    }

    private void leerRol(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void actualizarRol(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void eliminarRol(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
