package Servlets;

import Entidades.roles;
import Entidades.transporte;
import Entidades.usuarios;
import Modelo.DaoRol;
import Modelo.DaoTransporte;
import Modelo.DaoUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvTransporte", urlPatterns = {"/SvTransporte"})
public class SvTransporte extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        try {
            if (accion != null) {
                switch (accion) {
                    case "listarVehiculos":
                        listarVehiculos(request, response);
                        break;

                    case "mostrarFormVehiculo":
                        mostrarFormVehiculo(request, response);
                        break;
                    case "registrarVehiculo":
                        registrarVehiculo(request, response);
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

    private void listarVehiculos(HttpServletRequest request, HttpServletResponse response) {
        DaoTransporte daoVehiculo = new DaoTransporte();
        List<transporte> listaVehiculos = null;
        try {
            listaVehiculos = daoVehiculo.listarTransporte();
            request.setAttribute("listar", listaVehiculos);

        } catch (Exception e) {
            request.setAttribute("mensaje", "No se pudo listar usuarios" + e.getMessage());
        } finally {
            daoVehiculo = null;
        }

        try {
            this.getServletConfig().getServletContext().getRequestDispatcher("/Vistas/listaVehiculos.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("mensaje", "No se pudo listar usuarios" + ex.getMessage());
        }

    }

    private void cargarConductor(HttpServletRequest request) {
        DaoUsuario daoUsuario = new DaoUsuario();
        List<usuarios> usuarioLista = null;
        try {
            usuarioLista = daoUsuario.listarUsuarios();
            request.setAttribute("conductores", usuarioLista);
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo cargar los roles :( " + e.getMessage());
        } finally {
            usuarioLista = null;
            daoUsuario = null;
        }
    }
    
    
    private void mostrarFormVehiculo(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.cargarConductor(request);
            this.getServletConfig().getServletContext().getRequestDispatcher("/Vistas/agregarVehiculo.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("mensaje", "No se pudo agregar usuarios" + e.getMessage());
        }
    }

    private void registrarVehiculo(HttpServletRequest request, HttpServletResponse response) {
        DaoTransporte vehiculoDAO = null;
        transporte vehiculo = null;
        usuarios usuConductor;

        if (request.getParameter("seleccionConductor") != null
                && request.getParameter("txtMarca") != null
                && request.getParameter("txtModelo") != null
                && request.getParameter("txtAnio") != null
                && request.getParameter("txtPlaca") != null
                && request.getParameter("txtMantenimiento") != null) {

            vehiculo = new transporte();
            vehiculo.setMarca(request.getParameter("txtMarca"));
            vehiculo.setModelo(request.getParameter("txtModelo"));
            vehiculo.setAnio(2005);
            vehiculo.setNumeroPlaca(request.getParameter("txtPlaca"));
            vehiculo.setEstadoMantenimiento(request.getParameter("txtMantenimiento"));
            
            usuConductor = new usuarios();
            usuConductor.setId_usuario(Integer.parseInt(request.getParameter("seleccionConductor")));
            vehiculo.setId_Conductor(usuConductor);

            if (request.getParameter("chkEstado") != null) {
                vehiculo.setEstado(true);
            } else {
                vehiculo.setEstado(false);
            }

            vehiculoDAO = new DaoTransporte();
            try {
                vehiculoDAO.registrarVehiculo(vehiculo);
                response.sendRedirect("SvUsuarios?accion=listarUsuarios");
            } catch (Exception e) {
                request.setAttribute("msje",
                        "No se pudo registrar el usuario" + e.getMessage());
                request.setAttribute("usuario", vehiculo);
                this.mostrarFormVehiculo(request, response);
            }

        }
    }
}
