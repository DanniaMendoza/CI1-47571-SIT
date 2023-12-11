<%-- 
    Document   : Cobrop
    Created on : 7 dic. 2023, 02:27:02
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Entidades.rutas"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
     rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" 
     crossorigin="anonymous">
    <link rel="stylesheet" href="css/CompraTarjeta.css">
    <title>Cobro</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
    integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
    crossorigin="anonymous"></script>
</head>

    <body>
        <div>
        <nav class="navbar bg-primary  navbar-expand-lg bg-body-tertiary"  data-bs-theme="dark">
            <div class="container-fluid">
              <a class="navbar-brand" href="#">SIT</a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                  <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="#">Quienes Somos</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="#">Mision</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="#">Vision</a>
                  </li>
                  <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      Actividades
                    </a>
                    <ul class="dropdown-menu">
                      <li><a class="dropdown-item" href="CompraTarjeta.jsp">Compra de Tarjeta</a></li>
                      <li><a class="dropdown-item" href="Carga.jsp">Cargar tarjeta</a></li>
                      <li><a class="dropdown-item" href="Cobrop.jsp">Cobro de tarjeta</a></li>
                    </ul>
                  </li>
                </ul>
              </div>
            </div>
          </nav>
    </div >
    
    
    
    
    
    
    <div class="bloque">

        <section class="aviso">
            <img class="aviso__imagen1" src="imagenes2/pngtree-beautiful-payment-method-vector-glyph-icon-png-image_1870008.jpg" alt="" height="400">
        </section>

        <section class="contenedorP">
            <form action="SvTarjeta" method="POST">
              
                <h2 class="contenedorP__h2">Pago con Tarjeta</h2>
                <div class="contenedorP__inputbox">
                    <ion-icon name="card-outline"></ion-icon>
                    <label for="">Codigo Tarjeta</label>
                                    
                    <input type="text" name="codigoT" >
                    <select name="nroTarjeta">
                        <option>Seleccionar tarjeta</option>
                        <c:forEach var="tarjeta" items="${Tarjetas}">
                            <option value="${tarjeta.id_Tarjeta}">${tarjeta.codigoTarjeta}</option>
                        </c:forEach>   
                    </select>

                </div>
                
                
                
                <div class="contenedorP__inputbox">
                    <ion-icon name="arrow-down-outline"></ion-icon>
                    <label for="">Ruta Destino</label>
                                    
                    <input type="text" name="rutaD" >
                        <select name="nroRuta">
                        <option>Seleccionar ruta</option>
                        <c:forEach var="ruta" items="${Rutas}">
                            <option value="${ruta.id_ruta}">${ruta.origen}</option>
                        </c:forEach>
                        </select>
                </div> 
                
                <div class="contenedorP__inputbox">
                    <ion-icon name="bus-outline"></ion-icon>
                    <label for="">Vehiculo</label>
                                    
                    <input type="text" name="TRANSPORTE" >
                        <select name="nroTransporte">
                        <option>Seleccionar transporte</option>
                        <c:forEach var="transporte" items="${Transportes}">
                            <option value="${transporte.id_Vehiculo}">${transporte.numeroPlaca}</option>
                        </c:forEach>
                        </select>
                </div>
     

               
                
                <button type="submit" name="accion" value="pagar">Aceptar</button>
                <button type="submit" name="accion" value="ConsultarSaldoCobro">Consultar</button>
                <button name="registro">Cancelar</button>
            </form>
    

            

          
        </section>

        

    </div>
    
    
    
    
    

    <!--pie pagina (footer)-->


    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
    
        
        
        
        
        
        <h1>Hello World!</h1>
    </body>
</html>
