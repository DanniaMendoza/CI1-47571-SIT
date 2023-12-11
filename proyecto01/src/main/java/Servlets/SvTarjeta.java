/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Entidades.Tarjeta;
import Entidades.rutas;
import Entidades.transporte;
import Entidades.usuarios;
import Modelo.DaoRuta;
import Modelo.DaoTarjeta;
import Modelo.DaoTransporte;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author usuario
 */
@WebServlet(name ="SvTarjeta", urlPatterns= {"/SvTarjeta"})
public class SvTarjeta extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            
            String accion=request.getParameter("accion");
            List<Tarjeta>tarjetas= new ArrayList<>();
            List<rutas>rutas= new ArrayList<>();
            List<transporte>transportes = new ArrayList<>();
            HttpSession session1 = request.getSession();
            usuarios pasajero = (usuarios) session1.getAttribute("pasajero");
            int id = pasajero.getId_usuario();
            
            switch(accion){
                
                case "principal":
                    request.getRequestDispatcher("/Vistas/CompraTarjeta.jsp").forward(request, response);
                    
                    break;
                case "pYape":
                    request.getRequestDispatcher("/Vistas/Yape.jsp").forward(request, response);
                    break;
                    
                case "pContado":
                    request.getRequestDispatcher("/Vistas/PagoContado.jsp").forward(request, response);
                    break;
                    
                    
                case "agregar":
                    int r=0;
                    
                    System.out.println("ID del pasajero: " + id);
                    
                    int aleatorio = 0;
                    aleatorio = (int) (Math.random() * 1000);
                    String nt = "TJS" + aleatorio;
                    double monto = 0.0;
                    String estado = "1";
                    int idPersona = id;
                    Tarjeta t = new Tarjeta();
                    t.setCodigoTarjeta(nt);
                    t.setMonto(monto);
                    t.setEstado(estado);
                    
                    //
                    usuarios usuario = new usuarios();
                    usuario.setId_usuario(id);
                    t.setUsuario(usuario);
                    DaoTarjeta dao1=new DaoTarjeta();
                    r = dao1.add(t);
                    
                            final String mensajeTarjetaCompra="Usted ha adquirido una nueva tarjeta con el codigo: "+nt;
                            final String userName = "medinamenachomilton@gmail.com"; //same fromMail
                            final String password = "mwmumvsvnzgbkbsd";
                            final String toEmail = "dark_templar_1@hotmail.com";

                            System.out.println("TLSEmail Start");
                            Properties props = new Properties();
                            props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
                            props.put("mail.smtp.port", "587"); //TLS Port
                            props.put("mail.smtp.auth", "true"); //enable authentication
                            props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS


                            //Session session = Session.getDefaultInstance(props);
                            Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                                protected PasswordAuthentication getPasswordAuthentication() {

                                    return new PasswordAuthentication(userName, password);

                                }
                            });

                            try{
                                MimeMessage message = new MimeMessage(session);
                                message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail, true));
                                message.setSubject("Compra de Tarjeta");
                                message.setText(mensajeTarjetaCompra);
                                System.out.println("sending...");
                                Transport.send(message);
                                System.out.println("Sent message successfully....");

                            }catch (MessagingException me){
                                System.out.println("Exception: "+me);

                            }
                    
                    
                    
                    
                    
                    
                    
                    if (r != 0) {
                        request.setAttribute("config", "alert alert-success");
                        request.setAttribute("mensaje", "Se agrego con exito");
                        request.getRequestDispatcher("/Vistas/mensaje.jsp").forward(request, response);
                    } else {
                        request.setAttribute("config", "alert alert-danger");
                        request.setAttribute("mensaje", "Error al guardar en la base de datos");
                        request.getRequestDispatcher("/Vistas/mensaje.jsp").forward(request, response);
                    }
                    
                    break;
                    
                case "carga":
                    DaoTarjeta dao2 =new DaoTarjeta();
                    tarjetas=dao2.getTarjetasP(id);
                    request.setAttribute("Tarjetas",tarjetas);
                    request.getRequestDispatcher("Vistas/Carga.jsp").forward(request, response);
                    break;
                    
                case "consultarSaldoC":
                    
                    String nroTarjeta=request.getParameter("nroTarjeta");
                    int Id=Integer.parseInt(nroTarjeta);
                    System.out.println("El resultado muestra aqui:"+nroTarjeta);
                    DaoTarjeta dao3=new DaoTarjeta();
                    Tarjeta tarjeta= dao3.getId(Id);
                    //Obtener informacion de Tarjeta seleccionada
                    request.setAttribute("tarjeta",tarjeta );
                    //Obtener la lista de tarjetas
                    DaoTarjeta dao4 =new DaoTarjeta();
                    tarjetas=dao4.getTarjetasP(id);
                    request.setAttribute("Tarjetas",tarjetas);
                    
                    request.getRequestDispatcher("/Vistas/ConsultarSaldoC.jsp").forward(request, response);
                    
                    break;
                    
                case "realizarCarga":
                    int r1=0;
                    int r2=0;
                    double Monto1=0.00;
                    String idT=request.getParameter("nroTarjeta");
                    int Id1=Integer.parseInt(idT);
                    String monto1=request.getParameter("monto");
                    Monto1=Double.parseDouble(monto1);
                    LocalDate fecha = LocalDate.now();
                    DaoTarjeta dao5= new DaoTarjeta();
                    r1=dao5.addCarga(Monto1, Id1, fecha);
                    DaoTarjeta dao6= new DaoTarjeta();
                    r2=dao6.updateTarjeta(Id1, Monto1);
                    if (r2 != 0 && r1 != 0) {
                        
                        request.setAttribute("config", "alert alert-success");
                        request.setAttribute("mensaje", "Se realizo la carga con exito");
                        request.getRequestDispatcher("/Vistas/mensaje.jsp").forward(request, response);
                    } else {
                        request.setAttribute("config", "alert alert-danger");
                        request.setAttribute("mensaje", "Error, no se pudo realizar la carga");
                        request.getRequestDispatcher("/Vistas/mensaje.jsp").forward(request, response);
                    }
                    
                    break;
                    
                case "cobro":
                    DaoTarjeta dao7=new DaoTarjeta();
                    tarjetas=dao7.getTarjetasP(id);
                    request.setAttribute("Tarjetas",tarjetas);
                    
                    
                    DaoRuta dao8= new DaoRuta();
                    rutas=dao8.listarRutas();
                    request.setAttribute("Rutas",rutas);
                    
                    DaoTransporte dao9= new DaoTransporte();
                    transportes= dao9.listarTransporte();
                    request.setAttribute("Transportes", transportes);
                    
                    
                    
                    request.getRequestDispatcher("/Vistas/Cobrop.jsp").forward(request, response);
                    
                    break;
                    
                case "ConsultarSaldoCobro" :
                
                String NroTarjeta=request.getParameter("nroTarjeta");
                int Id2=Integer.parseInt(NroTarjeta);
                System.out.println("El resultado muestra aqui:"+NroTarjeta);
                DaoTarjeta dao10=new DaoTarjeta();
                Tarjeta tarjeta1= dao10.getId(Id2);
                //Obtener informacion de Tarjeta seleccionada
                request.setAttribute("tarjeta1",tarjeta1 );
                
                String idRuta= request.getParameter("nroRuta");
                System.out.println("Tu resultado es :"+idRuta);
                int idr=Integer.parseInt(idRuta);
                System.out.println("es"+idr);
                DaoRuta dao11= new DaoRuta();
                rutas ruta= dao11.getId(idr);
                Double imprimir = ruta.getTarifa();
                System.out.println("El costo es :"+imprimir);
                //Obtener informacion de Tarjeta seleccionada
                request.setAttribute("Ruta",ruta );
                
                 DaoTarjeta dao12=new DaoTarjeta();
                tarjetas=dao12.getTarjetasP(id);
                request.setAttribute("Tarjetas",tarjetas);
                
                
                DaoRuta dao13= new DaoRuta();
                rutas=dao13.listarRutas();
                request.setAttribute("Rutas",rutas);
                
                DaoTransporte dao14= new DaoTransporte();
                transportes= dao14.listarTransporte();
                request.setAttribute("Transportes", transportes);
                
                request.getRequestDispatcher("/Vistas/ConsultarSaldoCobro.jsp").forward(request,response);
                
                break;  
                
                
                 case "pagar":
                int r20=0;
                String idTar=request.getParameter("nroTarjeta");
                int Idt=Integer.parseInt(idTar);//obtenemos el id de la Tarjeta seleccionada
                String idRuta1= request.getParameter("nroRuta");
                System.out.println("Tu resultado es :"+idRuta1);
                int idr1=Integer.parseInt(idRuta1);//obtenemos  el id de la ruta seleccionada
                System.out.println("es"+idr1);
                DaoRuta dao20= new DaoRuta();
                rutas rutaC= dao20.getId(idr1);
                Double resultado= rutaC.getTarifa();
                DaoTarjeta dao21= new DaoTarjeta();
                r20=dao21.updateTarjetaM(Idt, resultado);
                if (r20 != 0) {
                    request.setAttribute("config", "alert alert-success");
                    request.setAttribute("mensaje", "Se realizo el pago con exito");
                    request.getRequestDispatcher("/Vistas/mensaje.jsp").forward(request, response);
                } else {
                    request.setAttribute("config", "alert alert-danger");
                    request.setAttribute("mensaje", "Error, el pago no se realizo");
                    request.getRequestDispatcher("/Vistas/mensaje.jsp").forward(request, response);
                }
                
                
                break;
                    
                case "reporte":
                    request.getRequestDispatcher("PruebaR.jsp").forward(request, response);
                    break;
                    
            }
        } catch (Exception ex) {
            Logger.getLogger(SvTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
