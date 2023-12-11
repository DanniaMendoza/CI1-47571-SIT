package Servlets;

import Entidades.usuarios;
import Entidades.roles;
import Modelo.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvUsuarios", urlPatterns
        = {
            "/SvUsuarios"
        })
public class SvUsuarios extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        try {
            if (accion != null) {
                switch (accion) {
                    case "verificar":
                        verificar(request, response);
                        break;
                    case "cerrar":
                        cerrarsesion(request, response);
                        break;
                    case "listarUsuarios":
                        listarUsuarios(request, response);
                        break;
                    case "mostrarFormulario":
                        mostrarFormulario(request, response);
                        break;
                    case "registrarUsuario":
                        registrarUsuario(request, response);
                        break;
                    case "actualizarUsuario":
                        actualizarUsuario(request, response);
                        break;
                    case "eliminarUsuario":
                        eliminarUsuario(request, response);
                        break;
                    case "listarRoles":
                        listarRoles(request, response);
                        break;
                    case "leerUsuario":
                        leerUsuario(request, response);
                        break;
                    case "paginaInicio":
                        paginaInicio(request, response);
                        break;
                    case "mostrarFormulario2":
                        mostrarFormulario2(request, response);
                        break;
                    case "registrarUsuario2":
                        registrarUsuario2(request, response);
                        break;
                        
                    default:
                        response.sendRedirect("index.jsp");
                }

            } else {
                response.sendRedirect("index.jsp");
            }

        } catch (Exception e) {
            try {
                this.getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
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

    private void verificar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession sesion;
        DaoUsuario daousuario;//acceso a datos de usuario
        usuarios usuario;//almacenar la información del usuario
        usuario = this.obtenerUsuario(request);// Obtenemos los datos del usuario soli
        daousuario = new DaoUsuario();// instanciamos dao

        usuario = daousuario.identificar(usuario);// Busca el usuario en la base de datos
        // Verifica el rol del usuario obtenido de la base de datos
        if (usuario != null && usuario.getRol().getNombreRol().equals("Administrador")) {
            sesion = request.getSession();
            sesion.setAttribute("usuario", usuario);
            request.setAttribute("msje", "Bienvenido al SIT");
            this.getServletConfig().getServletContext().getRequestDispatcher("/Vistas/principalAdministrador.jsp").forward(request, response);

        } else if (usuario != null && usuario.getRol().getNombreRol().equals("Pasajero")) {// Si el usuario es un Pasajero, se redirige a la página de compra de tarjetas
            sesion = request.getSession();
            sesion.setAttribute("pasajero", usuario);
            this.getServletConfig().getServletContext().getRequestDispatcher("/Vistas/CompraTarjeta.jsp").forward(request, response);

        } else {// Si no se encuentra el rol o no corresponde a ninguno de los roles esperados, se muestra un mensaje de error.
            request.setAttribute("mensaje", "Credenciales incorrectas");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }

    private void cerrarsesion(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession sesion = request.getSession();
        sesion.setAttribute("usuario", null);
        sesion.invalidate();
        response.sendRedirect("index.jsp");
    }

    private usuarios obtenerUsuario(HttpServletRequest request) {
        usuarios datosUsuario = new usuarios();
        datosUsuario.setDni(request.getParameter("txtUsuario"));
        datosUsuario.setClave(request.getParameter("txtClave"));
        return datosUsuario;
    }

    private void listarUsuarios(HttpServletRequest request, HttpServletResponse response) {
        DaoUsuario dao = new DaoUsuario(); // Se crea un objeto DaoUsuario para acceder a los datos de usuario
        List<usuarios> listausuarios = null; //Inicializamos la Lista de usuarios como nula
        try {
            listausuarios = dao.listarUsuarios();//obtiene la lista de usuarios desde la BD
            request.setAttribute("listarUsuarios", listausuarios);

        } catch (Exception e) {
            request.setAttribute("mensaje", "No se pudo listar usuarios" + e.getMessage());
        } finally {
            dao = null; // Se establece el objeto DaoUsuario como nulo en el bloque finally para liberar recursos
        }

        try {
            this.getServletConfig().getServletContext().getRequestDispatcher("/Vistas/usuarios.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("mensaje", "No se pudo listar usuarios" + ex.getMessage());
        }
    }

    private void mostrarFormulario(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.cargarRoles(request);
            this.getServletConfig().getServletContext().getRequestDispatcher("/Vistas/agregarUsuario.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("mensaje", "No se pudo agregar usuarios" + e.getMessage());
        }
    }

    private void paginaInicio(HttpServletRequest request, HttpServletResponse response) {
        try {

            this.getServletConfig().getServletContext().getRequestDispatcher("/Vistas/principalAdministrador.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("mensaje", "No se redireccionar a pagina de inicio" + e.getMessage());
        }
    }

    private void cargarRoles(HttpServletRequest request) {
        DaoRol daoRol = new DaoRol();
        List<roles> rolesLista = null;
        try {
            rolesLista = daoRol.listarRoles();
            request.setAttribute("roles", rolesLista);
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo cargar los roles :( " + e.getMessage());
        } finally {
            rolesLista = null;
            daoRol = null;
        }
    }

    private void registrarUsuario(HttpServletRequest request, HttpServletResponse response) {
        DaoUsuario usuDAO = null;
        usuarios usu = null;
        roles rol;

        if (request.getParameter("txtNombre") != null
                && request.getParameter("txtApePa") != null
                && request.getParameter("txtApeMa") != null
                && request.getParameter("txtDni") != null
                && request.getParameter("txtCorreo") != null
                && request.getParameter("txtTelefono") != null
                && request.getParameter("txtClave") != null
                && request.getParameter("seleccionRol") != null) {

            usu = new usuarios();
            usu.setNombreUsuario(request.getParameter("txtNombre"));
            usu.setApellidoPaterno(request.getParameter("txtApePa"));
            usu.setApellidoMaterno(request.getParameter("txtApeMa"));
            usu.setDni(request.getParameter("txtDni"));
            usu.setCorreo(request.getParameter("txtCorreo"));
            usu.setTelefono(request.getParameter("txtTelefono"));
            usu.setClave(request.getParameter("txtClave"));

            rol = new roles();
            rol.setIdRol(Integer.parseInt(request.getParameter("seleccionRol")));
            usu.setRol(rol);

            if (request.getParameter("chkEstado") != null) {
                usu.setEstado(true);
            } else {
                usu.setEstado(false);
            }

            usuDAO = new DaoUsuario();
            try {
                usuDAO.registrarUsuario(usu);
                response.sendRedirect("SvUsuarios?accion=listarUsuarios");
            } catch (Exception e) {
                request.setAttribute("msje",
                        "No se pudo registrar el usuario" + e.getMessage());
                request.setAttribute("usuario", usu);
                this.mostrarFormulario(request, response);
            }

        }
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

    private void leerUsuario(HttpServletRequest request, HttpServletResponse response) {
        DaoUsuario usuarioDao;
        usuarios usuar;

        if (request.getParameter("cod") != null) {
            usuar = new usuarios();

            usuar.setId_usuario(Integer.parseInt(request.getParameter("cod")));

            usuarioDao = new DaoUsuario();
            try {
                usuar = usuarioDao.leerUsuario(usuar);
                if (usuar != null) {
                    request.setAttribute("usuEditar", usuar);
                } else {
                    request.setAttribute("msje", "No se encontró el usuario");
                }
            } catch (Exception e) {
                request.setAttribute("msje", "No se pudo acceder a la base de datos" + e.getMessage());
            }
        } else {
            request.setAttribute("msje", "No se tiene el parámetro necesario");
        }
        try {
            this.cargarRoles(request);
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/Vistas/actualizarUsuario.jsp"
                    ).forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo realizar la operacion" + e.getMessage());
        }

    }

    private void actualizarUsuario(HttpServletRequest request, HttpServletResponse response) {
        DaoUsuario daoUsu;
        usuarios usus = null;
        roles rol;

        if (request.getParameter("hCodigo") != null
                && request.getParameter("txtNombre") != null
                && request.getParameter("txtApePa") != null
                && request.getParameter("txtApeMa") != null
                && request.getParameter("txtDni") != null
                && request.getParameter("txtCorreo") != null
                && request.getParameter("txtTelefono") != null
                && request.getParameter("txtClave") != null
                && request.getParameter("chkEstado") != null
                && request.getParameter("seleccionRol") != null) {

            usus = new usuarios();
            usus.setId_usuario(Integer.parseInt(request.getParameter("hCodigo")));
            usus.setNombreUsuario(request.getParameter("txtNombre"));
            usus.setApellidoPaterno(request.getParameter("txtApePa"));
            usus.setApellidoMaterno(request.getParameter("txtApeMa"));
            usus.setDni(request.getParameter("txtDni"));
            usus.setCorreo(request.getParameter("txtCorreo"));
            usus.setTelefono(request.getParameter("txtTelefono"));
            usus.setClave(request.getParameter("txtClave"));

            rol = new roles();
            rol.setIdRol(Integer.parseInt(request.getParameter("seleccionRol")));
            usus.setRol(rol);

            if (request.getParameter("chkEstado") != null) {
                usus.setEstado(true);
            } else {
                usus.setEstado(false);
            }

            daoUsu = new DaoUsuario();
            try {
                daoUsu.actualizarUsuarios(usus);
                response.sendRedirect("SvUsuarios?accion=listarUsuarios");
            } catch (Exception e) {
                request.setAttribute("msje",
                        "No se pudo registrar el usuario" + e.getMessage());
                request.setAttribute("usuario", usus);

            }
            try {
                this.cargarRoles(request);
                this.getServletConfig().getServletContext().
                        getRequestDispatcher("/Vistas/actualizarUsuario.jsp"
                        ).forward(request, response);
            } catch (Exception ex) {
                request.setAttribute("msje", "No se pudo realizar la operacion" + ex.getMessage());
            }

        }

    }

    private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) {
        DaoUsuario dao = new DaoUsuario();
        usuarios usus = new usuarios();
        if (request.getParameter("cod") != null) {
            usus.setId_usuario(Integer.parseInt(request.getParameter("cod")));
            try {
                dao.eliminarUsuario(usus);
                response.sendRedirect("SvUsuarios?accion=listarUsuarios");
            } catch (Exception e) {
                request.setAttribute("msje",
                        "No se pudo registrar el usuario" + e.getMessage());
                request.setAttribute("usuario", usus);
                this.mostrarFormulario(request, response);
            }
        }
    }

    private void mostrarFormulario2(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.cargarRoles(request);
            this.getServletConfig().getServletContext().getRequestDispatcher("/Vistas/agregarUsuario2.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("mensaje", "No se pudo agregar usuarios" + e.getMessage());
        }
    }

    private void registrarUsuario2(HttpServletRequest request, HttpServletResponse response) {
        DaoUsuario usuDAO = null;
        usuarios usu = null;
        roles rol;

        if (request.getParameter("txtNombre") != null
                && request.getParameter("txtApePa") != null
                && request.getParameter("txtApeMa") != null
                && request.getParameter("txtDni") != null
                && request.getParameter("txtCorreo") != null
                && request.getParameter("txtTelefono") != null
                && request.getParameter("txtClave") != null
                && request.getParameter("seleccionRol") != null) {

            usu = new usuarios();
            usu.setNombreUsuario(request.getParameter("txtNombre"));
            usu.setApellidoPaterno(request.getParameter("txtApePa"));
            usu.setApellidoMaterno(request.getParameter("txtApeMa"));
            usu.setDni(request.getParameter("txtDni"));
            usu.setCorreo(request.getParameter("txtCorreo"));
            usu.setTelefono(request.getParameter("txtTelefono"));
            usu.setClave(request.getParameter("txtClave"));

            rol = new roles();
            rol.setIdRol(Integer.parseInt(request.getParameter("seleccionRol")));
            usu.setRol(rol);

            if (request.getParameter("chkEstado") != null) {
                usu.setEstado(true);
            } else {
                usu.setEstado(false);
            }

            usuDAO = new DaoUsuario();
            try {
                usuDAO.registrarUsuario(usu);
                response.sendRedirect("SvUsuarios?accion=verificar");
            } catch (Exception e) {
                request.setAttribute("msje",
                        "No se pudo registrar el usuario" + e.getMessage());
                request.setAttribute("usuario", usu);
                this.mostrarFormulario(request, response);
            }

        }
    }

}
